package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.proyecto_final.R;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginIngresar extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText correo,contraseña;
    private TextView goToRegistrar,goToReset;
    private Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ingresar);

        auth=FirebaseAuth.getInstance();
        correo=findViewById(R.id.email1);
        contraseña=findViewById(R.id.password);
        ingresar=findViewById(R.id.ingresar);
        goToRegistrar=findViewById(R.id.goToRegistrar);
        goToReset=findViewById(R.id.resetContraseña);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = correo.getText().toString();
                String password = contraseña.getText().toString();

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if (!password.isEmpty()){
                        auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(LoginIngresar.this, "Bienvenido a Minimarket Michel", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginIngresar.this,InicioActivity.class));
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginIngresar.this, "Ingreso Fallido", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else {
                        contraseña.setError("La contraseña es obligatoria");
                    }

                }else if(email.isEmpty()){
                    correo.setError("El correo es obligatorio");
                }else{
                    correo.setError("Por favor Ingrese un correo valido");
                }
            }
        });

        goToRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginIngresar.this,LoginRegistrar.class));
            }
        });
        goToReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginIngresar.this);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_forgot, null);
                EditText emailBox = dialogView.findViewById(R.id.emailBox);
                builder.setView(dialogView);
                AlertDialog dialog = builder.create();
                dialogView.findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String userEmail = emailBox.getText().toString();
                        if (TextUtils.isEmpty(userEmail) && !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
                            Toast.makeText(LoginIngresar.this, "Ingrese el correo con el que se registro", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        auth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(LoginIngresar.this, "Verifique su correo", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                } else {
                                    Toast.makeText(LoginIngresar.this, "Error de envio", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                dialogView.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                if (dialog.getWindow() != null){
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                }
                dialog.show();
            }
        });
    }

    public void checkUser(){
        String usercorreo = correo.getText().toString().trim();
        String userpass = contraseña.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Usuarios");
        Query checkUserDatabase = reference.orderByChild("correo").equalTo(usercorreo);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}