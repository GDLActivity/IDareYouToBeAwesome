package com.sierisimo.idareyoutobeawesome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sierisimo on 1/21/17.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
