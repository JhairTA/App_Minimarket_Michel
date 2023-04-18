package com.example.proyecto_final.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.proyecto_final.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DatosUsuarioActivity extends AppCompatActivity {

    TextView nombre, apellido, genero, ubicacion, telefono, correo, contraseña;

    /*Declaramos la autenticacion de Firebase*/
    FirebaseAuth firebaseAuth;

    /*Declaramos FireBaseUser para gestionar el usuario actual*/
    FirebaseUser user;

    /*Declaramos la bd de firebase*/
    DatabaseReference BASE_DE_DATOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);

        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        genero = findViewById(R.id.genero);
        ubicacion = findViewById(R.id.ubicacion);
        telefono = findViewById(R.id.telefono);
        correo = findViewById(R.id.correo);
        contraseña = findViewById(R.id.contraseña);
        /*showUserData()*/;

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        BASE_DE_DATOS = FirebaseDatabase.getInstance().getReference("Usuarios");
        /*Query checkUserDatabase = BASE_DE_DATOS.orderByChild("apellido").equalTo(apellido.toString());*/

        /*Obtemos los datos de usuario*/

        BASE_DE_DATOS.child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                /*Si el usuario existe*/
                if (snapshot.exists()){


                    /*Obtenemos los datos de firebase*/
                    String nombreusuario = "" + snapshot.child("nombre").getValue();
                    String apellidousuario  = "" + snapshot.child("apellido").getValue();
                    String generousuario  = "" + snapshot.child("genero").getValue();
                    String telefonousuario  = "" + snapshot.child("telefono").getValue();
                    String ubicacionusuario  = "" + snapshot.child("ubicacion").getValue();
                    String correousuario  = "" + snapshot.child("correo").getValue();
                    String contraseñausuario  = "" + snapshot.child("contraseña").getValue();

                    /*Seteamos los datos en los textwiev*/

                    nombre.setText(nombreusuario);
                    apellido.setText(apellidousuario);
                    genero.setText(generousuario);
                    telefono.setText(telefonousuario);
                    ubicacion.setText(ubicacionusuario);
                    correo.setText(correousuario);
                    contraseña.setText(contraseñausuario);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    /*public void showUserData(){
        Intent intent = getIntent();
        String nombreUser = intent.getStringExtra("nombre");
        String apellidoUser = intent.getStringExtra("apellido");
        String generoUser = intent.getStringExtra("genero");
        String telefonoUser = intent.getStringExtra("telefono");
        String ubicacionUser = intent.getStringExtra("ubicacion");
        String correoUser = intent.getStringExtra("correo");
        String contraseñaUser = intent.getStringExtra("contraseña");

        nombre.setText(nombreUser);
        apellido.setText(apellidoUser);
        genero.setText(generoUser);
        ubicacion.setText(telefonoUser);
        telefono.setText(ubicacionUser);
        correo.setText(correoUser);
        contraseña.setText(contraseñaUser);
    }*/
}