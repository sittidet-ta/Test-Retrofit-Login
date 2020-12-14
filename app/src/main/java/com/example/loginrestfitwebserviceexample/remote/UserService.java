package com.example.loginrestfitwebserviceexample.remote;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
    @GET("login.php")
    Call login(@Path("username") String username,
               @Path("password") String password);
}
