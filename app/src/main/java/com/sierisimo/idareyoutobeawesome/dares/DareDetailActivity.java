package com.sierisimo.idareyoutobeawesome.dares;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sierisimo.idareyoutobeawesome.R;

/**
 * Created by Baltazar Rodriguez on 31/01/2017.
 */

public class DareDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dare_detail);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
