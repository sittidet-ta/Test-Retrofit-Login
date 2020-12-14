package com.example.loginrestfitwebserviceexample.remote;

import retrofit2.Retrofit;

public class ApiUtils {

    public static final String BASE_URL = "http://10.0.2.2/TestPHP/SessionAndCookie/";

    private static Retrofit retrofit() {
        return RetrofitClient.getClient(BASE_URL);
    }
    public static UserService getUserService() {
        return retrofit().create(UserService.class);
    }
}
