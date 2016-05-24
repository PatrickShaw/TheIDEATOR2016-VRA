package com.ideator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
public class SignInActivity extends AppCompatActivity {
    public static Intent newIntent(Context context)
    {
        return new Intent(context, SignInActivity.class);
    }
    private EditText mEditEmail;
    private EditText mEditPassword;
    private Button mButtonSignIn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mEditEmail = (EditText)findViewById(R.id.edit_email);
        mEditPassword = (EditText)findViewById(R.id.edit_password);
        mButtonSignIn = (Button)findViewById(R.id.button_sign_in);
        mButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptSignIn();
                Intent intentToMain = MainActivity.newIntent(SignInActivity.this);
                startActivity(intentToMain);
            }
        });
    }
    private void attemptSignIn()
    {
        boolean signInFailed = false;
        if(TextUtils.isEmpty(mEditEmail.getText()))
        {
            mEditEmail.setError(getString(R.string.error_need_to_fill_in));
            signInFailed = true;
        }
        if(TextUtils.isEmpty(mEditPassword.getText()))
        {
            mEditEmail.setError(getString(R.string.error_need_to_fill_in));
            signInFailed = true;
        }
        if(!signInFailed)
        {
            signIn(mEditEmail.getText().toString(), mEditPassword.getText().toString());
        }
    }
    private void signIn(String username, String password)
    {
        // TODO: Do actual login
        Intent intentToMain = MainActivity.newIntent(this);
        startActivity(intentToMain);
        finishAffinity();
    }

}
