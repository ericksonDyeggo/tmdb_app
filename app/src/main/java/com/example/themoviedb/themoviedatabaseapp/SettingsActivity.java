package com.example.themoviedb.themoviedatabaseapp;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.PreferenceScreen;
import org.androidannotations.annotations.sharedpreferences.Pref;

/**
 * Created by erickson on 26/02/17.
 */
@EActivity
public class SettingsActivity extends PreferenceActivity {

    @Pref
    DefaultPrefs_ prefs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }

}