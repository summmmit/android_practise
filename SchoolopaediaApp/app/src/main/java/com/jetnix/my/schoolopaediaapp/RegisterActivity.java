package com.jetnix.my.schoolopaediaapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class RegisterActivity extends ActionBarActivity implements View.OnClickListener {

    EditText email_field, password_field, confirm_password_field;
    Button register_button;
    TextView login_text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email_field = (EditText) findViewById(R.id.email_field);
        password_field = (EditText) findViewById(R.id.password_field);
        confirm_password_field = (EditText) findViewById(R.id.confirm_password_field);

        register_button = (Button) findViewById(R.id.register_button);
        login_text_view = (TextView) findViewById(R.id.login_text_view);

        login_text_view.setOnClickListener(this);
        register_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.login_text_view:
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.register_button:

                String email = email_field.getText().toString();
                String password = password_field.getText().toString();
                String password_again = confirm_password_field.getText().toString();

                Users users = new Users(email, password_again, password);
                registerUser(users);
                break;
        }
    }

    private void registerUser(Users users) {
        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.storeUserDataInBackground(users, new GetUserCallback() {
            @Override
            public void done(Users returnedUser) {

                Log.v("in login", returnedUser+"");
            }
        });
    }
}
