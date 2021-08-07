package com.example.tiktokclone;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.tiktokclone.Fragments.ChatFragment;
import com.example.tiktokclone.Fragments.CreateVideoFragment;
import com.example.tiktokclone.Fragments.HomeFragment;
import com.example.tiktokclone.Fragments.ProfileFragment;
import com.example.tiktokclone.Fragments.SearchFragmet;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TikTok extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tik_tok);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();

        bottomNavigationView = findViewById(R.id.bottomView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.Home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.Search:
                        fragment = new SearchFragmet();
                        break;
                    case R.id.CreateVideo:
                        fragment = new CreateVideoFragment();
                        break;
                    case R.id.Chat:
                        fragment = new ChatFragment();
                        break;
                    case R.id.Profile:
                        fragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                return true;
            }

        });
    }
}