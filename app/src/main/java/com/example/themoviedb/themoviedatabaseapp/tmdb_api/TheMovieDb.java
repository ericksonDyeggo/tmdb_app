package com.example.themoviedb.themoviedatabaseapp.tmdb_api;

import android.os.AsyncTask;

import java.util.HashMap;

/**
 * Created by erickson on 15/01/17.
 */

public class TheMovieDb extends AsyncTask<HashMap<String, String>, String, String> {

    private final static String MOVIE_DATABASE_API_URL = "https://api.themoviedb.org/3/";

    private final static String MOVIE_IMAGES_RES_URL = "https://image.tmdb.org/t/p/";

    @Override
    protected String doInBackground(HashMap<String, String>... params) {
        return null;
    }


//    for(Entry<String, String> e : m.entrySet()) {
//        String key = e.getKey();
//        String value = e.getValue();
//    }

}
