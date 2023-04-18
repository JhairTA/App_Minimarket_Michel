package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.proyecto_final.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuActivity extends AppCompatActivity {

    LinearLayout mButtonCerrarSesion;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mAuth=FirebaseAuth.getInstance();
        mButtonCerrarSesion = findViewById(R.id.btnCerrarSesion);

        mButtonCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user= mAuth.getCurrentUser();
        if(user== null){
            irLogin();
        }
    }

    private void logout() {
        mAuth.signOut();
        irLogin();
    }

    private void irLogin() {
        Intent intent =new Intent(MenuActivity.this,Login.class);
        startActivity(intent);
        finish();
    }


    public void inicio(View view){
        Intent intent =new Intent(this, InicioActivity.class);
        startActivity(intent);
    }

    public void categoria(View view){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /*public void micuenta(View view){
        Intent intent =new Intent(this, DatosUsuarioActivity.class);
        startActivity(intent);
    }*/

    public void ofertas(View view){
        Intent intent =new Intent(this, MasOfertas.class);
        startActivity(intent);
    }

    public void mipedido(View view){
        Intent intent =new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}