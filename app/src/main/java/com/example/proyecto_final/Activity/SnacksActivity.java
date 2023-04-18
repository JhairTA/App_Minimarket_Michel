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
                Toast.makeText(getApplicationContext(), "Seccion: " + posinom, Toast.LENGTH_SHORT).show();

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
        productoSnacksList.add(new ProductoGeneral("Papas Lays Clasicas Bolsa 40g","snack_lays","Todo empieza con papas de campo, que se cocinan y condimentan a la perfección para que cada LAY'S® tenga una crocantes insuperable y rebose del sabor a papa fresca. Happiness in Every Bite.",2.20));
        productoSnacksList.add(new ProductoGeneral("Piqueo Snax Bolsa 200g","snack_piqueosnax","Original con lays, doritos, cheese tris y tocino. Mezcla de tortillas fritas de maíz con sabor a queso, hojuelas de papas fritas con sal, palitos de maíz con sabor a queso mantequilla y pellets de trigo con sabores a chicharrón y tocino",8.90));
        productoSnacksList.add(new ProductoGeneral("Doritos Queso Atrevido Bolsa 210g","snack_doritos","Maíz, Aceite vegetal, Maltodextrina, Queso, Sal, Azúcar, Glutamato monosódico l- (acentuador del sabor), Cebolla, Saborizante artificial a queso, Sólidos de leche, Ajo, Especias, ácido cítrico (regulador de acidez), Aceite vegetal (soya)",5.50));
        productoSnacksList.add(new ProductoGeneral("Cheese Tris Queso Bolsa 140g","snack_cheesetris","Cheese Tris son unos deliciosos extruidos de maíz con sabor a queso. \n"+ "Ingredientes: cereal de maíz, oleína de palma, mezcla para saborizar a queso (maltodextrina, suero de queso en polvo, aceite vegetal parcialmente hidrogenado, sal yodada, sabor natural a queso",2.50));
        productoSnacksList.add(new ProductoGeneral("Papas Fritas Inka Chips Bolsa 33g","snack_inkachips","Déjate conquistar por el sabor de nuestras papas crujientes sabor Jalapeño, sabrosas y ardientes hasta la última hojuela. Acompáñalas con tu bebida preferida y relájate hasta que las termines todas.",2.20));
        productoSnacksList.add(new ProductoGeneral("Cheetos Queso Picante Bolsa 69g","snack_cheetos","Un sabor picante y especiado en un bocadillo crocante y con queso. Los CHEETOS® FLAMIN’ HOT® crocantes, bocadillos sabor a queso, están llenos de sabor y hechos con queso de verdad.",1.70));
        productoSnacksList.add(new ProductoGeneral("Tor-Tees Clasico Bolsa 60g","snack_tortees","Disfruta de un delicioso y crocante snack. Ideal para disfrutar en cualquier momento del día y compartir con los que más quieres. \n" + "\n" + "\n" ,3.20));
        productoSnacksList.add(new ProductoGeneral("Pringles Cebolla Grande 124gr","snack_pringles","El increible sabor de cream y cebolla cominado no puede medirse con la ciencia actual. Hemos decidio que es una combinación de sabores creado por la propia naturaleza y perfeccionado por el hombre. No cuestionamos esta combinación tan perfecta.",10.30));
        productoSnacksList.add(new ProductoGeneral("Lays Tostitos Original Bolsa 200g","snack_tostitos","Lleva la experiencia del restaurante a casa con TOSTITOS® ; Chips de tortilla originales estilo restaurante. Estas papas fritas clásicas combinan muy bien con salsas o nachos. Son perfectos para reuniones y reunir a la familia alrededor de la mesa.",8.10));
        productoSnacksList.add(new ProductoGeneral("Frito Lay Chizitos Bolsa 35gr","snack_chizitos","Chizitos Sabor a Queso en formato bolsa de 190g es un snack elaborado a partir de extruido de maíz con sabor a queso.\n"+ "\n" + "\n" +"\n" + "\n",1.50));

        adapter2=new ProductoSnacksAdaptor(productoSnacksList);
        recyclerViewProductoSnackList.setAdapter(adapter2);
    }

    private void recyclerViewProductoGalletas(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewProductoGalletasList = findViewById(R.id.rv3);
        recyclerViewProductoGalletasList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoGalletasList = new ArrayList<>();
        productoGalletasList.add(new ProductoGeneral("Galleta Casino Black Canela X 261g","galleta_casino","Victoria nos trae su Casino de siempre ahora con el placentero sabor. Las Galletas rectangulares re-llenas\n" + "con harta crema sabor que encantará a niños, jóvenes y adultos. Lo puedes buscar también en sus\n" + "sabores de fresa, chocolate, menta, vainilla, coco y alfajor. 51 g",3.50));
        productoGalletasList.add(new ProductoGeneral("Galleta Picaras Chocolate 6un","galletas_picaras","Galletas Pícaras - Pack de 6 x 40g\n" + "Descripción: galletas bañadas con cobertura sabor a chocolate \n" + "Contiene 6 paquetes de galletas\n" + "Contenido neto 240 g / 06 unidades\n" + "Marca: Pícaras\n" + "Origen: producto peruano",6.30));
        productoGalletasList.add(new ProductoGeneral("Galleta Morochas Paquete 6un","galleta_morochas","Galletas Morochas - Pack 12 x 30 g\n" + "Descripción: galletas sabor a vainilla bañadas con pasta de sabor a chocolate \n" + "Contiene 12 paquetes (unidades) de galletas\n" + "Ingredientes: galleta sabor a vainilla y pasta sabor chocolate. Puede contener maní y nueces de árbol.",4.80));
        productoGalletasList.add(new ProductoGeneral("Galleta Tentación Naranja Paquete 6un","galleta_tentacion","Son las galletas más ricas y crocantes, ideales para hacer\n" + "un \"break\" a tu día y darte un gustito. Vienen en cuatro\n" + "deliciosos sabores: chocolate, naranja, coco y vainilla.\n" + "Tentación...¡Tu Momento!",5.20));
        productoGalletasList.add(new ProductoGeneral("Galleta Chomp Chocolate Paquete 6un","galleta_chomp","Galletas Chomp Chocolate - Pack 6 x 46g\n" + "Descripción: Galletas Chomp sabor Chocolate\n" + "Peso Neto: 228 g \n" + "Contiene 6 unidades sueltas\n" + "Marca: Chomp (Victoria) \n" + "Origen: producto peruano",4.10));
        productoGalletasList.add(new ProductoGeneral("Galleta Margarita Sayon Paquete 6un","galleta_margarita","Galletas Margarita Sayon - Pack 6 x 46g \n" + "¡El sabor de ayer, hoy y siempre!\n" + "Descripción: galletas dulces\n" + "Contiene 06 paquetes de galletas\n" + "Contenido neto 279 g\n" + "Marca: Margarita - Sayon",2.70));
        productoGalletasList.add(new ProductoGeneral("Galleta Oreo Original X 432g","galleta_oreo","• Harina refinada con azúcares y grasa añadidos.\n" + "• Más de cuatro cucharadas cafeteras de azúcar por paquete.\n"+ "• Contiene jarabe de maíz de alta fructosa (endulzante no recomendable).\n" + "• Casi el 40% del producto son azúcares.",6.30));
        productoGalletasList.add(new ProductoGeneral("Galleta Ritz Queso Six Pack","galleta_ritz","Galletas Saladas Rellenas con Crema de Queso. Ritz de 34 g por 6 unidades.\n" + "\n" + "Ingredientes: Harina de trigo, Hierro, Niacina, Zinc, Tiamina, Riboflavina, ácido fólico, Manteca vegetal, Aceite vegetal, Suero de leche, Maltodextrina, Sabor artificial a queso, Sal",2.50));
        productoGalletasList.add(new ProductoGeneral("Wafer Nik Vainilla Paquete 6un","galleta_nik","Harina de trigo fortificada según DS 012-2006-SA, azúcar, grasa vegetal, almidón de maíz, permeato de suero en polvo, aceite vegetal, emulsionante (lecitina de soya), sal, leudantes (bicarbonato de sodio, bicarbonato de amonio), aromas artificiales, colorantes (tartrazina, rojo allura AC).",1.90));
        productoGalletasList.add(new ProductoGeneral("Galleta Glacitas Paquete 6un","galletas_glasitas","Características principales:\n" + "Contiene 6 paquetes de 32 gramos cada uno\n" + "Galleta con cobertura\n" + "Sabor: Fresa" + "\n" + "\n" +"\n" + "\n",2.99));

        adapter3=new ProductoSnacksAdaptor(productoGalletasList);
        recyclerViewProductoGalletasList.setAdapter(adapter3);
    }
}