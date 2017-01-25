package com.sierisimo.idareyoutobeawesome;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sierisimo.idareyoutobeawesome.listeners.DrawerItemClickListener;

/**
 * Created by sierisimo on 1/21/17.
 */

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActivity();
    }

    private void initActivity() {
        setupToolbar();

        String[] mTitles = new String[]{"Title One", "Title Two", "Title Three"};
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ListView mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerList.setAdapter(new ArrayAdapter<>(this, R.layout.item_drawer_list, mTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener(getApplicationContext()));
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.vector_menubar_hamburger);
            actionbar.setDisplayShowTitleEnabled(true);
            actionbar.setTitle(R.string.title_dummy);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
