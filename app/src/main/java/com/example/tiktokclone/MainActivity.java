package com.example.tiktokclone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "myFile";
    private EditText etName, etPasswd;
    private Button btnLogin;
    private CheckBox checkBox;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        if (DataSaver.getLoginData(getApplicationContext())) {
            Intent intent = new Intent(getApplicationContext(), TikTok.class);
            startActivity(intent);
        }
    }

    private void initViews() {
        etName = findViewById(R.id.etName);
        etPasswd = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        checkBox = findViewById(R.id.RemCheckbox);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    String name = etName.getText().toString();
                    String passwd = etPasswd.getText().toString();
                    saveLoginData(name, passwd);
                }
            }
        });
    }

    private void saveLoginData(String name, String passwd) {
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        Intent intent = new Intent(MainActivity.this, TikTok.class);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("passwd", passwd);
        editor.apply();
        startActivity(intent);
    }
}