package com.example.jetnixx.volleydependency;

import android.app.Application;
import android.content.Context;

/**
 * Created by 1084760 on 2015/11/30.
 */
public class MyApplication extends Application {

    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static MyApplication getsInstance(){
        return sInstance;
    }

    public static Context getAppContext(){
        return sInstance.getApplicationContext();
    }
}
