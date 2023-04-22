package com.example.proyecto_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_final.Activity.CarritoActivity;
import com.example.proyecto_final.Activity.InicioActivity;
import com.example.proyecto_final.Activity.ShowDetail2Activity;
import com.example.proyecto_final.Domain.DataBoleta;
import com.example.proyecto_final.Domain.DataOrden;
import com.example.proyecto_final.Helper.ManagementCart3;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ViewPedidos extends AppCompatActivity {


    ManagementCart3 managementCart3;
    DatabaseReference databaseReference;
    TextView textView, textuser, textfecha, txtprecio, txtcantidad;

    Button btnPagar;

    DataOrden dataOrden;
    Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pedidos);
        btnPagar = findViewById(R.id.btnPagar);
        //
        textuser = findViewById(R.id.txtTusuario);

        //Fecha automatica
        Date date = new Date();
        textfecha = findViewById(R.id.txtfecha);
        SimpleDateFormat FechaC = new SimpleDateFormat("d MMMM 'del' yyyy");
        String sFecha = FechaC.format(date);
        textfecha.setText(sFecha);


//
        databaseReference = FirebaseDatabase.getInstance().getReference("Usuarios");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot productSnaphot : snapshot.getChildren()) {
                    String user1 = productSnaphot.child("apellido").getValue(String.class);
                    textuser.setText(user1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        textView = (TextView) findViewById(R.id.txtpreciototal);
        txtcantidad = (TextView) findViewById(R.id.txtTotalproducto);

        String precio = getIntent().getStringExtra("total");
        String cantid = getIntent().getStringExtra("itemTotal");
        textView.setText(precio);
        txtcantidad.setText(cantid);
        //


        //
        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                saveDataBoleta();
                Intent login1 = new Intent(ViewPedidos.this, ViewPagos.class);
                startActivity(login1);
            }
        });

        //
       /* FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("usuarios");

        textuser = findViewById(R.id.txtusuariopedido);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {
                    String nombre = productSnapshot.child("nombre").getValue(String.class);

                    if(nombre!= null) {
                        textuser.setText(nombre);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // En caso de que ocurra un error
            }
        });*/

    }

    //
    public void saveData() {
        String user = textuser.getText().toString();
        String prec = textView.getText().toString();
        String fec = textfecha.getText().toString();
        String cantd = txtcantidad.getText().toString();
        double cantidad = Double.parseDouble(cantd);
        double preciototal = Double.parseDouble(prec);


        DataBoleta dataClass = new DataBoleta(user, preciototal, fec);

        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());


        FirebaseDatabase.getInstance().getReference("Pedidos").child(currentDate).setValue(dataClass)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ViewPedidos.this, "Guardado", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ViewPedidos.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    public void saveDataBoleta() {

        String user = textuser.getText().toString();
        String prec = textView.getText().toString();
        String fec = textfecha.getText().toString();
        String cantd = txtcantidad.getText().toString();
        double cantidad = Double.parseDouble(cantd);
        double preciototal = Double.parseDouble(prec);


        DataBoleta dataClass = new DataBoleta(user, preciototal, fec);

        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());


        FirebaseDatabase.getInstance().getReference("Boleta").child(currentDate).setValue(dataClass)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ViewPedidos.this, "Guardado", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ViewPedidos.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });

    }


    /*public void Ingresar(View view) {
        Intent login = new Intent(this, ListaProductospedido.class);
        startActivity(login);
    }*/

    public void ModificarPedido(View view) {
        Intent login = new Intent(this, CarritoActivity.class);
        startActivity(login);
    }

    public void CancelarPedidos(View view) {
        Intent login = new Intent(this, InicioActivity.class);
        startActivity(login);
    }
}
