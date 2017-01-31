package com.sierisimo.idareyoutobeawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.sierisimo.idareyoutobeawesome.activities.AboutActivity;
import com.sierisimo.idareyoutobeawesome.adapters.RecyclerViewChallengeAdapter;

/**
 * Created by sierisimo on 1/21/17.
 */

public class MainActivity extends AppCompatActivity {

    private String[] mTitles;
    private String[] mChallenges;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerViewChallengeAdapter mAdapter;

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
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationViewClick();

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mChallenges = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewChallengeAdapter(mChallenges);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void navigationViewClick(){
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                switch (item.getItemId()){
                    case R.id.title_one:
                        Toast.makeText(getApplicationContext(), "Title One", Toast.LENGTH_SHORT).show();
                        mDrawerLayout.closeDrawers();
                        return true;
                    case R.id.title_two:
                        Toast.makeText(getApplicationContext(), "Title Two", Toast.LENGTH_SHORT).show();
                        mDrawerLayout.closeDrawers();
                        return true;
                    case R.id.title_three:
                        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(intent);
                        mDrawerLayout.closeDrawers();
                        return true;
                }

                return false;
            }
        });
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
