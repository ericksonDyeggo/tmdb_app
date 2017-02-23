package com.example.themoviedb.themoviedatabaseapp.rest_client;

import android.support.annotation.Nullable;

import com.example.themoviedb.themoviedatabaseapp.model.Movie;
import com.example.themoviedb.themoviedatabaseapp.model.UpComingMovies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by erickson on 12/02/17.
 */

public interface TMDBMovie {

    @GET("movie/{id}")
    Call<Movie> getMovie(@Path("id") Integer id);

    @GET("movie/upcoming")
    Call<UpComingMovies> getUpcomingMovies(@Query("page")Integer page);
}
