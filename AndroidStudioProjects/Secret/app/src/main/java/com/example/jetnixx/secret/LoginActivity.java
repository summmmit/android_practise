package com.example.jetnixx.secret;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView create_account_Click, forgot_password_Click;
    private EditText mPassword;
    private AutoCompleteTextView mEmail;
    private CheckBox login_checkBox_remember_me;
    private Button login_sign_in_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (AutoCompleteTextView) findViewById(R.id.login_edit_field_email);
        mPassword = (EditText) findViewById(R.id.login_edit_field_password);

        login_checkBox_remember_me = (CheckBox) findViewById(R.id.login_checkBox_remember_me);
        login_sign_in_button = (Button) findViewById(R.id.login_sign_in_button);

        login_sign_in_button.setOnClickListener(this);

        forgot_password_Click = (TextView) findViewById(R.id.login_text_forgot_password);
        forgot_password_Click.setOnClickListener(this);

        create_account_Click = (TextView) findViewById(R.id.login_text_create_account);
        create_account_Click.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()) {
            case R.id.login_text_forgot_password:

                intent = new Intent(this, ForgotPasswordActivity.class);
                startActivity(intent);

                break;
            case R.id.login_text_create_account:

                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);

                break;
            case R.id.login_sign_in_button:
                attemptLogin();

                break;
        }
    }

    private void attemptLogin() {

        // Reset errors.
        mEmail.setError(null);
        mPassword.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPassword.setError(getString(R.string.error_invalid_password));
            focusView = mPassword;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmail.setError(getString(R.string.error_field_required));
            focusView = mEmail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmail.setError(getString(R.string.error_invalid_email));
            focusView = mEmail;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {

            checkEmailAndPassword();                                // check here for the email and password from the database
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    private void checkEmailAndPassword() {
    }
}
