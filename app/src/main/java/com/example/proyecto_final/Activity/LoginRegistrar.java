package com.example.proyecto_final.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.proyecto_final.R;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginRegistrar extends AppCompatActivity {

    private EditText n,ap,ge,ub,tel,cor,con;
    private TextView goToIngresar;
    private Button bt;

    private String nombre="";
    private String apellido="";
    private String genero="";
    private String ubicacion="";
    private String telefono="";
    private String correo="";
    private String contraseña="";
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_registrar);

        mAuth=FirebaseAuth.getInstance();

        n=(EditText) findViewById(R.id.nombre);
        ap=(EditText) findViewById(R.id.apellido);
        ge=(EditText) findViewById(R.id.genero);
        ub=(EditText) findViewById(R.id.ubicacion);
        tel=(EditText) findViewById(R.id.telefono);
        cor=(EditText) findViewById(R.id.correo);
        con=(EditText) findViewById(R.id.contraseña);
        bt=(Button) findViewById(R.id.registrar);
        goToIngresar=(TextView)findViewById(R.id.goToIngresar) ;

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre=n.getText().toString().trim();
                apellido=ap.getText().toString().trim();
                genero=n.getText().toString().trim();
                ubicacion=ub.getText().toString().trim();
                telefono=tel.getText().toString().trim();
                correo=cor.getText().toString().trim();
                contraseña=con.getText().toString().trim();

                if (!nombre.isEmpty() && !apellido.isEmpty() && !genero.isEmpty() && !ubicacion.isEmpty() && !telefono.isEmpty() && !correo.isEmpty() && !contraseña.isEmpty()){
                    if (contraseña.length()>=6){
                        mAuth.createUserWithEmailAndPassword(correo,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull  Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(LoginRegistrar.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginRegistrar.this,LoginIngresar.class));
                                }else {
                                    Toast.makeText(LoginRegistrar.this, "Error al registrar"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }else{
                        Toast.makeText(LoginRegistrar.this, "La contraseña debe tener como mínimo 6 caracteres", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(LoginRegistrar.this, "Debe completar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        goToIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginRegistrar.this,LoginIngresar.class));
            }
        });
    }
}