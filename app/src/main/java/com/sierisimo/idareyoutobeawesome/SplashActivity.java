package com.sierisimo.idareyoutobeawesome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sierisimo.idareyoutobeawesome.home.MainActivity;
import com.sierisimo.idareyoutobeawesome.login.LoginActivity;
import com.sierisimo.idareyoutobeawesome.util.KeysKt;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setVersionText(BuildConfig.VERSION_NAME);
    }

    @Override
    protected void onResume() {
        super.onResume();
        launchNextActivity();
    }

    private void setVersionText(String versionText) {
        ((TextView) findViewById(R.id.tv_splash_version)).setText(versionText);
    }

    private void launchNextActivity() {
        int timeInMillisecondToWait = 3000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Class activityToLaunch;
                if (getSharedPreferences(BuildConfig.SHARED_PREFERENCES_NAME, MODE_PRIVATE).getBoolean(KeysKt.SH_PREF_BOOL_IS_LOGGED, false)) {
                    activityToLaunch = MainActivity.class;
                } else {
                    activityToLaunch = LoginActivity.class;
                }

                startActivity(new Intent(SplashActivity.this, activityToLaunch));

                finish();
            }
        }, timeInMillisecondToWait);
    }
}
