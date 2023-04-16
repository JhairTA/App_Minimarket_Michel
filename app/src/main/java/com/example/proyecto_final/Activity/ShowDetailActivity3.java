package com.example.proyecto_final.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.proyecto_final.Domain.Producto;
import com.example.proyecto_final.Domain.ProductoYogurts;
import com.example.proyecto_final.Helper.ManagementCart;
import com.example.proyecto_final.Helper.ManagementCart3;
import com.example.proyecto_final.R;

public class ShowDetailActivity3 extends AppCompatActivity {
    private Toolbar toolbar2;
    private TextView addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt;
    private ImageView plusBtn, minusBtn, picFood;
    private Producto object;
    int numberOrder=1;

    private ManagementCart3 managementCart3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        toolbar2 = findViewById(R.id.toolbar2);
        toolbar2.setTitle("Categoria > Recomendado");
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        managementCart3=new ManagementCart3(this);
        initView();
        getBundle();
    }
Context context;
    private void getBundle() {
        object=(Producto) getIntent().getSerializableExtra("object");
        titleTxt.setText(object.getTitle());
        feeTxt.setText("" + object.getFee());
        descriptionTxt.setText("");
        numberOrderTxt.setText(String.valueOf(numberOrder));
        Glide.with(getApplicationContext())
                .load(object.getPic())
                .into(picFood);
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder=numberOrder+1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberOrder>1){
                    numberOrder=numberOrder-1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(numberOrder);
                managementCart3.insertProducto(object);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);


            }
        });
    }

    private void initView() {
        addToCartBtn=findViewById(R.id.addToCartBtn);
        titleTxt=findViewById(R.id.titleTxt);
        feeTxt=findViewById(R.id.priceTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        numberOrderTxt=findViewById(R.id.numberOrderTxt);
        plusBtn=findViewById(R.id.plusBtn);
        minusBtn=findViewById(R.id.minusBtn);
        picFood=findViewById(R.id.picfood);
    }
}