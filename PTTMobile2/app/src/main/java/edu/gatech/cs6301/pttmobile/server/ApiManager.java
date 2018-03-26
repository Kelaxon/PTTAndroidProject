package edu.gatech.cs6301.pttmobile.server;

import edu.gatech.cs6301.pttmobile.R;
import edu.gatech.cs6301.pttmobile.application.PTTMoblie;
import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.MalformedURLException;


/**
 * Created by arpithadudi on 3/21/18.
 */

public class ApiManager {

    private static ApiManager mApiManger;
    private static Context mContext;
    private PTTMoblie mApp;


    private ApiManager(Context context) {
        mContext = context;
        mApp = (PTTMoblie) mContext.getApplicationContext();
    }

    public static synchronized ApiManager getInstance(Context context) {
        if (mApiManger == null) {
            mApiManger = new ApiManager(context);
        }
        return mApiManger;
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

//            for (String credential : DUMMY_CREDENTIALS) {
//                String[] pieces = credential.split(":");
//                if (pieces[0].equals(mEmail)) {
//                    // Account exists, return true if the password matches.
//                    return pieces[1].equals(mPassword);
//                }
//            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
//            mAuthTask = null;
//            showProgress(false);
//
//            if (success) {
//                finish();
//            } else {
//                mPasswordView.setError(getString(R.string.error_incorrect_password));
//                mPasswordView.requestFocus();
//            }
        }

        @Override
        protected void onCancelled() {
//            mAuthTask = null;
//            showProgress(false);
        }
    }

}
