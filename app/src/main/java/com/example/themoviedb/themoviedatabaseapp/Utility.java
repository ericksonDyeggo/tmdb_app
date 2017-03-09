package com.example.themoviedb.themoviedatabaseapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by erickson on 18/03/17.
 */

public class Utility {
    public static String getPreferedOrder(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(context.getString(R.string.pref_ordering_movies_key),
                context.getString(R.string.pref_order_by_popularity_key));
    }
}
