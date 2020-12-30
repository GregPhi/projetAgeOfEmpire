package com.example.civilizationlibrairy_aoe2;

import android.app.Application;

import com.example.civilizationlibrairy_aoe2.data.di.AoE2DecencyInjector;
import com.facebook.stetho.Stetho;

/**
 * Application
 */
public class MainActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        AoE2DecencyInjector.setContext(this);
    }
}