package edu.gatech.cs6301.pttmobile.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by arpithadudi on 3/21/18.
 */

public class AppPreference {
    private final String PREF_USER_STATE = "userstate";

    //This function is used to clear all the preferences.
    public void clearAll(Context context) {
        SharedPreferences oSharedPreference = context.getSharedPreferences(context.getPackageName(), Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor oEditor = oSharedPreference.edit();
        oEditor.clear();
        oEditor.commit();
    }

    private void setPreference(Context context, String name, boolean value) {
        if (context == null)
            return;
        SharedPreferences oSharedPreference = context.getSharedPreferences(context.getPackageName(), Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor oEditor = oSharedPreference.edit();
        oEditor.putBoolean(name, value);
        oEditor.commit();
    }

    private boolean getPreference(Context context, String name, boolean defaultValue) {
        if (context == null)
            return defaultValue;
        SharedPreferences oSharedPreference = context.getSharedPreferences(context.getPackageName(), Context.MODE_MULTI_PROCESS);
        return oSharedPreference.getBoolean(name, defaultValue);
    }

    //Get and set the current user state.
    //Weather the user has logged in or not
    public void setUserState(Context context, boolean val) {
        if (context == null)
            return;
        setPreference(context, PREF_USER_STATE, val);
    }

    public boolean getAppState(Context context) {
        if (context == null)
            return false;
        return getPreference(context, PREF_USER_STATE, false);
    }
}
