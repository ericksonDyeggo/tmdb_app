package com.example.themoviedb.themoviedatabaseapp.rest_client;

import java.io.IOException;
import java.util.Locale;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by erickson on 12/02/17.
 */

public class TMDBService {
    public static final String API_URL = "https://api.themoviedb.org/3/";

    public final String API_KEY;

    Retrofit client;

    public TMDBService(String key) {
        API_KEY = key;

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new TMDBInterceptor())
                .build();

        client = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }

    public TMDBMovie getTMDBMovie() {
        return client.create(TMDBMovie.class);
    }

    private class TMDBInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();

            HttpUrl newUrl = original.url()
                    .newBuilder()
                    .addQueryParameter("api_key", API_KEY) // Add the api_key to the request
                    .addQueryParameter("language", Locale.getDefault().getLanguage())
                    .build();

            Request request = original.newBuilder().url(newUrl).build();
            return chain.proceed(request);
        }
    }
}
