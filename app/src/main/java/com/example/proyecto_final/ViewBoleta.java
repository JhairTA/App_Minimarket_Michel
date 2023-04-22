package com.example.proyecto_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyecto_final.Activity.CarritoActivity;
import com.example.proyecto_final.Activity.InicioActivity;
import com.example.proyecto_final.Domain.DataBoleta;
import com.example.proyecto_final.Helper.ManagementCart3;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ktx.Firebase;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ViewBoleta extends AppCompatActivity {

    ManagementCart3 managementCart3;
    TextView buser,bfecha,bmedPago,btotal,bprecio;

    ImageView but2;
    private List<DataBoleta> dataListboleta;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_boleta);


        databaseReference = FirebaseDatabase.getInstance().getReference("Boleta");
        buser = findViewById(R.id.txtusuariopedido);
        bfecha = findViewById(R.id.txtfecha);
        bmedPago = findViewById(R.id.metpago);
        btotal = findViewById(R.id.txtTotalproducto);
        bprecio = findViewById(R.id.txtpreciototal);
        ImageView imageView=findViewById(R.id.qr_code);
        but2=findViewById(R.id.qr_code);





        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {
                    // String vmedPago = productSnapshot.child("medioPago").getValue(String.class);
                    Double vprecio = productSnapshot.child("total").getValue(Double.class);
                    String vfecha = productSnapshot.child("fecha").getValue(String.class);
                    Integer vtotal = productSnapshot.child("totalproducto").getValue(Integer.class);

                    String vuser = productSnapshot.child("apellido").getValue(String.class);


                    //Contenar para el qr
                    String textoConcatenado = vuser + " " + vprecio.toString() + " " + vfecha + " " + vtotal.toString();




                    // Verificar si el objeto Double no es nulo antes de llamar al método doubleValue()

/*
                    if (vmedPago != null) {
                        bmedPago.setText(vmedPago);
                    }*/

                    if (vprecio != null) {
                        bprecio.setText("S/" + String.format("%.2f", vprecio));
                    }

                    if (vfecha != null) {
                        bfecha.setText(vfecha);
                    }


                    if (vtotal != null) {
                        btotal.setText(vtotal.toString());
                    }


                    if (vuser != null) {
                        buser.setText(vuser);
                    }
                    bfecha.setText(vfecha);
                    // bmedPago.setText(vmedPago);

                    buser.setText(vuser);


                    but2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                            try {
                                BitMatrix bitMatrix = multiFormatWriter.encode(textoConcatenado, BarcodeFormat.QR_CODE, 300, 300);

                                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                                imageView.setImageBitmap(bitmap);


                            } catch (WriterException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    public void SeguirComprando(View view) {
        Intent login = new Intent(this, InicioActivity.class);
        startActivity(login);
    }
}