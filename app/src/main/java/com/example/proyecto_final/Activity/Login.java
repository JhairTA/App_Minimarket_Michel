package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.proyecto_final.R;
import android.view.View;
import android.content.Intent;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void Ingresar(View view){
        Intent login=new Intent(this,LoginIngresar.class);
        startActivity(login);
    }
    public void Regisrar(View view){
        Intent login=new Intent(this,LoginRegistrar.class);
        startActivity(login);
    }
}