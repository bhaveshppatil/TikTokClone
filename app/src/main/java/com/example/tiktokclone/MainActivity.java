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
    private EditText etEmail, etPasswd;
    private Button btnLogin;
    private CheckBox checkBox;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
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
        etEmail = findViewById(R.id.etName);
        etPasswd = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        checkBox = findViewById(R.id.RemCheckbox);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    String email = etEmail.getText().toString();
                    String passwd = etPasswd.getText().toString();
                    if (email.matches(emailPattern) && passwd.length() > 6){
                        saveLoginData(email, passwd);
                    }else {
                        etEmail.setError("email or password invalid. Please check");
                    }
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