package me.task.com.taskme.helper;

import android.content.Context;
import android.content.SharedPreferences;

import me.task.com.taskme.models.Professional;

/**
 * Created by root on 11/17/17.
 */

public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "taskme";

    private static final String KEY_PROFESSIONAL_ID = "keyprofessionalid";
    private static final String KEY_PROFESSIONAL_NAME = "keyprofessionalname";
    private static final String KEY_PROFESSIONAL_FIRST_NAME = "keyprofessionalfirstname";
    private static final String KEY_PROFESSIONAL_LAST_NAME = "keyprofessionallastname";
    private static final String KEY_PROFESSIONAL_EMAIL = "keyprofessionalemail";
    private static final String KEY_PROFESSIONAL_TOKEN = "keyprofessionaltoken";

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean professionalLogin(Professional professional) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_PROFESSIONAL_ID, professional.getProff_id());
        editor.putString(KEY_PROFESSIONAL_NAME, professional.getProff_name());
        editor.putString(KEY_PROFESSIONAL_FIRST_NAME, professional.getFirst_name());
        editor.putString(KEY_PROFESSIONAL_LAST_NAME, professional.getLast_name());
        editor.putString(KEY_PROFESSIONAL_TOKEN, professional.getApi_key());
        editor.putString(KEY_PROFESSIONAL_EMAIL, professional.getEmail());
        editor.apply();
        return true;
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_PROFESSIONAL_EMAIL, null) != null)
            return true;
        return false;
    }

    public String getUserToken() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PROFESSIONAL_TOKEN, null);
    }

    public Professional getProfessional() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Professional(
                sharedPreferences.getInt(KEY_PROFESSIONAL_ID, 0),
                sharedPreferences.getString(KEY_PROFESSIONAL_NAME, null),
                sharedPreferences.getString(KEY_PROFESSIONAL_FIRST_NAME, null),
                sharedPreferences.getString(KEY_PROFESSIONAL_LAST_NAME, null),
                sharedPreferences.getString(KEY_PROFESSIONAL_EMAIL, null),
                sharedPreferences.getString(KEY_PROFESSIONAL_TOKEN, null)
        );
    }

    public boolean logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
}
