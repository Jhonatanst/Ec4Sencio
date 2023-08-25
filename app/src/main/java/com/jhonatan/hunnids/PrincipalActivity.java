package com.jhonatan.hunnids;


import android.content.DialogInterface;
import android.view.MenuItem;
import android.app.AlertDialog;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;

import android.view.View;
import android.widget.Button;



import com.jhonatan.hunnids.databinding.ActivityPrincipalBinding;
import com.jhonatan.hunnids.fragments.HomeFragment;

public class PrincipalActivity extends AppCompatActivity {

    private ActivityPrincipalBinding binding;
    public static String EMAIL = "EMAIL";
    private String email;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        sharedPreferences = getSharedPreferences(LoginActivity.SESSION_PREFERENCE, MODE_PRIVATE);
        setContentView(binding.getRoot());
        setSupportActionBar(binding.tbPlayzoom);
        setSession();
        addHomeFragment();

    }

    private void addHomeFragment(){
        getSupportFragmentManager().beginTransaction().add(binding.fcvMain.getId(), new HomeFragment()).commit();


    }


    private void setSession(){
        Intent getIntent  = getIntent();
        email = getIntent.getStringExtra(EMAIL);
        binding.txtEmail.setText(email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movies_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            // Mostrar cuadro de diálogo de confirmación
            new AlertDialog.Builder(this)
                    .setTitle("Cerrar sesión")
                    .setMessage("¿Deseas cerrar la sesión?")
                    .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            sharedPreferences.edit().clear().apply();
                            Intent intent = new Intent(PrincipalActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // No hacer nada, simplemente cerrar el cuadro de diálogo
                        }
                    })
                    .show();
            return true;
        }else {
            if(item.getItemId() == R.id.Btn_ver){
                Intent intent = new Intent(PrincipalActivity.this, Detalles.class);
                startActivity(intent);
            }
            if(item.getItemId() == R.id.favori){
                Intent intente = new Intent(PrincipalActivity.this, Detalles.class);
                startActivity(intente);
            }
        }
        return false;
    }
}