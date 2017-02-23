package com.example.themoviedb.themoviedatabaseapp.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by erickson on 17/02/17.
 */

public class UpComingMovies {
    private Integer page;
    @SerializedName("results")
    private List<Movie> movies;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
