package com.example.proyecto_final.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.example.proyecto_final.R;

public class LoginAdmin extends AppCompatActivity {

    private EditText etu,etp;
    private Button ingresar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        etu=findViewById(R.id.user);
        etp=findViewById(R.id.contra);
        ingresar2=findViewById(R.id.ingresar2);

        ingresar2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateUsuario() | !validatePassword()) {
                } else {
                    checkUser();
                }
            }
        }));


    }
    public Boolean validateUsuario() {
        String val = etu.getText().toString();
        if (val.isEmpty()) {
            etu.setError("El usuario no debe estar vacio");
            return false;
        } else {
            etu.setError(null);
            return true;
        }
    }
    public Boolean validatePassword(){
        String val = etp.getText().toString();
        if (val.isEmpty()) {
            etp.setError("La contraseña no debe estar vacia");
            return false;
        } else {
            etp.setError(null);
            return true;
        }
    }
    public void checkUser(){
        String userUsername = etu.getText().toString().trim();
        String userPassword = etp.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("empleados");
        Query checkUserDatabase = reference.orderByChild("usuario").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    etu.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("contraseña").getValue(String.class);
                    if (passwordFromDB.equals(userPassword)) {
                        etp.setError(null);
                        String nameFromDB = snapshot.child(userUsername).child("nombre").getValue(String.class);
                        String apellidoFromDB = snapshot.child(userUsername).child("apellido").getValue(String.class);
                        String dniFromDB = snapshot.child(userUsername).child("dni").getValue(String.class);
                        String phoneFromDB = snapshot.child(userUsername).child("telefono").getValue(String.class);
                        String emailFromDB = snapshot.child(userUsername).child("correo").getValue(String.class);
                        String usernameFromDB = snapshot.child(userUsername).child("usuario").getValue(String.class);
                        Intent intent = new Intent(LoginAdmin.this, RegistroEmpleado.class);
                        intent.putExtra("nombre", nameFromDB);
                        intent.putExtra("apellido", apellidoFromDB);
                        intent.putExtra("dni", dniFromDB);
                        intent.putExtra("telefono", phoneFromDB);
                        intent.putExtra("correo", emailFromDB);
                        intent.putExtra("usuario", usernameFromDB);
                        intent.putExtra("contraseña", passwordFromDB);
                        startActivity(intent);
                    } else {
                        etp.setError("Credenciales Invalidas");
                        etp.requestFocus();
                    }
                } else {
                    etu.setError("El usuario no existe");
                    etu.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}