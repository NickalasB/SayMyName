package com.zonkey.saymyname;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


public class GenderPicker  {

    private static final String CHICK_MODE = "chick_mode";


    public static boolean isInChickMode(Activity activity) {
        SharedPreferences preferences = activity.getSharedPreferences("pref", Context.MODE_PRIVATE);
        return preferences.getBoolean(CHICK_MODE, false);
    }

    public static void setChickMode(boolean isChickMode,Activity activity) {
        SharedPreferences preferences = activity.getSharedPreferences("pref", Context.MODE_PRIVATE);
        preferences.edit().putBoolean(CHICK_MODE, isChickMode).apply();
    }
}
