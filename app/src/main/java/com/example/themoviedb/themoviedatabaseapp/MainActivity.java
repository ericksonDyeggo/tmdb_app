package com.example.themoviedb.themoviedatabaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.themoviedb.themoviedatabaseapp.model.Movie;
import com.example.themoviedb.themoviedatabaseapp.rest_client.TMDBMovie;
import com.example.themoviedb.themoviedatabaseapp.rest_client.TMDBService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;

import java.io.IOException;

import retrofit2.Call;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @AfterViews
    void onAV() {
        testeAPIClient();
    }

    @Background
    void testeAPIClient() {
        TMDBService service = new TMDBService(getString(R.string.api_key));

        TMDBMovie tmdbMovie = service.getTMDBMovie();

        Call<Movie> call = tmdbMovie.getMovie(124);

        try {
            Movie movie = call.execute().body();

            Log.d("Movie", movie.getOriginal_title());
        } catch (Exception e) {
            Log.d("Movie", "Erro");
            e.printStackTrace();
        }
    }
}
