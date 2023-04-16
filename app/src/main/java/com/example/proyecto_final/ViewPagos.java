package com.example.proyecto_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_final.Domain.DataOrden;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;

public class ViewPagos extends AppCompatActivity {

    EditText txtTarg,txtcalend,txtcvv,txtnom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pagos);

        txtTarg = findViewById(R.id.txtnrtargeta);
        txtcalend = findViewById(R.id.txtcalendtarget);
        txtcvv = findViewById(R.id.txtcvv);
        txtnom = findViewById(R.id.txtnombretrg);

    }
    public void Pago (View view){
        long nrtarg = 4242424242424242L;

        String strTarg = txtTarg.getText().toString();
        DecimalFormat df = new DecimalFormat("#,###");

        try {
            if (Long.parseLong(strTarg) == nrtarg) {
                Intent login2 = new Intent(this, ViewBoleta.class);
                startActivity(login2);
                Toast.makeText(this, "Se realizó el pago con éxito", Toast.LENGTH_SHORT).show();
                txtTarg.setText("");
            } else {
                Toast.makeText(this, "No se realizó el pago", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {

            Toast.makeText(this, "Error: Rellene todos los campos ", Toast.LENGTH_SHORT).show();

        }


    }
}