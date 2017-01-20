package randatic.github.io.tigerapps.Presenter;

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
public class CreateAccountActivity extends AppCompatActivity {
    private EditText emailEditText, passwordEditText, confirmPasswordEditText, firstNameEditText, lastNameEditText;
    private Button submitButton;
    private BackendlessUser user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        wireWidgets();
        Backendless.initApp(this, "E11215CD-D330-8580-FFB1-982FAAFB6F00", "E181E341-2B7A-F352-FFE8-219DC2BC2200", "v1");
        user = new BackendlessUser();
    }

    private void submit() {
        if(emailEditText.getText().toString().trim().equals("") ||
                passwordEditText.getText().toString().trim().equals("")||
                confirmPasswordEditText.getText().toString().trim().equals("") ||
                firstNameEditText.getText().toString().trim().equals("") ||
                lastNameEditText.getText().toString().trim().equals("")) {
            Toast.makeText(this, R.string.empty_fields, Toast.LENGTH_SHORT).show();
        } else if (!passwordEditText.getText().toString().trim().equals(confirmPasswordEditText.getText().toString().trim())) {
            Toast.makeText(this, R.string.passwords_not_matching, Toast.LENGTH_SHORT).show();
        } else {
            user.setEmail(emailEditText.getText().toString().trim());
            user.setPassword(passwordEditText.getText().toString().trim());
            user.setProperty("first_name", firstNameEditText.getText().toString().trim());
            user.setProperty("last_name", lastNameEditText.getText().toString().trim());
            Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                @Override
                public void handleResponse(BackendlessUser response) {
                    Toast.makeText(CreateAccountActivity.this, R.string.account_created_successful, Toast.LENGTH_SHORT).show();
                    Intent i =  new Intent();
                    i.putExtra(LoginActivity.ACCOUNT, emailEditText.getText().toString().trim());
                    setResult(RESULT_OK, i);
                    finish();
                }

                @Override
                public void handleFault(BackendlessFault fault) {
                    Toast.makeText(CreateAccountActivity.this, ""+fault.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void wireWidgets() {
        emailEditText = (EditText) findViewById(R.id.createAccount_editText_email);
        passwordEditText = (EditText) findViewById(R.id.createAccount_editText_password);
        confirmPasswordEditText = (EditText) findViewById(R.id.createAccount_editText_passwordConfirm);
        firstNameEditText = (EditText) findViewById(R.id.createAccount_editText_firstName);
        lastNameEditText = (EditText) findViewById(R.id.createAccount_editText_lastName);

        submitButton = (Button) findViewById(R.id.createAccount_button_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }
}
