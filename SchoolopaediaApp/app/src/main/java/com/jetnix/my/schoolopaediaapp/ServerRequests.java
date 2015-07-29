package com.jetnix.my.schoolopaediaapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by 1084760 on 2015/07/29.
 */
public class ServerRequests {

    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 1000 * 15;
    public static final String SERVER_ADDRESS = "http://10.0.2.2/projects/android/AndroidToPhpConnect/";

    public ServerRequests(Context context){

        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing...");
        progressDialog.setMessage("Please wait...");
    }

    public void storeUserDataInBackground(Users user, GetUserCallback userCallBack) {
        progressDialog.show();
        new StoreUserDataAsyncTask(user, userCallBack).execute();
    }

    private class StoreUserDataAsyncTask extends AsyncTask<Void, Void, Void> {

        Users users;
        GetUserCallback getUserCallback;

        public StoreUserDataAsyncTask(Users users, GetUserCallback userCallBack) {
            this.users = users;
            this.getUserCallback = userCallBack;
        }

        @Override
        protected Void doInBackground(Void... params) {

            String link= "http://10.0.2.2/projects/schoolopaedia/public/mobile/user/account/create/post";
            String data  = null;
            try {
                data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(users.email, "UTF-8");
                data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(users.password, "UTF-8");
                data += "&" + URLEncoder.encode("password_again", "UTF-8") + "=" + URLEncoder.encode(users.password_again, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            Log.v("users", data);

            StringBuilder sb = new StringBuilder();
            String line = null;

            try {

                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write(data);
                wr.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                // Read Server Response
                while((line = reader.readLine()) != null)
                {
                    sb.append(line);
                    break;
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

            Log.d("result", sb+"");

            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
            getUserCallback.done(null);
        }
    }
}
