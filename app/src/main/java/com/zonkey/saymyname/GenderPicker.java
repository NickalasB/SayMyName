package com.zonkey.saymyname;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


public class GenderPicker  {

    private static final String CHICK_MODE = "chick_mode";
    private static final String CHICK_CHECKED = "chick_checked";


    public static boolean isInChickMode(Activity activity) {
        SharedPreferences preferences = activity.getSharedPreferences("pref", Context.MODE_PRIVATE);
        return preferences.getBoolean(CHICK_MODE, false);
    }

    /**
     *
     * @param isChickMode recalls the state of the imageView
     */
    public static void setChickMode(boolean isChickMode,Activity activity) {
        SharedPreferences preferences = activity.getSharedPreferences("pref", Context.MODE_PRIVATE);
        preferences.edit().putBoolean(CHICK_MODE, isChickMode).apply();
    }

    /**
     *
     * @param isChickSwitchChecked handles saving the state of the switch
     */
    public static void setChickChecked(boolean isChickSwitchChecked, Activity activity){
        SharedPreferences preferences = activity.getSharedPreferences("pref", Context.MODE_PRIVATE);
        preferences.edit().putBoolean(CHICK_CHECKED, isChickSwitchChecked).apply();
    }

    public static boolean isChickChecked(Activity activity) {
        SharedPreferences preferences = activity.getSharedPreferences("pref", Context.MODE_PRIVATE);
        return preferences.getBoolean(CHICK_CHECKED, false);
    }




}
