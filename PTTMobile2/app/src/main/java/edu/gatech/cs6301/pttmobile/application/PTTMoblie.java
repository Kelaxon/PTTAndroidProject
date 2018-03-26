package edu.gatech.cs6301.pttmobile.application;

import android.app.Application;
import android.content.Context;

import edu.gatech.cs6301.pttmobile.utils.AppPreference;

/**
 * Created by arpithadudi on 3/21/18.
 */

public class PTTMoblie extends Application {
    private Context mContext;
    private AppPreference mPreference;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public Context getApplicationContext(){
        return mContext;
    }

    public AppPreference getPreference() {
        if (mPreference == null) {
            mPreference = new AppPreference();
        }
        return mPreference;
    }



}
