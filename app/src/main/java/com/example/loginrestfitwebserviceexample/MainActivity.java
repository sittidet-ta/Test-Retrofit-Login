package com.example.loginrestfitwebserviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginrestfitwebserviceexample.model.ResObj;
import com.example.loginrestfitwebserviceexample.remote.ApiUtils;
import com.example.loginrestfitwebserviceexample.remote.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView txtUsername;
    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userService = ApiUtils.getUserService();

        txtUsername = (TextView)findViewById(R.id.txtUsername);

        Bundle extras = getIntent().getExtras();
        String username;

        if (extras != null) {
            username = extras.getString("username");
            txtUsername.setText("Welcome " + username);
        }
    }

    private void doLogin(final String username, final String password) {
        Log.e("in doLogin before Call:", username + password);
        Call call = userService.getSubject(username);
        Log.e("in doLogin after Call:", username + password);
        call.enqueue(new Callback<ResObj>() {
            @Override
            public void onResponse(Call<ResObj> call, Response<ResObj> response) {
                try {
                    if (response.isSuccessful()) {
                        ResObj resObj = (ResObj) response.body();
                        if (resObj.getMessage().equals("true")) {
                            //login star main activity
                        } else {
                            Toast.makeText(MainActivity.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Log.e("Error", "con't onResponse");
                }
            }

            @Override
            public void onFailure(Call<ResObj> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}