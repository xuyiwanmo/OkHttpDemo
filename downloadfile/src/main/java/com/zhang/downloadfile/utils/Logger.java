package com.zhang.downloadfile.utils;

import android.util.Log;

import java.util.Locale;

/**
 * Created by 德医互联 on 2017/10/26.
 */

public class Logger {
    private static final Boolean DEBUG = true;
    public static final String TAG = "zhang";

    public static void debug(String message) {
        if (DEBUG) {
            Log.d(TAG, message);
        }
    }

    public static void debug(String message, Object... args) {
        if (DEBUG) {
            Log.d(TAG, String.format(Locale.getDefault(), message, args));
        }
    }

    public static void error(String message) {
        if (DEBUG) {
            Log.d(TAG, message);
        }
    }
    public static void info(String message){
        if (DEBUG) {
            Log.i(TAG, message);
        }
    }
}
