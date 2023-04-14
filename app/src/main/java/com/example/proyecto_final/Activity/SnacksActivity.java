package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final.Adaptor.CategoryAdaptor;
import com.example.proyecto_final.Adaptor.ProductoSnacksAdaptor;
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

public class SnacksActivity extends AppCompatActivity {

    private Toolbar toolbar1;

    private RecyclerView.Adapter adapter, adapter2, adapter3;

    private RecyclerView recyclerViewCategoriaList, recyclerViewProductoSnackList, recyclerViewProductoGalletasList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);

        toolbar1 = findViewById(R.id.toolbar1);
        toolbar1.setTitle("Categoria");
        setSupportActionBar(toolbar1);

        recyclerViewCategoria();
        recyclerViewProductoSnacks();
        recyclerViewProductoGalletas();
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
                Toast.makeText(getApplicationContext(), "Seleccion: " + posinom, Toast.LENGTH_SHORT).show();

                switch (posinom){
                    case "LACTEOS":{
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case "BEBIDAS":{
                        Intent intent = new Intent(getApplicationContext(), BebidasActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case "LIMPIEZA":{
                        Intent intent = new Intent(getApplicationContext(), LimpiezaActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case "CUIDADO.P":{
                        Intent intent = new Intent(getApplicationContext(), CuidadoPersonalActivity.class);
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

    private void recyclerViewProductoSnacks(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewProductoSnackList = findViewById(R.id.rv2);
        recyclerViewProductoSnackList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoSnacksList = new ArrayList<>();
        productoSnacksList.add(new ProductoGeneral("Papas Lays Clasicas Bolsa 40g","snack_lays","fd",2.20));
        productoSnacksList.add(new ProductoGeneral("Piqueo Snax Bolsa 200g","snack_piqueosnax","dsfs",8.90));
        productoSnacksList.add(new ProductoGeneral("Doritos Queso Atrevido Bolsa 210g","snack_doritos","dfdf",5.50));
        productoSnacksList.add(new ProductoGeneral("Cheese Tris Queso Bolsa 140g","snack_cheesetris","dfsdf",2.50));
        productoSnacksList.add(new ProductoGeneral("Papas Fritas Inka Chips Bolsa 33g","snack_inkachips","gfgfdg",2.20));
        productoSnacksList.add(new ProductoGeneral("Cheetos Queso Picante Bolsa 69g","snack_cheetos","dsdasd",1.70));
        productoSnacksList.add(new ProductoGeneral("Tor-Tees Clasico Bolsa 60g","snack_tortees","dfsgfd",3.20));
        productoSnacksList.add(new ProductoGeneral("Pringles Cebolla Grande 124gr","snack_pringles","",10.30));
        productoSnacksList.add(new ProductoGeneral("Lays Tostitos Original Bolsa 200g","snack_tostitos","fdfdfd",8.10));
        productoSnacksList.add(new ProductoGeneral("Frito Lay Chizitos Bolsa 35gr","snack_chizitos","gfgfgd",1.50));

        adapter2=new ProductoSnacksAdaptor(productoSnacksList);
        recyclerViewProductoSnackList.setAdapter(adapter2);
    }

    private void recyclerViewProductoGalletas(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewProductoGalletasList = findViewById(R.id.rv3);
        recyclerViewProductoGalletasList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoGalletasList = new ArrayList<>();
        productoGalletasList.add(new ProductoGeneral("Galleta Casino Black Canela X 261g","galleta_casino","hghfgg",3.50));
        productoGalletasList.add(new ProductoGeneral("Galleta Picaras Chocolate 6un","galletas_picaras","gfgdfgh",6.30));
        productoGalletasList.add(new ProductoGeneral("Galleta Morochas Paquete 6un","galleta_morochas","ghhgh",4.80));
        productoGalletasList.add(new ProductoGeneral("Galleta Tentación Naranja Paquete 6un","galleta_tentacion","gfhfgh",5.20));
        productoGalletasList.add(new ProductoGeneral("Galleta Chomp Chocolate Paquete 6un","galleta_chomp","gfgfgg",4.10));
        productoGalletasList.add(new ProductoGeneral("Galleta Margarita Sayon Paquete 6un","galleta_margarita","dfgdg",2.70));
        productoGalletasList.add(new ProductoGeneral("Galleta Oreo Original X 432g","galleta_oreo","rtrtr",6.30));
        productoGalletasList.add(new ProductoGeneral("Galleta Ritz Queso Six Pack","galleta_ritz","fvcff",2.50));
        productoGalletasList.add(new ProductoGeneral("Wafer Nik Vainilla Paquete 6un","galleta_nik","fgfgfds",1.90));
        productoGalletasList.add(new ProductoGeneral("Galleta Glacitas Paquete 6un","galletas_glasitas","yujhgjj",2.99));

        adapter3=new ProductoSnacksAdaptor(productoGalletasList);
        recyclerViewProductoGalletasList.setAdapter(adapter3);
    }
}