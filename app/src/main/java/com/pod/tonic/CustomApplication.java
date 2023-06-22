package com.pod.tonic;

import android.app.Application;
import android.content.Context;

public class CustomApplication extends Application {
    private static CustomApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getAppContext() {
        return instance;
    }
}
