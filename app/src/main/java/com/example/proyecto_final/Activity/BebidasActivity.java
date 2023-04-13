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
        productoAguasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoAguasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoAguasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoAguasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoAguasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoAguasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoAguasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoAguasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoAguasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoAguasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));

        adapter2 = new ProductoAguasAdaptor(productoAguasList);
        recyclerViewAguaList.setAdapter(adapter2);
    }

    private void recyclerViewProductoGasesosas(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewGaseosaList = findViewById(R.id.rv3);
        recyclerViewGaseosaList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoGaseosasList = new ArrayList<>();
        productoGaseosasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoGaseosasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoGaseosasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoGaseosasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoGaseosasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoGaseosasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoGaseosasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoGaseosasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoGaseosasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoGaseosasList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));

        adapter3 = new ProductoGaseosasAdaptor(productoGaseosasList);
        recyclerViewGaseosaList.setAdapter(adapter3);
    }

    private void recyclerViewProductoJugos(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewJugoList = findViewById(R.id.rv4);
        recyclerViewJugoList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoJugosList = new ArrayList<>();
        productoJugosList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoJugosList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoJugosList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoJugosList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoJugosList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoJugosList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoJugosList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoJugosList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoJugosList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));
        productoJugosList.add(new ProductoGeneral("dfdf", "yogurt_gloria", "fdsf",5.60));

        adapter4 = new ProductoJugosAdaptor(productoJugosList);
        recyclerViewJugoList.setAdapter(adapter4);
    }
}