package edu.gatech.cs6301.pttmobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import edu.gatech.cs6301.pttmobile.R;
import edu.gatech.cs6301.pttmobile.application.PTTMoblie;

/**
 * Created by arpithadudi on 3/21/18.
 */

public class LaunchActivity extends AppCompatActivity {

    private PTTMoblie mApp;
    private boolean mUserState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        mApp = (PTTMoblie) getApplicationContext();
        mUserState = mApp.getPreference().getAppState(LaunchActivity.this);

        if (mUserState){
            startActivity(new Intent(LaunchActivity.this, MainActivity.class));
            finish();
        }else{
            startActivity(new Intent(LaunchActivity.this, LoginActivity.class));
            finish();
        }
    }
}
