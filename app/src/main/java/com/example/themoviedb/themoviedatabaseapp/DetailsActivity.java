package com.example.themoviedb.themoviedatabaseapp;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.themoviedb.themoviedatabaseapp.model.Movie;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

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

    @Extra
    Movie movie;

    @AfterViews
    void init() {
        movieOriginalTitleTextView.setText(movie.getOriginalTitle());

        movieTitleTextView.setText(movie.getTitle());

        movieSynopsisTextView.setText(movie.getSynopsis());

        movieReleaseDateTextView.setText(movie.getReleaseDate().toString());

        Picasso.with(this)
                .load(movie.getPosterPath())
                .placeholder(R.mipmap.timthumb)
                .error(R.mipmap.timthumb)
                .noFade()
                .into(moviePosterImageView);
    }
}
