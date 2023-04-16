package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.proyecto_final.R;

public class RegistroEmpleado extends AppCompatActivity {

    private EditText n,ap,dn,user,tel,cor,con;
    private Button bt;

    private String nombre="";
    private String apellido="";
    private String dni="";
    private String usuario="";
    private String telefono="";
    private String correo="";
    private String contraseña="";
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_empleado);


        n=(EditText) findViewById(R.id.name);
        ap=(EditText) findViewById(R.id.apell);
        dn=(EditText) findViewById(R.id.doc);
        user=(EditText) findViewById(R.id.usuar);
        tel=(EditText) findViewById(R.id.telef);
        cor=(EditText) findViewById(R.id.ema);
        con=(EditText) findViewById(R.id.passw);
        bt=(Button) findViewById(R.id.registrarAdmin);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database=FirebaseDatabase.getInstance();
                reference= database.getReference("empleados");


                nombre=n.getText().toString();
                apellido=ap.getText().toString();
                dni=dn.getText().toString();
                usuario=user.getText().toString();
                telefono=tel.getText().toString();
                correo=cor.getText().toString();
                contraseña=con.getText().toString();

                HelperClassAdmin helperClass=new HelperClassAdmin(nombre,apellido,dni,usuario,correo,telefono,contraseña);
                reference.child(usuario).setValue(helperClass);



                if (!nombre.isEmpty() && !apellido.isEmpty() && !dni.isEmpty() && !usuario.isEmpty() && !telefono.isEmpty() && !correo.isEmpty() && !contraseña.isEmpty()){
                    if (contraseña.length()>=6){
                        Toast.makeText(RegistroEmpleado.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegistroEmpleado.this,LoginAdmin.class));
                    }else{
                        Toast.makeText(RegistroEmpleado.this, "La contraseña debe tener como mínimo 6 caracteres", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(RegistroEmpleado.this, "Debe completar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}