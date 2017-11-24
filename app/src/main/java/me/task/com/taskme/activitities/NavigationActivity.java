package me.task.com.taskme.activitities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import me.task.com.taskme.R;
import me.task.com.taskme.helper.SharedPrefManager;

//This class provides user to perform any operations
//on the navigation drawer screen
public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private TextView profile_name, profile_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

//        initialize the toolbar as the action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        initialize the drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        for hamburger to show up create an action bar toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        set action bar toggle to drawer layout
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        SharedPrefManager.getInstance(this).logout();
        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, SignInActivity.class));
        }

        View headerView = navigationView.getHeaderView(0);
        profile_name = (TextView) headerView.findViewById(R.id.profile_name);
        profile_email = (TextView) headerView.findViewById(R.id.profile_email);

//        set the username/first and last name, plus email
        if (SharedPrefManager.getInstance(this).getProfessional().getProff_name() != null)
            profile_name.setText(SharedPrefManager.getInstance(this).getProfessional().getProff_name());
        else
            profile_name.setText(SharedPrefManager.getInstance(this).getProfessional().getFirst_name() + " " + SharedPrefManager.getInstance(this).getProfessional().getLast_name());

        profile_email.setText(SharedPrefManager.getInstance(this).getProfessional().getEmail());
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_work) {

        } else if (id == R.id.nav_messages) {

        } else if (id == R.id.nav_offers) {

        } else if (id == R.id.nav_tasks) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_about) {

        } else if (id == R.id.nav_feedback) {

        }else if (id == R.id.nav_logout) {
            logout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logout() {
        SharedPrefManager.getInstance(this).logout();
        finish();
        startActivity(new Intent(this, SignInActivity.class));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
