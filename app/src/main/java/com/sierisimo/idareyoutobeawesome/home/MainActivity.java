package com.sierisimo.idareyoutobeawesome.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.sierisimo.idareyoutobeawesome.R;
import com.sierisimo.idareyoutobeawesome.about.AboutActivity;
import com.sierisimo.idareyoutobeawesome.dares.DareDetailActivity;
import com.sierisimo.idareyoutobeawesome.dares.RecyclerDareAdapter;
import com.sierisimo.idareyoutobeawesome.data.DareProvider;
import com.sierisimo.idareyoutobeawesome.listeners.DareListener;

/**
 * Created by sierisimo on 1/21/17.
 */
public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView mNavigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActivity();
    }

    private void initActivity() {
        setupToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);

        setupNavigationView();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        DareListener dareListener = new DareListener() {
            @Override
            public void onDarePressed() {
                Intent intent = new Intent(MainActivity.this, DareDetailActivity.class);
                startActivity(intent);
            }
        };

        RecyclerDareAdapter mAdapter = new RecyclerDareAdapter(DareProvider.INSTANCE.getDares(), dareListener);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void setupNavigationView() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(!item.isChecked());

                switch (item.getItemId()) {
                    case R.id.title_one:
                        Toast.makeText(getApplicationContext(), "Title One", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.title_two:
                        Toast.makeText(getApplicationContext(), "Title Two", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.section_about:
                        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        return false;
                }

                drawerLayout.closeDrawers();
                return true;
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
}
