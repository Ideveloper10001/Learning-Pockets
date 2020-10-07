package com.example.test;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class Module_contents extends AppCompatActivity {
    DrawerLayout mDrawer;
    ActionBarDrawerToggle mToggle;
    NavigationView navigation_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_contents);
        navigation_view = (NavigationView) findViewById(R.id.navigation_view);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawer,R.string.open,R.string.close);
        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.profile:
                        Toast.makeText(Module_contents.this, "profile", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.language:
                        Toast.makeText(Module_contents.this, "language", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.library:
                        Toast.makeText(Module_contents.this, "library", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.logout:
                        Toast.makeText(Module_contents.this, "logout", Toast.LENGTH_SHORT).show();
                        return true;

                    default:
                        return false;
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);


    }
}