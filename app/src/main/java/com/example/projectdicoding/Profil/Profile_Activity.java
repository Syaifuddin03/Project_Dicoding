package com.example.projectdicoding.Profil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projectdicoding.R;

public class Profile_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_);

        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
