package com.example.loginrestfitwebserviceexample.remote;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
    @POST("login.php")
    Call login(@Field("username") String username, @Field("password") String password);
}
