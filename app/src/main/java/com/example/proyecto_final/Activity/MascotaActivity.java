package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final.Adaptor.CategoryAdaptor;
import com.example.proyecto_final.Adaptor.ProductoGatoAdaptor;
import com.example.proyecto_final.Adaptor.ProductoPerroAdaptor;
import com.example.proyecto_final.Domain.CategoryDomain;
import com.example.proyecto_final.Domain.ProductoGeneral;
import com.example.proyecto_final.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotaActivity extends AppCompatActivity {

    private Toolbar toolbar1;

    private RecyclerView.Adapter adapter, adapter2, adapter3;
    private RecyclerView recyclerViewCategoriaList, recyclerViewPerroList,recyclerViewGatoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota);

        toolbar1 = findViewById(R.id.toolbar1);
        toolbar1.setTitle("Categoria");
        setSupportActionBar(toolbar1);

        recyclerViewCategoria();
        recyclerViewProductoPerro();
        recyclerViewProductoGato();
    }

    public void buscar(View view){
        Intent intent =new Intent(this, BuscadorActivity.class);
        startActivity(intent);
    }

    public void inicio(View view){
        Intent intent =new Intent(this, InicioActivity.class);
        startActivity(intent);
    }

    public void carrito(View view){
        Intent intent =new Intent(this, CarritoActivity.class);
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
                    case "BEBIDAS":{
                        Intent intent = new Intent(getApplicationContext(), BebidasActivity.class);
                        startActivity(intent);
                        break;
                    }
                }


            }
        });
        recyclerViewCategoriaList.setAdapter(adapter);
    }

    private void recyclerViewProductoPerro(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPerroList = findViewById(R.id.rv2);
        recyclerViewPerroList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoPerroList = new ArrayList<>();
        productoPerroList.add(new ProductoGeneral("Comida para Perros Ricocan Bolsa 15kg", "p_ricocan", "Fibras Naturales: semillas de linaza con alto contenido de fibra soluble e insoluble. Omega 3 y 6: fuente de DHA,EPA y ácido linoleico. Minerales: calcio, hierro y fósforo. Minerales Orgánicos: zinc y cobre, enlazados a aminoácidos con mayor porcentaje de absorción.",74.90));
        productoPerroList.add(new ProductoGeneral("Comida para Perros Mimaskot Bolsa 15kg", "p_mimaskot", "La Comidaestá formulada con ingredientes naturales y de alta calidad, como carne fresca, pescado y frutas y verduras, lo que asegura una fuente rica de proteínas, vitaminas y minerales esenciales.\n",107.80));
        productoPerroList.add(new ProductoGeneral("Comida para Perros Bells Bolsa 25kg", "p_bells", "Los ingredientes utilizados en la Comida incluyen proteínas de alta calidad como carne y pollo, así como cereales, verduras y frutas para proporcionar una nutrición equilibrada y completa",95.60));
        productoPerroList.add(new ProductoGeneral("Comida para Perros Dog Chow Bolsa 100g", "p_dogchow", "La Comida está formulada con ingredientes de alta calidad, como proteína de pollo, que proporcionan una nutrición completa\n" + "Este paquete de 100 gramos es ideal para perros de raza pequeña o como complemento a la alimentación regular de perros más grandes",4.30));
        productoPerroList.add(new ProductoGeneral("Comida para Perros Nutrican Bolsa 25kg", "p_nutrican", "La Comida  está formulada con ingredientes de alta calidad, incluyendo proteínas de pollo y cordero, que proporcionan una fuente rica y saludable de proteínas para ayudar a mantener una buena masa muscular y un sistema inmunológico fuerte.",129.20));
        productoPerroList.add(new ProductoGeneral("Comida para Perros Pedigree Bolsa 100g", "p_pedrigree", "La Comida  está formulada con ingredientes de alta calidad, como carne y pollo, que proporcionan una nutrición completa y equilibrada para perros de todas las edades y tamaños.",4.10));
        productoPerroList.add(new ProductoGeneral("Comida para Perros Pet Care Bolsa 95g", "p_petcare", "Este paquete de 95 gramos es ideal para perros de raza pequeña o como complemento a la alimentación regular de perros más grandes",3.00));
        productoPerroList.add(new ProductoGeneral("Pro Plan Puppy Complete Bolsa 20kg", "p_proplan", "Está hecho con una combinación de ingredientes de alta calidad, como pollo fresco, arroz y maíz, que proporcionan una fuente de proteína, carbohidratos y nutrientes esenciales \n",113.90));
        productoPerroList.add(new ProductoGeneral("Comida para Perros Purina One Bolsa 6kg", "p_purinaone", "Esta fórmula está hecha con ingredientes de alta calidad, como carne de pollo real y arroz, que proporcionan una fuente rica y saludable de proteínas y carbohidratos para su perro.",38.60));
        productoPerroList.add(new ProductoGeneral("Snacks para Perros Gnawlers Bolsa 8un", "p_gnawlers", "Cada unidad está hecha con ingredientes de alta calidad, incluyendo proteína de pollo y de res, y no contiene colorantes ni conservantes artificiales.\n",10.90));

        adapter2 = new ProductoPerroAdaptor(productoPerroList);
        recyclerViewPerroList.setAdapter(adapter2);
    }

    private void recyclerViewProductoGato(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewGatoList = findViewById(R.id.rv3);
        recyclerViewGatoList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoGatoList = new ArrayList<>();
        productoGatoList.add(new ProductoGeneral("Comida para Gatos Ricocat Bolsa 9Kg", "cg_ricocat", "fdsf",94.50));
        productoGatoList.add(new ProductoGeneral("Comida para Gatos Bells Bolsa 1Kg", "cg_bells", "fdsf",9.90));
        productoGatoList.add(new ProductoGeneral("Comida para Gatos Purina One Bolsa 2Kg", "cg_purinaone", "fdsf",7.10));
        productoGatoList.add(new ProductoGeneral("Comida para Gatos Mimaskot Bolsa 9Kg", "cg_mimaskot", "fdsf",85.50));
        productoGatoList.add(new ProductoGeneral("Comida para Gatos Whiskas Bolsa 9Kg", "cg_whiskas", "fdsf",131.20));
        productoGatoList.add(new ProductoGeneral("Comida para Gatos Cat Chow Bolsa 8Kg", "cg_catchow", "fdsf",114.90));
        productoGatoList.add(new ProductoGeneral("Comida para Gatos Sheba Sobre 85g", "cg_sheba", "fdsf",4.20));
        productoGatoList.add(new ProductoGeneral("Comida para Gatos Felix Pouch x 85Gr", "cg_felix", "fdsf",3.50));
        productoGatoList.add(new ProductoGeneral("Comida para Gatos Fancy Feast Lata 85g", "cg_fancyfeast", "fdsf",6.40));
        productoGatoList.add(new ProductoGeneral("Arena para Gatos Cool Cat Bolsa 10Kg", "cg_coolcat", "fdsf",29.50));

        adapter3 = new ProductoGatoAdaptor(productoGatoList);
        recyclerViewGatoList.setAdapter(adapter3);
    }
}