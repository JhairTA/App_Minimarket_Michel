package com.example.proyecto_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_final.Activity.CarritoActivity;
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
    TextView textView,textuser,textfecha,txtprecio,txtcantidad;

    Button btnPagar;

    DataOrden dataOrden;
    Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pedidos);
        btnPagar = findViewById(R.id.btnPagar);

        //Fecha automatica
        Date date =new Date();
        textfecha=findViewById(R.id.txtfecha);
        SimpleDateFormat FechaC=new SimpleDateFormat("d MMMM 'del' yyyy");
        String sFecha=FechaC.format(date);
        textfecha.setText(sFecha);


//
        textView = (TextView) findViewById(R.id.txtpreciototal);
        textuser = (TextView) findViewById(R.id.txtusuariopedido);

        String precio=getIntent().getStringExtra("total") ;
        textView.setText(precio);//


        //
        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                Intent login1 = new Intent(ViewPedidos.this, ViewPagos.class);
                startActivity(login1);
            }
        });
    }
    //
    public void saveData(){
        String user = textuser.getText().toString();
        String prec = textView.getText().toString();
        String fec = textfecha.getText().toString();
        /*String cantd = txtcantidad.getText().toString();
        int cantidadInt = Integer.parseInt(cantd);*/
        double preciototal = Double.parseDouble(prec);


        DataBoleta dataClass = new  DataBoleta(preciototal, fec);

        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());


        FirebaseDatabase.getInstance().getReference("Pedidos").child(currentDate).setValue(dataClass)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
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







    public void Ingresar (View view){
        Intent login = new Intent(this, ListaProductospedido.class);
        startActivity(login);
    }

    public void ModificarPedido (View view){
        Intent login = new Intent(this, CarritoActivity.class);
        startActivity(login);
    }

    public void Ingresarpagos (View view){


    }
}