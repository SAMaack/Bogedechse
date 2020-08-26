package com.example.bogedechse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";       //Console TAG for Debugging - May be used to output stuff into the console.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}