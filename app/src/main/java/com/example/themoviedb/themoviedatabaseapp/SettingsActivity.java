package com.example.themoviedb.themoviedatabaseapp;

import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import org.androidannotations.annotations.AfterPreferences;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.PreferenceScreen;

/**
 * Created by erickson on 26/02/17.
 */
@PreferenceScreen(R.xml.settings)
@EActivity
public class SettingsActivity extends PreferenceActivity
        implements Preference.OnPreferenceChangeListener {

    @AfterPreferences
    void initPrefs() {
        bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_ordering_movies_key)));
    }

    private void bindPreferenceSummaryToValue(Preference preference) {
        // Set the listener to watch for value changes.
        preference.setOnPreferenceChangeListener(this);

        // Trigger the listener immediately with the preference's
        // current value.
        onPreferenceChange(preference,
                PreferenceManager
                        .getDefaultSharedPreferences(preference.getContext())
                        .getString(preference.getKey(), ""));
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object value) {
        String stringValue = value.toString();

        if (preference instanceof ListPreference) {
            // For list preferences, look up the correct display value in
            // the preference's 'entries' list (since they have separate labels/values).
            ListPreference listPreference = (ListPreference) preference;
            int prefIndex = listPreference.findIndexOfValue(stringValue);
            if (prefIndex >= 0) {
                preference.setSummary(listPreference.getEntries()[prefIndex]);
            }
        } else {
            // For other preferences, set the summary to the value's simple string representation.
            preference.setSummary(stringValue);
        }
        return true;
    }
}