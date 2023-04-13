package com.example.proyecto_final.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.proyecto_final.Domain.ProductoGeneral;
import com.example.proyecto_final.Domain.ProductoYogurts;
import com.example.proyecto_final.Helper.ManagementCart;
import com.example.proyecto_final.Helper.ManagementGeneralCart;
import com.example.proyecto_final.R;

public class ShowDetailGeneralActivity extends AppCompatActivity {
    private Toolbar toolbar2;
    private TextView addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt;
    private ImageView plusBtn, minusBtn, picFood;
    private ProductoGeneral object;
    int numberOrder=1;

    private ManagementGeneralCart managementGeneralCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        toolbar2 = findViewById(R.id.toolbar2);
        toolbar2.setTitle("Categoria");
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        managementGeneralCart=new ManagementGeneralCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {
        object=(ProductoGeneral) getIntent().getSerializableExtra("object");

        int drawableResourceId=this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());
        Glide.with(this).load(drawableResourceId).into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("S/." + object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));

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
                managementGeneralCart.insertGerenal(object);
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