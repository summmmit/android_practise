package com.example.jetnixx.secret;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView sign_in_Click;
    private EditText mPassword;
    private AutoCompleteTextView mEmail, mFirstName, mLastName;
    private CheckBox register_checkBox_agree;
    private Button register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmail = (AutoCompleteTextView) findViewById(R.id.register_edit_field_email);
        mPassword = (EditText) findViewById(R.id.register_edit_field_password);
        mFirstName = (AutoCompleteTextView) findViewById(R.id.register_edit_field_first_name);
        mLastName = (AutoCompleteTextView) findViewById(R.id.register_edit_field_last_name);

        register_checkBox_agree = (CheckBox) findViewById(R.id.register_checkBox_agree);

        register_button = (Button) findViewById(R.id.register_button);
        register_button.setOnClickListener(this);

        sign_in_Click = (TextView) findViewById(R.id.register_text_sign_in);
        sign_in_Click.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()){

            case R.id.register_text_sign_in:

                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.register_button:
                attemptLogin();
                break;
        }
    }

    private void attemptLogin() {

        // Reset errors.
        mEmail.setError(null);
        mPassword.setError(null);
        mFirstName.setError(null);
        register_checkBox_agree.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        String firstName = mFirstName.getText().toString();
        String registerCheckBoxAgree = register_checkBox_agree.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check if check box is checked.
        if (TextUtils.isEmpty(registerCheckBoxAgree)) {
            register_checkBox_agree.setError(getString(R.string.error_agree_on_terms));
            focusView = register_checkBox_agree;
            cancel = true;
        }

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password) && !isPasswordValid(password)) {
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

        // Check for a valid First Name, if the user entered one.
        if (TextUtils.isEmpty(firstName)) {
            mFirstName.setError(getString(R.string.error_invalid_first_name));
            focusView = mFirstName;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {

            registerUser();                                // check here for the email and password from the database
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    private void registerUser() {
    }
}
