package com.ideator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
    private DrawerLayout mLayoutDrawer;
    private NavigationView mNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mLayoutDrawer = (DrawerLayout) findViewById(R.id.layout_drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mLayoutDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mLayoutDrawer.addDrawerListener(toggle);
        toggle.syncState();

        mNavigation = (NavigationView) findViewById(R.id.nav_view);
        mNavigation.setNavigationItemSelectedListener(this);
        View navigationHeader = mNavigation.getHeaderView(0);
        TextView textAccountContext = (TextView)navigationHeader.findViewById(R.id.text_account_context);
        ImageView imageNavigationHeaderProfile = (ImageView)navigationHeader.findViewById(R.id.image_profile);
        textAccountContext.setText(ConnectionHelper.getUsername());
    }

    @Override
    public void onBackPressed() {
        if (mLayoutDrawer.isDrawerOpen(GravityCompat.START)) {
            mLayoutDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.action_report:
                break;
            case R.id.action_connect:
                break;
            case R.id.action_recent_uploads:
                break;
            case R.id.action_settings:
                Intent intentToSettings = SettingsActivity.newIntent(this);
                startActivity(intentToSettings);
                break;
        }
        // Handle navigation view item clicks here.
        mLayoutDrawer = (DrawerLayout) findViewById(R.id.layout_drawer);
        mLayoutDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
