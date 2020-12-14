package com.example.loginrestfitwebserviceexample.remote;

public class ApiUtils {

    public static final String BASE_URL = "http://localhost/TestPHP/SessionAndCookie/";

    public static UserService getUserService() {
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}
