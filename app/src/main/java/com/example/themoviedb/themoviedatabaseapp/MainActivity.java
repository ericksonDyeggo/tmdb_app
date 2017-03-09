package com.example.themoviedb.themoviedatabaseapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.themoviedb.themoviedatabaseapp.custom.adapter.ImageAdapter;
import com.example.themoviedb.themoviedatabaseapp.custom.listener.EndlessScrollListener;
import com.example.themoviedb.themoviedatabaseapp.model.UpComingMovies;
import com.example.themoviedb.themoviedatabaseapp.rest_client.TMDBMovie;
import com.example.themoviedb.themoviedatabaseapp.rest_client.TMDBService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import retrofit2.Call;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main)
public class MainActivity extends AppCompatActivity {

    @InstanceState
    int page = 1;
    TMDBService service;
    TMDBMovie tmdbMovie;
    ProgressDialog progressDialog;
    String prefUser;

    @ViewById
    GridView moviesGridView;

    @NonConfigurationInstance
    @Bean
    ImageAdapter adapter;

    @AfterViews
        // Initialize our components
    void init() {
        prefUser = Utility.getPreferedOrder(this);

        progressDialog = new ProgressDialog(this);

        service = new TMDBService(getString(R.string.api_key));

        tmdbMovie = service.getTMDBMovie();

        startGridView();
    }

    private void startGridView() { // Initialize our GridView
        loadMore();

        moviesGridView.setAdapter(adapter);

        moviesGridView.setOnScrollListener(new EndlessScrollListener() {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {
                loadMore();
                return true;
            }
        });
    }

    @ItemClick
        // What to execute after normal click
    void moviesGridViewItemClicked(int position) {
        Intent mIntent = new Intent(this, DetailsActivity_.class);

        mIntent.putExtra("movie", adapter.getItem(position));

        startActivity(mIntent);
    }

    @OptionsItem(R.id.action_settings)
    void openSettings() {
        Intent mIntent = new Intent(this, SettingsActivity_.class);
        startActivity(mIntent);
    }

    private void loadMore() {
        startProgress();
        loadMovies();
    }

    private void startProgress() {
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.show();
    }

    @UiThread
    void stopProgress() {
        adapter.notifyDataSetChanged();
        progressDialog.dismiss();
    }

    @Background
    void loadMovies() {
        Call<UpComingMovies> call;

        if (prefUser.equals(getString(R.string.pref_order_by_popularity_key))) {
            call = tmdbMovie.getPopular(page++);
        } else if (prefUser.equals(getString(R.string.pref_order_by_top_rated_key))) {
            call = tmdbMovie.getTopRated(page++);
        } else {
            call = tmdbMovie.getPopular(page++);
        }

        try {
            adapter.addMovie(call.execute().body().getMovies());
        } catch (Exception e) {
            e.printStackTrace();
        }

        stopProgress();
    }
}
