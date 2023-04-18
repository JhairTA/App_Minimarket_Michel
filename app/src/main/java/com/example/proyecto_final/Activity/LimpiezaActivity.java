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
        productoCuidadoRopaList.add(new ProductoGeneral("Detergente en Polvo Ace Floral 750gr", "cr_ace", "Detergente en polvo para lavar ropa blanca y de color.",12.90));
        productoCuidadoRopaList.add(new ProductoGeneral("Suavizante Downy Floral Galonera 2.8Lt", "cr_downy", "¡Ahora es más fácil comprar Suavizante DOWNY Aroma Floral",27.80));
        productoCuidadoRopaList.add(new ProductoGeneral("Vanish Tarro Rosa Quitamanchas 900gr", "cr_vanish", "Ahora Vanish quitamanchas trae cuatro beneficios: Remueve hasta las manchas más dificiles,  Previene la transferencia de color,Elimina los malos olores y Mata el 99.9% de bacterias de tus prendas. Dale más vida a tu ropa con Vanish.",49.20));
        productoCuidadoRopaList.add(new ProductoGeneral("Detergente Ariel Pro Cuidado X 2kg", "cr_ariel", "Detergente en polvo para la ropa blanca y de color.",34.80));
        productoCuidadoRopaList.add(new ProductoGeneral("Suavizante Suavitel Galonera 2.8L", "cr_suavitel", "Puedes elegir entre Almidones , los cuales son ideales para minimizar las arrugas, darle una apariencia más lisa y limpia.",23.80));
        productoCuidadoRopaList.add(new ProductoGeneral("Detergente Marsella Bolsa 4Kg", "cr_marsella", "Detergente ideal para todo tipo de ropa, blanca o de colores.",47.10));
        productoCuidadoRopaList.add(new ProductoGeneral("Quitamanchas Sapolio Ropa Color 3.785ml", "cr_sapolio", "Remueve manchas orgánicas sin alterar los colores, ejemplo: manchas de mostaza, jugos, café , pasto etc.",30.00));
        productoCuidadoRopaList.add(new ProductoGeneral("Opal Quitamanchas Polvo White 900gr", "cr_opalquitamanchas", "Quitamanchas en Polvo OPAL Perfect White Frasco 900g",24.90));
        productoCuidadoRopaList.add(new ProductoGeneral("Detergente Bolivar Active Care 9Kg", "cr_bolivar", "Este detergente puede ser utilizado para lavar prendas blancas o de color, ya que no maltrata las fibras, cuida los colores y deja tu ropa con delicado y suave aroma floral.",39.50));
        productoCuidadoRopaList.add(new ProductoGeneral("Detergente Opal Ultra Bolsa 9kg", "cr_opal", "",97.40));

        adapter2=new ProductoCuidadoRopaAdaptor(productoCuidadoRopaList);
        recyclerViewProductoCuidadoRopaList.setAdapter(adapter2);
    }

    private void recyclerViewProductoCuidadoHogar(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewProductocuidadoHogarList = findViewById(R.id.rv3);
        recyclerViewProductocuidadoHogarList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoCuidadoHogarList = new ArrayList<>();
        productoCuidadoHogarList.add(new ProductoGeneral("Cif Antigrasa Gatillo 500ml", "ch_cif", "Limpiador Líquido CIF Antigrasa Gatillo (500 ml.) Es un desengrasante líquido \n"+"\n",16.90));
        productoCuidadoHogarList.add(new ProductoGeneral("Limpiador Poett Lavanda Galón", "ch_poett", "Contiene agua, tensoactivos, fragancia, colorantes y coadyuvantes.\\n\" + \"Es ideal para limpiar fácilmente todas las superficies, ya sea diluido o aplicado directamente, llenando tu hogar de una fragancia deliciosa y duradera.",16.40));
        productoCuidadoHogarList.add(new ProductoGeneral("Lejía Desinfectante Clorox 4L", "ch_clorox", "- Elimina el 99,9% de bacterias\n"+"- Triple Acción: Limpia"+"\n"+"\n"+"\n",9.90));
        productoCuidadoHogarList.add(new ProductoGeneral("Jabon Líquido Aval Galon 5L", "ch_aval", "- Antibacterial\n" + "- Aroma mágica vainilla\n" + "- Con glicerina\n" + "- Envase de plástico PET cristal con asa\n" + "- Presentación: Galonera de 5 litros",52.30));
        productoCuidadoHogarList.add(new ProductoGeneral("Paño Absorbente Scotch Brite 20und", "ch_scotch", "- Absorbe hasta 20 veces su peso en agua\n" + "- No se deshace\n" + "- No raya superficies\n" + "- Fácil de limpiar y secar" + "\n",23.50));
        productoCuidadoHogarList.add(new ProductoGeneral("Ayudin Liquido Lima 1.2 Litros", "ch_ayudin", "Ayudín Líquido Lima Limón elimina grasa difícil y es suave en tus manos.\n" + " Solución y espuma suave al tacto. Rinde 100% más* Agradable aroma a lima- limón.",12.90));
        productoCuidadoHogarList.add(new ProductoGeneral("Limpiador Mr Músculo Naranja 500ml", "ch_mrmusculo", "Mr Músculo Cocina Naranja contiene una fórmula que disuelve la grasa de la cocina llegando a lugares difíciles de alcanzar para una limpieza minuciosa y profunda. \n" + "No más suciedad y grasa en las campanas extractoras, cocina a gas etc.",14.40));
        productoCuidadoHogarList.add(new ProductoGeneral("Lejia Boreal Limon Galonera 1.8L", "ch_boreal", "- Ideal para la limpieza y cuidado del hogar\n" + "- Resultados óptimos\n" + "- No almacenar con productos comestibles"+ "\n",4.79));
        productoCuidadoHogarList.add(new ProductoGeneral("Ambientador Spray Sapolio 360ml", "ch_sapolio", "Exquisita variedad de aromas naturales, transportándolos a los lugares más soñados. Un rocío de nuestras exquisitas fragancias ponen el toque mágico a las tareas de limpieza. Todos los ambientes quedan natural y deliciosamente perfumados por muchas horas.",6.90));
        productoCuidadoHogarList.add(new ProductoGeneral("Papel Higiénico Suave 4und", "ch_suave", "- Presentación : Paquete 40un\n" + "- Suavidad y máximo confort"+"\n"+"\n"+"\n",4.90));

        adapter3=new ProductoCuidadoHogarAdaptor(productoCuidadoHogarList);
        recyclerViewProductocuidadoHogarList.setAdapter(adapter3);
    }
}