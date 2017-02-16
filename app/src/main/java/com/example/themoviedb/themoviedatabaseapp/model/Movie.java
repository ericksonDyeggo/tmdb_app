package com.example.themoviedb.themoviedatabaseapp.model;

/**
 * Created by erickson on 12/02/17.
 */

public class Movie {
    private boolean adult;
    private String original_title;

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }
}
