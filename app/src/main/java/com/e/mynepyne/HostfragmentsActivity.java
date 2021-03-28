package com.e.mynepyne;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HostfragmentsActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostfragments);




        BottomNavigationView navview = findViewById(R.id.bottom_nav);
        navview.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MeFragment()).commit();

    }












    private BottomNavigationView.OnNavigationItemSelectedListener  navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment myFrag = null;

            switch (menuItem.getItemId()){
                case R.id.nav_home:
                    myFrag = new MeFragment();
                    break;
                case R.id.nav_settings:
                    myFrag = new SettingsFragment();
                    break;
                case R.id.nav_profile:
                    myFrag = new ProfileFragment();
                    break;
                case R.id.nav_notify:
                    myFrag = new NotificationsFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFrag).commit();

            return true;

        }
    };

}