package com.sierisimo.idareyoutobeawesome;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.sierisimo.idareyoutobeawesome.login.LoginActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class SplashActivityTest {
    private ActivityController<SplashActivity> splashActivityController;

    @Before
    public void setup() {
        splashActivityController = Robolectric.buildActivity(SplashActivity.class).create();
    }

    @Test
    public void onCreate() throws Exception {
        SplashActivity splashActivity = splashActivityController.visible().get();

        View textVersionView = splashActivity.findViewById(R.id.tv_splash_version);

        assertNotNull("View for version should exist", textVersionView);
        assertTrue("View for version should be a TextView", textVersionView instanceof TextView);
    }

    @Test
    public void onStart() throws Exception {
        SplashActivity splashActivity = splashActivityController.start()
                .visible()
                .get();

        TextView textVersionView = (TextView) splashActivity.findViewById(R.id.tv_splash_version);
        String textVersion = textVersionView.getText().toString();

        assertTrue("Length for text shouldn't be 0", textVersion.length() > 0);

        assertEquals("Version should be the same as build name", BuildConfig.VERSION_NAME, textVersionView.getText().toString());
    }

    @Test
    public void onResume() throws Exception {
        SplashActivity splashActivity = splashActivityController.start().resume().get();

        Thread.sleep(4000);

        Intent nextIntent = new Intent(splashActivity, LoginActivity.class);
        assertEquals(nextIntent, shadowOf(splashActivity).getNextStartedActivity());
    }

}