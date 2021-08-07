package com.example.tiktokclone;

import android.content.Context;
import android.content.SharedPreferences;

public class DataSaver {
    private static final String SHARED_PREFERENCE_KEY = "sharedpreferences";
    private static SharedPreferences sharedPreferences;

    public static SharedPreferences getInstance(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public static void setLoginData(Context context, boolean loggedIn) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putBoolean(SHARED_PREFERENCE_KEY, loggedIn);
        editor.apply();
    }

    public static boolean getLoginData(Context context) {
        return getInstance(context).getBoolean(SHARED_PREFERENCE_KEY, false);
    }

}
