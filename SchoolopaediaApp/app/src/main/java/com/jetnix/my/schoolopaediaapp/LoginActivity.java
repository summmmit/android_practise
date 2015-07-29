package com.jetnix.my.schoolopaediaapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends ActionBarActivity implements View.OnClickListener {

    EditText email_field, password_field;
    TextView forgot_password_text_view;
    Button sign_in_button, facebook_button, google_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        email_field = (EditText) findViewById(R.id.email_field);
        password_field = (EditText) findViewById(R.id.password_field);

        forgot_password_text_view = (TextView) findViewById(R.id.forgot_password_text_view);

        forgot_password_text_view.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forgot_password_text_view:
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
                break;
        }
    }
}
