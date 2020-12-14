package com.example.loginrestfitwebserviceexample.remote;

import com.example.loginrestfitwebserviceexample.model.ResObj;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {
    @GET("login.php")///?username={username}&password={password}
    Call<ResObj> login(@Query("username") String username, @Query("password") String password);

    @GET("getSubject.php")///?username={username}&password={password}
    Call<ResObj> getSubject(@Query("username") String username);

    /*
    * use with data [{"id":"1"}, {"id":"2"}]
    * อะไรประมาณนี้*/
    @GET("getTeacher.php")///?username={username}&password={password}
    Call<List<String>> getTeacher();

    /*Call<String>
    * use with จำพวก ข้อความออกมาตรงๆเลย เช่น
    * echo "name"; ที่ แสดงที่หน้าเว็บเเลย*/
}
