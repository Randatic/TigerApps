package randatic.github.io.tigerapps.Presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import randatic.github.io.tigerapps.R;

/**
 * Created by Randy Bruner on 2/2/2017.
 */

public class AppActivity extends AppCompatActivity {

    private Button installButton;
    private ImageView bannerIV, iconIV;
    private ProgressBar progressBar;
    private TextView titleTV, descriptionTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        wireWidgets();
    }

    private void wireWidgets() {
        installButton = (Button) findViewById(R.id.app_button_install);
        bannerIV = (ImageView) findViewById(R.id.app_imageView_banner);
        iconIV = (ImageView) findViewById(R.id.app_imageView_icon);
        progressBar = (ProgressBar) findViewById(R.id.app_progressBar);
        titleTV = (TextView) findViewById(R.id.app_textView_appName);
        descriptionTV = (TextView) findViewById(R.id.app_textView_description);
    }
}
