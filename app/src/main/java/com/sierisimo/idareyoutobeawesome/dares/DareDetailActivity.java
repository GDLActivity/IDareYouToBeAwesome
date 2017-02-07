package com.sierisimo.idareyoutobeawesome.dares;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sierisimo.idareyoutobeawesome.R;
import com.sierisimo.idareyoutobeawesome.data.Dare;
import com.sierisimo.idareyoutobeawesome.util.KeysKt;

/**
 * Created by Baltazar Rodriguez on 31/01/2017.
 */

public class DareDetailActivity extends AppCompatActivity {
    //private long dareId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dare_detail);

        //Dare dare = (Dare) getIntent().getExtras().getSerializable(KeysKt.EXTRA_DARE_DETAILED);
        //dareId  = dare.getId();
        //setViewTitle(dare.getTitle());
        //setDescription(dare.getDescription());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
