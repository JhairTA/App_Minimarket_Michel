package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final.Adaptor.CategoryAdaptor;
import com.example.proyecto_final.Adaptor.ProductoCuidadoHogarAdaptor;
import com.example.proyecto_final.Adaptor.ProductoCuidadoRopaAdaptor;
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

public class LimpiezaActivity extends AppCompatActivity {

    private Toolbar toolbar1;

    private RecyclerView.Adapter adapter, adapter2, adapter3;
    private RecyclerView recyclerViewCategoriaList,recyclerViewProductoCuidadoRopaList, recyclerViewProductocuidadoHogarList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limpieza);

        toolbar1 = findViewById(R.id.toolbar1);
        toolbar1.setTitle("Categoria");
        setSupportActionBar(toolbar1);

        recyclerViewCategoria();
        recyclerViewProductoCuidadoRopa();
        recyclerViewProductoCuidadoHogar();
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
                    case "BEBIDAS":{
                        Intent intent = new Intent(getApplicationContext(), BebidasActivity.class);
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

    private void recyclerViewProductoCuidadoRopa(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewProductoCuidadoRopaList = findViewById(R.id.rv2);
        recyclerViewProductoCuidadoRopaList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoCuidadoRopaList = new ArrayList<>();
        productoCuidadoRopaList.add(new ProductoGeneral("Detergente en Polvo Ace Floral 750gr", "cr_ace", "fdsf",12.90));
        productoCuidadoRopaList.add(new ProductoGeneral("Suavizante Downy Floral Galonera 2.8Lt", "cr_downy", "fdsf",27.80));
        productoCuidadoRopaList.add(new ProductoGeneral("Vanish Tarro Rosa Quitamanchas 900gr", "cr_vanish", "fdsf",49.20));
        productoCuidadoRopaList.add(new ProductoGeneral("Detergente Ariel Pro Cuidado X 2kg", "cr_ariel", "fdsf",34.80));
        productoCuidadoRopaList.add(new ProductoGeneral("Suavizante Suavitel Galonera 2.8L", "cr_suavitel", "fdsf",23.80));
        productoCuidadoRopaList.add(new ProductoGeneral("Detergente Marsella Bolsa 4Kg", "cr_marsella", "fdsf",47.10));
        productoCuidadoRopaList.add(new ProductoGeneral("Quitamanchas Sapolio Ropa Color 3.785ml", "cr_sapolio", "fdsf",30.00));
        productoCuidadoRopaList.add(new ProductoGeneral("Opal Quitamanchas Polvo White 900gr", "cr_opalquitamanchas", "fdsf",24.90));
        productoCuidadoRopaList.add(new ProductoGeneral("Detergente Bolivar Active Care 9Kg", "cr_bolivar", "fdsf",39.50));
        productoCuidadoRopaList.add(new ProductoGeneral("Detergente Opal Ultra Bolsa 9kg", "cr_opal", "fdsf",97.40));

        adapter2=new ProductoCuidadoRopaAdaptor(productoCuidadoRopaList);
        recyclerViewProductoCuidadoRopaList.setAdapter(adapter2);
    }

    private void recyclerViewProductoCuidadoHogar(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewProductocuidadoHogarList = findViewById(R.id.rv3);
        recyclerViewProductocuidadoHogarList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoCuidadoHogarList = new ArrayList<>();
        productoCuidadoHogarList.add(new ProductoGeneral("Cif Antigrasa Gatillo 500ml", "ch_cif", "fdsf",16.90));
        productoCuidadoHogarList.add(new ProductoGeneral("Limpiador Poett Lavanda Galón", "ch_poett", "fdsf",16.40));
        productoCuidadoHogarList.add(new ProductoGeneral("Lejía Desinfectante Clorox 4L", "ch_clorox", "fdsf",9.90));
        productoCuidadoHogarList.add(new ProductoGeneral("Jabon Líquido Aval Galon 5L", "ch_aval", "fdsf",52.30));
        productoCuidadoHogarList.add(new ProductoGeneral("Paño Absorbente Scotch Brite 20und", "ch_scotch", "fdsf",23.50));
        productoCuidadoHogarList.add(new ProductoGeneral("Ayudin Liquido Lima 1.2 Litros", "ch_ayudin", "fdsf",12.90));
        productoCuidadoHogarList.add(new ProductoGeneral("Limpiador Mr Músculo Naranja 500ml", "ch_mrmusculo", "fdsf",14.40));
        productoCuidadoHogarList.add(new ProductoGeneral("Lejia Boreal Limon Galonera 1.8L", "ch_boreal", "fdsf",4.79));
        productoCuidadoHogarList.add(new ProductoGeneral("Ambientador Spray Sapolio 360ml", "ch_sapolio", "fdsf",6.90));
        productoCuidadoHogarList.add(new ProductoGeneral("Papel Higiénico Suave 4und", "ch_suave", "fdsf",4.90));

        adapter3=new ProductoCuidadoHogarAdaptor(productoCuidadoHogarList);
        recyclerViewProductocuidadoHogarList.setAdapter(adapter3);
    }
}