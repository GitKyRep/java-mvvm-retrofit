package com.rizkysaraan.javaretrofitmvvm.view.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.rizkysaraan.javaretrofitmvvm.databinding.ActivityMainMenuBinding;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainMenuBinding mainMenu = ActivityMainMenuBinding.inflate(getLayoutInflater());
        setContentView(mainMenu.getRoot());
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        mainMenu.btnAutocomplete.setOnClickListener(v -> {
            Intent mvvmAutocomplete = new Intent(MainMenuActivity.this, AutoCompleteActivity.class);
            startActivity(mvvmAutocomplete);
        });

        mainMenu.btnRecycleview.setOnClickListener(v -> {
            Intent mvvmRecycleview = new Intent(MainMenuActivity.this, RecycleviewActivity.class);
            startActivity(mvvmRecycleview);
        });
    }
}