package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final.Adaptor.CategoryAdaptor;
import com.example.proyecto_final.Adaptor.ProductoCuidadoBucalAdaptor;
import com.example.proyecto_final.Adaptor.ProductoHigienePersonalAdaptor;
import com.example.proyecto_final.Adaptor.ProductoYogurtsAdaptor;
import com.example.proyecto_final.Domain.CategoryDomain;
import com.example.proyecto_final.Domain.ProductoGeneral;
import com.example.proyecto_final.Domain.ProductoYogurts;
import com.example.proyecto_final.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class CuidadoPersonalActivity extends AppCompatActivity {

    private Toolbar toolbar1;

    private RecyclerView.Adapter adapter, adapter2, adapter3;

    private RecyclerView recyclerViewCategoriaList, recyclerViewProductoCuidadoBucalList, recyclerViewProductoHigienePersonalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuidado_personal);

        toolbar1 = findViewById(R.id.toolbar1);
        toolbar1.setTitle("Categoria");
        setSupportActionBar(toolbar1);

        recyclerViewCategoria();
        recyclerViewProductoCuidadoBucal();
        recyclerViewProductoHigienePersonal();
    }

    public void buscar(View view){
        Intent intent =new Intent(this, BuscadorActivity.class);
        startActivity(intent);
    }

    public void inicio(View view){
        Intent intent =new Intent(this, InicioActivity.class);
        startActivity(intent);
    }

    public void menu(View view){
        Intent intent =new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    private void recyclerViewCategoria() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoriaList = findViewById(R.id.rv1);
        recyclerViewCategoriaList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoria = new ArrayList<>();
        categoria.add(new CategoryDomain("LACTEOS", "lacteos"));
        categoria.add(new CategoryDomain("BEBIDAS", "refresco"));
        categoria.add(new CategoryDomain("SNACKS", "golosinas"));
        categoria.add(new CategoryDomain("LIMPIEZA", "limpieza"));
        categoria.add(new CategoryDomain("CUIDADO.P", "cuidadopersonal"));
        categoria.add(new CategoryDomain("MASCOTA", "mascota"));

        CategoryAdaptor adapter=new CategoryAdaptor(categoria);
        adapter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String posinom = categoria.get(recyclerViewCategoriaList.getChildAdapterPosition(view)).getTitle();
                Toast.makeText(getApplicationContext(), "Sección: " + posinom, Toast.LENGTH_SHORT).show();

                switch (posinom){
                    case "LACTEOS":{
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case "SNACKS":{
                        Intent intent = new Intent(getApplicationContext(), SnacksActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case "LIMPIEZA":{
                        Intent intent = new Intent(getApplicationContext(), LimpiezaActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case "BEBIDAS":{
                        Intent intent = new Intent(getApplicationContext(), BebidasActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case "MASCOTA":{
                        Intent intent = new Intent(getApplicationContext(), MascotaActivity.class);
                        startActivity(intent);
                        break;
                    }
                }


            }
        });
        recyclerViewCategoriaList.setAdapter(adapter);
    }

    private void recyclerViewProductoCuidadoBucal(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewProductoCuidadoBucalList = findViewById(R.id.rv2);
        recyclerViewProductoCuidadoBucalList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoCuidadoBucalList = new ArrayList<>();
        productoCuidadoBucalList.add(new ProductoGeneral("Pasta Dental Colgate Paquete 3un", "cu_colgate", "fdsf",18.00));
        productoCuidadoBucalList.add(new ProductoGeneral("Listerine Enjuague Bucal 500ml", "cu_listerine", "fdsf",17.00));
        productoCuidadoBucalList.add(new ProductoGeneral("Hilo Dental Oral-B X 1 Unidad", "cu_hilo", "fdsf",11.75));
        productoCuidadoBucalList.add(new ProductoGeneral("Cepillo Dental Colgate 3 Unidades", "cu_cepillo", "fdsf",15.20));
        productoCuidadoBucalList.add(new ProductoGeneral("Pasta Dental Oral-B Caja 75ml", "cu_oralb", "fdsf",12.50));
        productoCuidadoBucalList.add(new ProductoGeneral("Colgate Enjuague Bucal X 500ml", "cu_colgateenjuage", "fdsf",17.58));
        productoCuidadoBucalList.add(new ProductoGeneral("Pasta Dental Dento Tubo 75ml", "cu_dento", "fdsf",15.20));
        productoCuidadoBucalList.add(new ProductoGeneral("Cepillo Electrico Oral-B Caja 1un", "cu_cepilloelectrico", "fdsf",59.90));
        productoCuidadoBucalList.add(new ProductoGeneral("Dento Enjuague Bucal Menta 500ml", "cu_dentoenjuage", "fdsf",14.50));
        productoCuidadoBucalList.add(new ProductoGeneral("Hilo Dental Colgate X 1 Unidad", "cu_colgatehilo", "fdsf",13.19));

        adapter2=new ProductoCuidadoBucalAdaptor(productoCuidadoBucalList);
        recyclerViewProductoCuidadoBucalList.setAdapter(adapter2);
    }

    private void recyclerViewProductoHigienePersonal(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewProductoHigienePersonalList = findViewById(R.id.rv3);
        recyclerViewProductoHigienePersonalList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoHigienePersonalList = new ArrayList<>();
        productoHigienePersonalList.add(new ProductoGeneral("Jabón Dove Cremoso Original 3un", "hp_dove", "fdsf",11.70));
        productoHigienePersonalList.add(new ProductoGeneral("Moncler Jabón Azul Barra 145g ", "hp_moncler", "fdsf",5.10));
        productoHigienePersonalList.add(new ProductoGeneral("Desodorante Axe Epic Fres 150ml", "hp_axe", "fdsf",12.90));
        productoHigienePersonalList.add(new ProductoGeneral("Jabón en Barra Protex Fresh", "hp_protex", "fdsf",3.20));
        productoHigienePersonalList.add(new ProductoGeneral("Desodorante Lady Speed Stick Barra 45g", "hp_ladyspeed", "fdsf",19.30));
        productoHigienePersonalList.add(new ProductoGeneral("Desodorante Rexona Invisible X 150ml", "hp_rexona", "fdsf",17.58));
        productoHigienePersonalList.add(new ProductoGeneral("H&S Classic Clean 650ml", "hp_hs", "fdsf",10.50));
        productoHigienePersonalList.add(new ProductoGeneral("Desodorante Old Spice - Spray 150ml", "hp_oldspice", "fdsf",17.40));
        productoHigienePersonalList.add(new ProductoGeneral("Jabón Liquido Aval Frutos Rojos 800ml", "hp_aval", "fdsf",13.20));
        productoHigienePersonalList.add(new ProductoGeneral("Nivea Soft Crema Humectante X 100 ml", "hp_nivea", "fdsf",18.90));

        adapter3=new ProductoHigienePersonalAdaptor(productoHigienePersonalList);
        recyclerViewProductoHigienePersonalList.setAdapter(adapter3);
    }
}