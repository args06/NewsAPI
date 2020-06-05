package com.example.newsapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.newsapi.fragment.HomeFragment;
import com.example.newsapi.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.menu_home:
                loadFragment(new HomeFragment());
                break;

            case R.id.menu_memo:
                loadFragment(new ProfileFragment());
                break;
        }
        return true;
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container,selectedFragment)
                    .commit();
            return true;
        }
        else
        {
            return false;
        }

    }
}