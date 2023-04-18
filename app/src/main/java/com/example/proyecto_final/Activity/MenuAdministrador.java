package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.proyecto_final.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuAdministrador extends AppCompatActivity {

    Button mButtonCerrarSesion;

    FirebaseAuth mAuth;

    ImageView btnAnuncio, btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_administrador);

        mAuth=FirebaseAuth.getInstance();
        mButtonCerrarSesion = findViewById(R.id.btnSalir);

        btnAnuncio = findViewById(R.id.btnAnuncio);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        mButtonCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user= mAuth.getCurrentUser();
        if(user== null){
            irLogin();
        }
    }*/

    private void logout() {
        mAuth.signOut();
        irLogin();
    }

    private void irLogin() {
        Intent intent =new Intent(MenuAdministrador.this,Login.class);
        startActivity(intent);
        finish();
    }

    public void Anuncios(View view){
        Intent anuncio= new Intent(this, Rcyv_itemAnuncios.class);
        startActivity(anuncio);
    }

    public void Registrarempleados(View view){
        Intent anuncio= new Intent(this, RegistroEmpleado.class);
        startActivity(anuncio);
    }
}