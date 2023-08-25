package com.jhonatan.hunnids;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;

import com.jhonatan.hunnids.databinding.ActivityLoginBinding;
public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    private SharedPreferences sharedPreferences;
    public static String SESSION_PREFERENCE = "SESSION_PREFERENCE";

    public static String SESSION_ACTIVATED = "SESSION_ACTIVATED";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int nightModeFlags = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case Configuration.UI_MODE_NIGHT_NO:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                // Opcionalmente, puedes manejar el modo desconocido aquí
                break;
        }
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences(SESSION_PREFERENCE,MODE_PRIVATE);
        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.tilEmail.getEditText().getText().toString();
            String password = binding.password.getEditText().getText().toString();
            sharedPreferences.edit().putBoolean(SESSION_ACTIVATED,true).apply();
            if (email.equals("ejemploe@idat.com.pe") && password.equals("Peru123")) {
                Intent intent = new Intent(this, PrincipalActivity.class);
                startActivity(intent);
                finish();
            } else {
                //
            }
        });


            //Toast.makeText(this,"Login Press", Toast.LENGTH_SHORT).show();

        binding.tilEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = s.toString();
                String password = binding.password.getEditText().getText().toString();
                boolean isOK = email.equals("ejemploe@idat.com.pe") && password.equals("Peru123");
                binding.btnLogin.setEnabled(isOK);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = binding.tilEmail.getEditText().getText().toString();
                String password = s.toString();
                boolean isOK = email.equals("ejemploe@idat.com.pe") && password.equals("Peru123");
                binding.btnLogin.setEnabled(isOK);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    private Boolean credenciales(String email, String password){
        String regex = ".*[a-zA-Z].*";
        Boolean isEmailOk = !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
        Boolean isPasswordOk = false;
        if (password.length() >= 8 && password.matches(regex)){
            isPasswordOk = true;
        }

        return isEmailOk && isPasswordOk;
    }
}