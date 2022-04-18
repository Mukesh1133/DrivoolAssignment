package com.example.drivoolassignment1.activities;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;

public class DrivoolAssignment1Application extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }


}


