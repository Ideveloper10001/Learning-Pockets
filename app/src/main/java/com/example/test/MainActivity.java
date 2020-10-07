package com.example.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    SharedPreferences prefs;
    String back="false";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);


        Thread thread = new Thread(){
            @Override
            public void run(){
                try{

                    for(int x=0;x<100;x++){
                        progressBar.setProgress(x);
                        sleep(30);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();

                }finally {
                    Intent i = new Intent(getApplicationContext(),Login_register.class);
                    prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("back",back);
                    editor.apply();
                    startActivity(i);
                    finish();
                }
            }
        };
        thread.start();
    }
}
