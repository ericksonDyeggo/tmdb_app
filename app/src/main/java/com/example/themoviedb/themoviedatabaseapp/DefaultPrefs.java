package com.example.themoviedb.themoviedatabaseapp;

import org.androidannotations.annotations.sharedpreferences.DefaultRes;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by erickson on 08/03/17.
 */

@SharedPref
public interface DefaultPrefs {
    @DefaultRes(R.string.pref_order_by_popularity)
    String prefOrderBy();
}
