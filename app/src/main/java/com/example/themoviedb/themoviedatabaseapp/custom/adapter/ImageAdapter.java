package com.example.themoviedb.themoviedatabaseapp.custom.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.themoviedb.themoviedatabaseapp.R;
import com.example.themoviedb.themoviedatabaseapp.model.Movie;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erickson on 14/02/17.
 */

@EBean
public class ImageAdapter extends BaseAdapter {

    @RootContext
    Context mContext;

    List<Movie> movies;

    public ImageAdapter() {
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Movie getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return movies.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

//        Check if there's a view
        if (convertView == null) {
//            if not, create one
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(153, 227));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        } else {
//            use de recycled one
            imageView = (ImageView) convertView;
        }

//        Load images using Picasso
        Picasso.with(mContext)
                .load(getItem(position).getPosterPath(Movie.W92))
                .placeholder(R.mipmap.timthumb)
                .error(R.mipmap.timthumb)
                .noFade()
                .resize(153, 227)
                .centerCrop()
                .into(imageView);

        return imageView;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addMovie(List<Movie> movies) {
        if (this.movies == null)
            this.movies = movies;
        else
            this.movies.addAll(movies);
    }

    public void clear () {
        movies.clear();
    }
}
