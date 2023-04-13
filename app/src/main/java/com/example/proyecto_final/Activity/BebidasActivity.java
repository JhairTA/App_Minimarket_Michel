package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final.Adaptor.CategoryAdaptor;
import com.example.proyecto_final.Adaptor.ProductoAguasAdaptor;
import com.example.proyecto_final.Adaptor.ProductoGaseosasAdaptor;
import com.example.proyecto_final.Adaptor.ProductoJugosAdaptor;
import com.example.proyecto_final.Domain.CategoryDomain;
import com.example.proyecto_final.Domain.ProductoGeneral;
import com.example.proyecto_final.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BebidasActivity extends AppCompatActivity {

    private Toolbar toolbar1;

    private RecyclerView.Adapter adapter, adapter2, adapter3, adapter4;

    private RecyclerView recyclerViewCategoriaList, recyclerViewAguaList, recyclerViewGaseosaList,recyclerViewJugoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        toolbar1 = findViewById(R.id.toolbar1);
        toolbar1.setTitle("Categoria");
        setSupportActionBar(toolbar1);

        recyclerViewCategoria();
        recyclerViewProductoAguas();
        recyclerViewProductoGasesosas();
        recyclerViewProductoJugos();
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

    private void recyclerViewProductoAguas(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewAguaList = findViewById(R.id.rv2);
        recyclerViewAguaList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoAguasList = new ArrayList<>();
        productoAguasList.add(new ProductoGeneral("Agua Cielo Botella 600ml", "agua_cielo", "fdsf",1.50));
        productoAguasList.add(new ProductoGeneral("Agua San Luis Botella 625ml", "agua_sanluis", "fdsf",1.30));
        productoAguasList.add(new ProductoGeneral("Agua San Carlos Botella 500ml", "agua_sancarlos", "fdsf",3.70));
        productoAguasList.add(new ProductoGeneral("Agua Loa Botella 625ml", "agua_loa", "fdsf",1.20));
        productoAguasList.add(new ProductoGeneral("Agua San Mateo Botella 600ml", "agua_sanmateo", "fdsf",1.50));
        productoAguasList.add(new ProductoGeneral("Agua Socosani Botella 500ml", "agua_socosani", "fdsf",6.40));
        productoAguasList.add(new ProductoGeneral("Agua Pura Vida Botella 635ml", "agua_puravida", "fdsf",1.20));
        productoAguasList.add(new ProductoGeneral("Agua Bells Sin Gas Botella 2.5L", "agua_bells", "fdsf",2.29));
        productoAguasList.add(new ProductoGeneral("Agua Benedictino Botella 600ml", "agua_benedictino", "fdsf",4.99));
        productoAguasList.add(new ProductoGeneral("Agua San Luis Bidón 7L", "agua_sanluisbidon", "fdsf",22.50));

        adapter2 = new ProductoAguasAdaptor(productoAguasList);
        recyclerViewAguaList.setAdapter(adapter2);
    }

    private void recyclerViewProductoGasesosas(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewGaseosaList = findViewById(R.id.rv3);
        recyclerViewGaseosaList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoGaseosasList = new ArrayList<>();
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Inca Kola Botella 500ml", "gaseosa_incakola", "fdsf",1.70));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Coca Cola Botella 600ml", "gaseosa_cocacola", "fdsf",2.60));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Fanta Naranja Botella 500ml", "gaseosa_fanta", "fdsf",2.50));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Sprite Botella 500ml", "gaseosa_sprite", "fdsf",2.30));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Pepsi Botella 500ml", "gaseosa_pepsi", "fdsf",2.20));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Guarana Botella 450ml", "gaseosa_guarana", "fdsf",2.10));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Viva Backus Botella 450ml", "gaseosa_viva", "fdsf",1.20));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Concordia Botella 500ml", "gaseosa_concordia", "fdsf",2.70));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa 7UP Botella 355ml", "gaseosa_7up", "fdsf",1.20));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Crush Botella 450ml", "gaseosa_crush", "fdsf",1.90));

        adapter3 = new ProductoGaseosasAdaptor(productoGaseosasList);
        recyclerViewGaseosaList.setAdapter(adapter3);
    }

    private void recyclerViewProductoJugos(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewJugoList = findViewById(R.id.rv4);
        recyclerViewJugoList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoJugosList = new ArrayList<>();
        productoJugosList.add(new ProductoGeneral("Frugos Durazno Caja 235ml", "jugo_frugos", "fdsf",3.50));
        productoJugosList.add(new ProductoGeneral("Bebida Gloria Naranja Caja 1L", "jugo_gloria", "fdsf",3.90));
        productoJugosList.add(new ProductoGeneral("Chica Morada Naturale Botella 500ml", "jugo_naturale", "fdsf",4.50));
        productoJugosList.add(new ProductoGeneral("Tampico Citrus Punch Botella 600ml", "jugo_tampico", "fdsf",3.50));
        productoJugosList.add(new ProductoGeneral("Bio Amayu Arandano Botella 300ml", "jugo_bioamayu", "fdsf",3.50));
        productoJugosList.add(new ProductoGeneral("Refresco Clight Sobre Doble 14g", "jugo_clight", "fdsf",2.09));
        productoJugosList.add(new ProductoGeneral("Cifrut Citrus Punch Botella 350ml", "jugo_cifrut", "fdsf",2.20));
        productoJugosList.add(new ProductoGeneral("Refresco Instantaneo Zuko Sobre 15g", "jugo_zuko", "fdsf",1.20));
        productoJugosList.add(new ProductoGeneral("Umsha Chica Morada Bolsa 13g", "jugo_umsha", "fdsf",1.10));
        productoJugosList.add(new ProductoGeneral("Bebida Frutaris Botella 500ml", "jugo_frutaris", "fdsf",1.50));

        adapter4 = new ProductoJugosAdaptor(productoJugosList);
        recyclerViewJugoList.setAdapter(adapter4);
    }
}