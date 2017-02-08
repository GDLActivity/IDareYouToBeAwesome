package com.sierisimo.idareyoutobeawesome.dares;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.sierisimo.idareyoutobeawesome.R;
import com.sierisimo.idareyoutobeawesome.data.Dare;
import com.sierisimo.idareyoutobeawesome.util.KeysKt;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Baltazar Rodriguez on 31/01/2017.
 */

public class DareDetailActivity extends AppCompatActivity {
    //private long dareId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dare_detail);

        Dare dare = (Dare) getIntent().getExtras().getSerializable(KeysKt.EXTRA_DARE_DETAILED);

        if (dare != null){
            setDareTitle(dare.getTitle());
            setDareDescription(dare.getDescription());
            setDareStatus(dare.getCurrentState());
            setDareDate(dare.getDateCreated(), "dd/MM/yyyy hh:mm:ss.SSS");
        } else {
            Toast.makeText(this, "Dare is empty", Toast.LENGTH_SHORT).show();
        }

    }

    public void setDareTitle(String title){
        TextView textView = (TextView) findViewById(R.id.tvDareTitle);
        textView.setText(title);
    }

    public void setDareDescription(String description){
        TextView textView = (TextView) findViewById(R.id.tvDareDescription);
        textView.setText(description);
    }

    public void setDareStatus(Long status) {
        TextView textView = (TextView) findViewById(R.id.tvDareStatus);
        String string = "";

        if (status.equals(0L))
            string = "PENDING";
        else if (status.equals(1L))
            string = "IN PROGRESS";
        else if (status.equals(2L))
            string = "SOLVED";
        else if (status.equals(-1L))
            string = "REJECTED";
        else if (status.equals(5L))
            string = "SENT";

        textView.setText("Status: " + string);
    }

    public void setDareDate(long milliseconds, String dateFormat){
        TextView textView = (TextView) findViewById(R.id.tvDareDate);

        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);

        textView.setText("Date: " + formatter.format(calendar.getTime()));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
