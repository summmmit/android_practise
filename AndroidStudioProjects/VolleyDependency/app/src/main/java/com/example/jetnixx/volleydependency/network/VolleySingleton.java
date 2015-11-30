package com.example.jetnixx.volleydependency.network;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.jetnixx.volleydependency.MyApplication;

/**
 * Created by 1084760 on 2015/11/30.
 */
public class VolleySingleton {

    private static VolleySingleton sInstance = null;
    private RequestQueue mRequestQueue;

    private VolleySingleton(){
        mRequestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
    }

    public static VolleySingleton getsInstance() {

        if(sInstance == null){
            sInstance = new VolleySingleton();
        }

        return sInstance;
    }

    public RequestQueue getRequestQueue(){
        return mRequestQueue;
    }
}
