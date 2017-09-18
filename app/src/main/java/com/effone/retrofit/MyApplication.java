package com.effone.retrofit;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by sumanth.peddinti on 9/15/2017.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Initializing Active Android
        ActiveAndroid.initialize(this);
    }
}
