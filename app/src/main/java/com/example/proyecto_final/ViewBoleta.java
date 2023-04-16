package com.example.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyecto_final.Domain.DataBoleta;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

public class ViewBoleta extends AppCompatActivity {

    TextView user,bfecha,bmedPago,btotal,bprecio;


    ImageView but2;



    private List<DataBoleta> dataListboleta;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_boleta);

        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        databaseReference = FirebaseDatabase.getInstance().getReference("Pedidos").child(currentDate);
        user = findViewById(R.id.txtusuariopedido);
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
                    String vmedPago = productSnapshot.child("medioPago").getValue(String.class);
                    Double vprecio = productSnapshot.child("total").getValue(Double.class);
                    String vfecha = productSnapshot.child("fecha").getValue(String.class);
                    Integer vtotal = productSnapshot.child("totalproducto").getValue(Integer.class);



                    //Contenar para el qr
                    String textoConcatenado = vmedPago + " " + vprecio.toString() + " " + vfecha + " " + vtotal.toString();


                    String vuser = productSnapshot.child("usuario").getValue(String.class);

                    // Verificar si el objeto Double no es nulo antes de llamar al método doubleValue()


                    if(vmedPago != null) {
                        bmedPago.setText(vmedPago);
                    }

                    if(vprecio != null) {
                        bprecio.setText(String.format("%.2f", vprecio));
                    }

                    if(vfecha != null) {
                        bfecha.setText(vfecha);
                    }



                    if (vtotal != null) {
                        btotal.setText(vtotal.toString());
                    }


                    if(vuser != null) {
                        user.setText(vuser);
                    }
                    bfecha.setText(vfecha);
                    bmedPago.setText(vmedPago);

                    user.setText(vuser);


                    but2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
                            try {
                                BitMatrix bitMatrix = multiFormatWriter.encode(textoConcatenado, BarcodeFormat.QR_CODE, 300, 300);

                                BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
                                Bitmap bitmap=barcodeEncoder.createBitmap(bitMatrix);
                                imageView.setImageBitmap(bitmap);


                            }catch (WriterException e){
                                throw  new RuntimeException(e);
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
}