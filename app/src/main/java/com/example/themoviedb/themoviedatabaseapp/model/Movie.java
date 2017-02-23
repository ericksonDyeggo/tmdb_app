package com.example.themoviedb.themoviedatabaseapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by erickson on 12/02/17.
 */

public class Movie {

    private final static String IMG_URL = "https://image.tmdb.org/t/p/%s%s";

    private Long id;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("poster_path")
    private String posterPath;
    private String overview;
    @SerializedName("release_date")
    private Date releaseDate;
    @SerializedName("vote_average")
    private Double voteAverage;

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

    public String getPosterPath() {
        String posterURL = String.format(IMG_URL, "w500", posterPath);
        return posterURL;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }
}
