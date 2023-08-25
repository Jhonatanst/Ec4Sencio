package com.jhonatan.hunnids;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.jhonatan.hunnids.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        sharedPreferences  = getSharedPreferences(LoginActivity.SESSION_PREFERENCE,MODE_PRIVATE);
        setContentView(binding.getRoot());
        boolean isSessionActivated = sharedPreferences.getBoolean(LoginActivity.SESSION_ACTIVATED,false);
        if(isSessionActivated){
            Intent intent = new Intent(this , PrincipalActivity.class);
            startActivity(intent);
            finish();
        }
        binding.Boton.setOnClickListener(v -> {

            Intent intent = new Intent(this , LoginActivity.class);
            startActivity(intent);
            finish();
        });


    }
}