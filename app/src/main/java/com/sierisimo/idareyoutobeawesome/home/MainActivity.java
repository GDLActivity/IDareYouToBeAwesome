package com.sierisimo.idareyoutobeawesome.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.sierisimo.idareyoutobeawesome.R;
import com.sierisimo.idareyoutobeawesome.about.AboutActivity;

/**
 * Created by sierisimo on 1/21/17.
 */
public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActivity();
        setUpCardViews();
    }

    private void initActivity() {
        setupToolbar();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        setupNavigationView();
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.vector_menubar_hamburger);
            actionbar.setDisplayShowTitleEnabled(true);
            actionbar.setTitle(R.string.title_dummy);
        }
    }

    private void setupNavigationView() {
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.nv_main_drawer);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(!item.isChecked());

                switch (item.getItemId()) {
                    case R.id.item_edit_profile:
                        Toast.makeText(getApplicationContext(), "Edit Profile", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_history:
                        Toast.makeText(getApplicationContext(), "History", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_settings:
                        Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_friends:
                        Toast.makeText(getApplicationContext(), "Friends", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.section_about:
                        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.item_exit:
                        Toast.makeText(getApplicationContext(), "Exit", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return false;
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void setUpCardViews(){
        CardView cardViewDaily = (CardView)findViewById(R.id.card_daily_dare);
        CardView cardViewWeek = (CardView)findViewById(R.id.card_week_dare);
        CardView cardViewMonth = (CardView)findViewById(R.id.card_month_dare);

        cardViewDaily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Daily Dare", Toast.LENGTH_SHORT).show();
            }
        });

        cardViewWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Week Dare", Toast.LENGTH_SHORT).show();
            }
        });

        cardViewMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Month Dare", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            openDrawer();
        return super.onOptionsItemSelected(item);
    }

    private void openDrawer() {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawers();
        else
            super.onBackPressed();
    }
}
