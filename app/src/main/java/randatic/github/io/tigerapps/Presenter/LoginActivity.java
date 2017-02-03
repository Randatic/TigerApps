package randatic.github.io.tigerapps.Presenter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import randatic.github.io.tigerapps.R;

/**
 * Created by Randy Bruner on 1/19/2017.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{


    static final int PASSWORD_REQUESTED = 0;
    static final int ACCOUNT_CREATED = 1;
    static final String ACCOUNT = "created_account";

    private boolean loggedIn;

    private EditText emailEditText, passwordEditText;
    private Button logInButton, forgotPasswordButton, createAccountButton;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Backendless.initApp(this, "E11215CD-D330-8580-FFB1-982FAAFB6F00", "E181E341-2B7A-F352-FFE8-219DC2BC2200", "v1");

        wireWidgets();
        loggedIn = true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent i = null;
        switch(id){
            case(R.id.splash_button_login):progressDialog.show(); login(); break;
            case(R.id.splash_button_forgot_password):
                i = new Intent(this, ForgotPasswordActivity.class);
                startActivityForResult(i,PASSWORD_REQUESTED); break;
            case(R.id.splash_button_create_account):
                i = new Intent(this, CreateAccountActivity.class);
                startActivityForResult(i, ACCOUNT_CREATED); break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PASSWORD_REQUESTED) {
            if(resultCode == RESULT_OK) {

            }
        } else if (requestCode == ACCOUNT_CREATED) {
            if(resultCode == RESULT_OK) {
                emailEditText.setText(data.getStringExtra(ACCOUNT));
            }
        }
    }

    private void login() {
        if(emailEditText.getText().toString().trim().equals("") ||
                passwordEditText.getText().toString().trim().equals("")) {
            progressDialog.dismiss();
            Toast.makeText(this, R.string.empty_fields, Toast.LENGTH_SHORT).show();
        } else {
            Backendless.UserService.login(emailEditText.getText().toString().trim(), passwordEditText.getText().toString().trim(), new AsyncCallback<BackendlessUser>() {
                @Override
                public void handleResponse(BackendlessUser response) {
                    Toast.makeText(LoginActivity.this, "Login Successful.", Toast.LENGTH_SHORT).show();
                    /*AsyncCallback<Boolean> isValidLoginCallBack = new AsyncCallback<Boolean>() {
                        @Override
                        public void handleResponse(Boolean response) {
                            Toast.makeText(LoginActivity.this, "[ASYNC] Is login valid? - " + response, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {
                            Toast.makeText(LoginActivity.this, "Error - " + fault.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    };
                    Backendless.UserService.isValidLogin(isValidLoginCallBack);*/
                    loggedIn = true;
                }

                @Override
                public void handleFault(BackendlessFault fault) {
                    Toast.makeText(LoginActivity.this, ""+fault.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }

        progressDialog.dismiss();
        if(loggedIn) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }

    }

    private void wireWidgets() {
        emailEditText = (EditText) findViewById(R.id.splash_editText_email);
        passwordEditText = (EditText) findViewById(R.id.splash_editText_password);

        logInButton = (Button) findViewById(R.id.splash_button_login);
        forgotPasswordButton = (Button) findViewById(R.id.splash_button_forgot_password);
        createAccountButton = (Button) findViewById(R.id.splash_button_create_account);

        logInButton.setOnClickListener(this);
        forgotPasswordButton.setOnClickListener(this);
        createAccountButton.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Logging in, please wait. . .");
    }


}
