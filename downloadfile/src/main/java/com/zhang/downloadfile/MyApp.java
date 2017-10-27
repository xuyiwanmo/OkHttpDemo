package com.zhang.downloadfile;

import android.app.Application;

import com.zhang.downloadfile.file.FileStorageManager;

/**
 * Created by 德医互联 on 2017/10/26.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FileStorageManager.getInstance().init(getApplicationContext());
    }
}
