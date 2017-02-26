package com.example.themoviedb.themoviedatabaseapp;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.themoviedb.themoviedatabaseapp.model.Movie;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.text.SimpleDateFormat;

/**
 * Created by erickson on 26/02/17.
 */

@EActivity(R.layout.activity_details)
public class DetailsActivity extends AppCompatActivity {
    @ViewById
    TextView movieOriginalTitleTextView;

    @ViewById
    TextView movieTitleTextView;

    @ViewById
    TextView movieSynopsisTextView;

    @ViewById
    TextView movieReleaseDateTextView;

    @ViewById
    ImageView moviePosterImageView;

    @ViewById
    RatingBar voteAverageRatingRatingBar;

    @Extra
    Movie movie;

    @AfterViews
    void init() {
        setMovieTitle();

        setSynopsis();

        setReleaseDate();

        setMoviePoster();

        setVoteAverage();
    }

    private void setVoteAverage() {
        voteAverageRatingRatingBar.setRating((movie.getVoteAverage() / 2));
    }

    private void setMoviePoster() {
        Picasso.with(this)
                .load(movie.getPosterPath(Movie.W780))
                .placeholder(R.mipmap.timthumb)
                .error(R.mipmap.timthumb)
                .noFade()
                .into(moviePosterImageView);
    }

    private void setReleaseDate() {
        SimpleDateFormat sdf =
                ((SimpleDateFormat) android.text.format.DateFormat.getDateFormat(this));

        movieReleaseDateTextView.setText(sdf.format(movie.getReleaseDate()));
    }

    private void setMovieTitle() {
        movieOriginalTitleTextView.setText(movie.getOriginalTitle());

        movieTitleTextView.setText(movie.getTitle());
    }

    private void setSynopsis() {
        movieSynopsisTextView.setText(
                movie.getSynopsis().isEmpty() ?
                        getString(R.string.no_overview) :
                        movie.getSynopsis()
        );
    }
}
