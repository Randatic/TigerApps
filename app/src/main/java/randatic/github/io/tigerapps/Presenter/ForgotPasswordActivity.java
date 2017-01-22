package randatic.github.io.tigerapps.Presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import randatic.github.io.tigerapps.R;

/**
 * Created by Randy Bruner on 1/19/2017.
 */

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button submitButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        Backendless.initApp(this, "E11215CD-D330-8580-FFB1-982FAAFB6F00", "E181E341-2B7A-F352-FFE8-219DC2BC2200", "v1");

        emailEditText = (EditText) findViewById(R.id.forgotAccount_editText_email);
        submitButton = (Button) findViewById(R.id.forgotAccount_button_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Backendless.UserService.restorePassword(emailEditText.getText().toString().trim(), new AsyncCallback<Void>() {
                    @Override
                    public void handleResponse(Void response) {
                        Toast.makeText(ForgotPasswordActivity.this, "Password Reset Link Sent to Email", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(ForgotPasswordActivity.this, ""+fault.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
