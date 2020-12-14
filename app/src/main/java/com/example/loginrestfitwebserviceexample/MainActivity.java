package com.example.loginrestfitwebserviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = (TextView)findViewById(R.id.txtUsername);

        Bundle extras = getIntent().getExtras();
        String username;

        if (extras != null) {
            username = extras.getString("username");
            txtUsername.setText("Welcome " + username);
        }
    }
}