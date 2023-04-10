package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.proyecto_final.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void cerrarsesion(View view){
        Intent intent =new Intent(this, Login.class);
        startActivity(intent);
    }

    public void inicio(View view){
        Intent intent =new Intent(this, InicioActivity.class);
        startActivity(intent);
    }

    public void categoria(View view){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}