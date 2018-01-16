package me.task.com.taskme.activitities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import me.task.com.taskme.R;
import me.task.com.taskme.fragments.AboutFragment;
import me.task.com.taskme.fragments.FeedbackFragment;
import me.task.com.taskme.fragments.LatestFragment;
import me.task.com.taskme.fragments.MessagesFragment;
import me.task.com.taskme.fragments.OffersFragment;
import me.task.com.taskme.fragments.ProfileFragment;
import me.task.com.taskme.fragments.SavedFragment;
import me.task.com.taskme.fragments.SearchesFragment;
import me.task.com.taskme.fragments.SettingsFragment;
import me.task.com.taskme.fragments.TabFragment;
import me.task.com.taskme.fragments.TasksFragment;
import me.task.com.taskme.fragments.WorkFragment;
import me.task.com.taskme.helper.SharedPrefManager;

//This class provides user to perform any operations
//on the navigation drawer screen
public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        AboutFragment.OnFragmentInteractionListener, FeedbackFragment.OnFragmentInteractionListener,
        LatestFragment.OnFragmentInteractionListener, MessagesFragment.OnFragmentInteractionListener,
        OffersFragment.OnFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener,
        SavedFragment.OnFragmentInteractionListener, SearchesFragment.OnFragmentInteractionListener,
        SettingsFragment.OnFragmentInteractionListener, TabFragment.OnFragmentInteractionListener,
        TasksFragment.OnFragmentInteractionListener, WorkFragment.OnFragmentInteractionListener{

//    declare the variables
    private TextView profile_name, profile_email, app_name;
    private ImageView profile_image;
    private RelativeLayout profile;
    DrawerLayout drawer;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

//        initialize the toolbar as the action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            Fragment fragment = null;
            Class fragmentClass = null;
            fragmentClass = TabFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            /**
             * Lets inflate the very first fragment
             * Here , we are inflating the TabFragment as the first Fragment
             */
            //replacing the fragment
            if (fragment != null) {
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.containerView, fragment).commit();
            }
        }

//        initialize the drawer
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        for hamburger to show up create an action bar toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        set action bar toggle to drawer layout
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);


//        SharedPrefManager.getInstance(this).logout();
        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, SignInActivity.class));
        }

        View headerView = navigationView.getHeaderView(0);
        app_name = (TextView) headerView.findViewById(R.id.app_name);
        profile_name = (TextView) headerView.findViewById(R.id.profile_name);
        profile_email = (TextView) headerView.findViewById(R.id.profile_email);
        profile_image = (ImageView) headerView.findViewById(R.id.profile_image);

        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                display the profile fragment
                drawer.closeDrawer(GravityCompat.START);
                FragmentTransaction navProfileTransaction = mFragmentManager.beginTransaction();
                navProfileTransaction.replace(R.id.containerView,new ProfileFragment()).commit();
            }
        });

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
        Fragment fragment = null;
        Class fragmentClass = null;

        if (id == R.id.nav_work) {
//            display all the job posted related to the field of specialization
            fragmentClass = TabFragment.class;
        } else if (id == R.id.nav_messages) {
//            display all the messages fragment
            fragmentClass = MessagesFragment.class;
        } else if (id == R.id.nav_offers) {
//            display the offers fragment
            fragmentClass = OffersFragment.class;
        } else if (id == R.id.nav_tasks) {
//            display the completed tasks
            fragmentClass = TasksFragment.class;
        } else if (id == R.id.nav_settings) {
//            display the settings fragment
            fragmentClass = SettingsFragment.class;
        } else if (id == R.id.nav_about) {
//            display the about fragment
            fragmentClass = AboutFragment.class;
        } else if (id == R.id.nav_feedback) {
//            display the feedback fragment
            fragmentClass = FeedbackFragment.class;
        }else if (id == R.id.nav_logout) {
            logout();
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //replacing the fragment
        if (fragment != null) {
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.containerView, fragment).commit();
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
