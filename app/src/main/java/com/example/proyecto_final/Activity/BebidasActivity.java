package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.proyecto_final.R;
import android.os.Bundle;
import android.widget.TextView;

public class BebidasActivity extends AppCompatActivity {
    private TextView addToCartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);
    }
}