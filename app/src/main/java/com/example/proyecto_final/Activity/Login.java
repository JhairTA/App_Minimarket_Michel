package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.proyecto_final.R;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private TextView goToLoginAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        goToLoginAdmin=findViewById(R.id.goToLoginAdmin);

        goToLoginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,LoginAdmin.class));
            }
        });
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