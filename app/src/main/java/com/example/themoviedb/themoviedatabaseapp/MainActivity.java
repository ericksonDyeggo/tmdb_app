package com.example.themoviedb.themoviedatabaseapp;

import android.app.ProgressDialog;
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
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import retrofit2.Call;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    Integer page;
    TMDBService service;
    TMDBMovie tmdbMovie;
    ProgressDialog progressDialog;

    @ViewById
    GridView moviesGridView;

    @Bean
    ImageAdapter adapter;

    @AfterViews
    void onAV() {
        progressDialog = new ProgressDialog(this);

        service = new TMDBService(getString(R.string.api_key));

        tmdbMovie = service.getTMDBMovie();
        page = 1;

        startProgress();
        loadMore();

        moviesGridView.setOnScrollListener(new EndlessScrollListener() {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {
                loadMore();
                return true;
            }
        });
    }

    public void loadMore() {
        loadMovies();
        adapter.notifyDataSetChanged();
    }

    @UiThread
    void startProgress() {
        progressDialog.setMessage("Carregando");
        progressDialog.show();
    }

    @UiThread
    void stopProgress() {
        progressDialog.dismiss();
        moviesGridView.setAdapter(adapter);
    }

    @Background
    void loadMovies() {
        Call<UpComingMovies> call = tmdbMovie.getUpcomingMovies(page++);

        try {
            adapter.addMovie(call.execute().body().getMovies());
        } catch (Exception e) {
            e.printStackTrace();
        }
        stopProgress();
    }
}
