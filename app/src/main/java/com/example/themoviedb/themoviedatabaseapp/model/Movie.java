package com.example.themoviedb.themoviedatabaseapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by erickson on 12/02/17.
 */

public class Movie implements Serializable {

    private final static String IMG_URL = "https://image.tmdb.org/t/p/%s%s";

    public final static int W92 = 1;
    public final static int W154 = 2;
    public final static int W185 = 3;
    public final static int W342 = 4;
    public final static int W500 = 5;
    public final static int W780 = 6;
    public final static int ORIGINAL = 0;
    private final String[] sizes = {"original", "w92", "w154", "w185", "w342", "w500", "w780"};

    private Long id;
    @SerializedName("original_title")
    private String originalTitle;
    private String title;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("overview")
    private String synopsis;
    @SerializedName("release_date")
    private Date releaseDate;
    @SerializedName("vote_average")
    private float voteAverage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath(int size) {
        String posterURL = String.format(IMG_URL, sizes[size], posterPath);
        return posterURL;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }
}
