package com.example.themoviedb.themoviedatabaseapp.rest_client;

import com.example.themoviedb.themoviedatabaseapp.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by erickson on 12/02/17.
 */

public interface TMDBMovie {

    @GET("movie/{id}")
    Call<Movie> getMovie(@Path("id") Integer id);
}
