package com.sierisimo.idareyoutobeawesome;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sierisimo.idareyoutobeawesome.adapters.RecyclerViewChallengeAdapter;
import com.sierisimo.idareyoutobeawesome.listeners.DrawerItemClickListener;

/**
 * Created by sierisimo on 1/21/17.
 */

public class MainActivity extends AppCompatActivity {

    private String[] mTitles;
    private String[] mChallenges;
    private DrawerLayout mDrawerLayout;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerViewChallengeAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitles = new String[]{"Title One", "Title Two", "Title Three"};
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mChallenges = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewChallengeAdapter(mChallenges);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
