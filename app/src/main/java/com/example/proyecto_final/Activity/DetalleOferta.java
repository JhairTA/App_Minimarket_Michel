package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.example.proyecto_final.R;
public class DetalleOferta extends AppCompatActivity {

    TextView detailDesc, detailTitle;
    ImageView detailImage;

    String key = "";
    String imageUrl = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_oferta);


        detailDesc = findViewById(R.id.detailDesc);
        detailTitle = findViewById(R.id.detailTitle);
        detailImage = findViewById(R.id.detailImage);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            detailDesc.setText(bundle.getString("Descripcion"));
            detailTitle.setText(bundle.getString("Title"));
            key = bundle.getString("Key");
            imageUrl = bundle.getString("Image");
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }

    }
}