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
        productoGalletasList.add(new ProductoGeneral("Yogurt Gloria Fresa Botella 1Kg","yogurt_gloria","Es una cremosa y deliciosa bebida láctea con trozos de fruta. Es un buen alimento para niños y adultos porque contiene los nutrientes naturales de la leche.",9.50));
        productoGalletasList.add(new ProductoGeneral("Yogurt Griego Laive Botella 200gr","yogurt_griego","Con la perfecta combinación de cremosidad, textura y deliciosos sabores  40g de proteína en una botella. SIN azúcar añadida.",7.90));
        productoGalletasList.add(new ProductoGeneral("Yogurt Laive Fresa Botella 1Kg","yogurt_laive","Es el mejor yogurt para tomar en el día ya que contiene 1,000 millones de probioticos por cada vaso de 200gr, que ayudan a mejorar tu digestión, fortaceler tus defensas y absorber mejor los nutrientes.",5.50));
        productoGalletasList.add(new ProductoGeneral("Yogurt Bells Fresa Botella 1Kg","yogurt_bells","Tus defensas MÁS FUERTES que nunca, con 1000 millones de probióticos en una botella que ayudan a reforzar tus defensas y tu sistema inmunológico.",10.30));
        productoGalletasList.add(new ProductoGeneral("Yogurt Actibio Linaza Fresa Botella 1Kg","yogurt_actibio","Contiene calcio, proteínas y otros nutrientes importantes para la salud. El calcio es esencial para la salud de los huesos y los dientes, mientras que las proteínas son necesarias para la formación de músculos, tejidos y células del cuerpo.",7.60));
        productoGalletasList.add(new ProductoGeneral("Yogurt Sbelt Fresa Botella 1Kg","yogurt_sbelt","Yogurt Laive Sbelt con 0% azúcar añadida, 0% grasa, con probióticos y fibra. ¡Es el aliado perfecto que necesitas para verte y sentirte bien!.",9.90));
        productoGalletasList.add(new ProductoGeneral("Yogurt Yoleit Fresa Botella 1Kg","yogurt_yoleit","Yogurt bebible sabor natural con cultivos probioticos",7.50));
        productoGalletasList.add(new ProductoGeneral("Yogurt Piamonte Botella 946ml","yogurt_piamonte","Yogurt parcialmente descremado totalmente natural, sin azucar",15.40));
        productoGalletasList.add(new ProductoGeneral("Yogurt Milkito Fresa Botella 1Kg","yogurt_milkito","Yogurt parcialmente descremado elaborado con leche de vaca. Es una rica fuente de proteínas que ayuda a formar los músculos. Además, su aporte de calcio contribuye a mantener una buena salud ósea. Es perfecto para niños y adultos que quieren disfrutar de un yogurt cremoso y nutritivo.",10.70));
        productoGalletasList.add(new ProductoGeneral("Yogurt Slim Fresa Botella 1Kg","slim2","Este yogurt descremado edulcorado es un producto 0% grasas trans y sin azúcares añadidos. Con proteínas, vitaminas E, un potente antioxidante, y vitamina D. Está pensado para mujeres y hombres de 20 a 50 años de edad que quieran reducir el consumo de calorías, azúcares y grasas.",6.50));

        adapter3=new ProductoSnacksAdaptor(productoGalletasList);
        recyclerViewProductoGalletasList.setAdapter(adapter3);
    }
}