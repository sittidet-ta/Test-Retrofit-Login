package com.example.loginrestfitwebserviceexample.remote;

import android.util.Log;
import android.widget.Toast;

import retrofit2.Retrofit;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String url) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .build();

        }
        Log.i("return retrofit: ", retrofit.toString());
        return retrofit;


    }
}
