package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.proyecto_final.Adaptor.CategoryAdaptor;
import com.example.proyecto_final.Adaptor.ProductoLechesAdaptor;
import com.example.proyecto_final.Adaptor.ProductoYogurtsAdaptor;
import com.example.proyecto_final.Domain.CategoryDomain;
import com.example.proyecto_final.Domain.ProductoLeches;
import com.example.proyecto_final.Domain.ProductoYogurts;
import com.example.proyecto_final.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar1;

    private RecyclerView.Adapter adapter, adapter2, adapter3;
    private RecyclerView recyclerViewCategoriaList, recyclerViewProductoYogurtsList, recyclerViewProductoLechesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar1 = findViewById(R.id.toolbar1);
        toolbar1.setTitle("Categoria");
        setSupportActionBar(toolbar1);

        recyclerViewCategoria();
        recyclerViewProductoYogurts();
        recyclerViewProductoLeches();
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

        adapter=new CategoryAdaptor(categoria);
        recyclerViewCategoriaList.setAdapter(adapter);
    }

    private void recyclerViewProductoYogurts(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewProductoYogurtsList = findViewById(R.id.rv2);
        recyclerViewProductoYogurtsList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoYogurts> productoYogurtsList = new ArrayList<>();
        productoYogurtsList.add(new ProductoYogurts("Yogurt Gloria Fresa Botella 1Kg","yogurt_gloria","Es una cremosa y deliciosa bebida láctea con trozos de fruta. Es un buen alimento para niños y adultos porque contiene los nutrientes naturales de la leche.",9.50));
        productoYogurtsList.add(new ProductoYogurts("Yogurt Griego Laive Botella 200gr","yogurt_griego","Con la perfecta combinación de cremosidad, textura y deliciosos sabores  40g de proteína en una botella. SIN azúcar añadida.",7.90));
        productoYogurtsList.add(new ProductoYogurts("Yogurt Laive Fresa Botella 1Kg","yogurt_laive","Es el mejor yogurt para tomar en el día ya que contiene 1,000 millones de probioticos por cada vaso de 200gr, que ayudan a mejorar tu digestión, fortaceler tus defensas y absorber mejor los nutrientes.",5.50));
        productoYogurtsList.add(new ProductoYogurts("Yogurt Bells Fresa Botella 1Kg","yogurt_bells","Tus defensas MÁS FUERTES que nunca, con 1000 millones de probióticos en una botella que ayudan a reforzar tus defensas y tu sistema inmunológico.",10.30));
        productoYogurtsList.add(new ProductoYogurts("Yogurt Actibio Linaza Fresa Botella 1Kg","yogurt_actibio","Contiene calcio, proteínas y otros nutrientes importantes para la salud. El calcio es esencial para la salud de los huesos y los dientes, mientras que las proteínas son necesarias para la formación de músculos, tejidos y células del cuerpo.",7.60));
        productoYogurtsList.add(new ProductoYogurts("Yogurt Sbelt Fresa Botella 1Kg","yogurt_sbelt","Yogurt Laive Sbelt con 0% azúcar añadida, 0% grasa, con probióticos y fibra. ¡Es el aliado perfecto que necesitas para verte y sentirte bien!.",9.90));
        productoYogurtsList.add(new ProductoYogurts("Yogurt Yoleit Fresa Botella 1Kg","yogurt_yoleit","Yogurt bebible sabor natural con cultivos probioticos",7.50));
        productoYogurtsList.add(new ProductoYogurts("Yogurt Piamonte Botella 946ml","yogurt_piamonte","Yogurt parcialmente descremado totalmente natural, sin azucar",15.40));
        productoYogurtsList.add(new ProductoYogurts("Yogurt Milkito Fresa Botella 1Kg","yogurt_milkito","Yogurt parcialmente descremado elaborado con leche de vaca. Es una rica fuente de proteínas que ayuda a formar los músculos. Además, su aporte de calcio contribuye a mantener una buena salud ósea. Es perfecto para niños y adultos que quieren disfrutar de un yogurt cremoso y nutritivo.",10.70));
        productoYogurtsList.add(new ProductoYogurts("Yogurt Slim Fresa Botella 1Kg","slim2","Este yogurt descremado edulcorado es un producto 0% grasas trans y sin azúcares añadidos. Con proteínas, vitaminas E, un potente antioxidante, y vitamina D. Está pensado para mujeres y hombres de 20 a 50 años de edad que quieran reducir el consumo de calorías, azúcares y grasas.",6.50));

        adapter2=new ProductoYogurtsAdaptor(productoYogurtsList);
        recyclerViewProductoYogurtsList.setAdapter(adapter2);
    }

    private void recyclerViewProductoLeches(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewProductoLechesList=findViewById(R.id.rv3);
        recyclerViewProductoLechesList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoLeches> productoLechesList=new ArrayList<>();
        productoLechesList.add(new ProductoLeches("Leche Gloria Evapo. Lata 400g", "leche_gloria", "fdf", 3.99));
        productoLechesList.add(new ProductoLeches("Leche Pura Vida Lata 400g", "leche_puravida", "fdf", 3.70));
        productoLechesList.add(new ProductoLeches("Leche Ideal Amanecer Lata 400g", "leche_ideal", "fdf", 3.80));
        productoLechesList.add(new ProductoLeches("Leche Bonlé Cremosa Lata 395g", "leche_bonle", "fdf", 4.50));
        productoLechesList.add(new ProductoLeches("Leche UHT Bells Caja 1L", "leche_bells", "fdf", 5.20));
        productoLechesList.add(new ProductoLeches("Leche Gloria Light Lata 400g", "leche_gloria_light", "fdf", 4.99));
        productoLechesList.add(new ProductoLeches("Leche Laive Vitamin Caja 500g", "leche_laive", "fdf", 5.50));
        productoLechesList.add(new ProductoLeches("Leche Bonlé Light Caja 500g", "leche_bonle_light", "fdf", 4.20));
        productoLechesList.add(new ProductoLeches("Leche Gloria Evapo. Lata 400g", "leche_gloria_morado", "fdf", 3.60));
        productoLechesList.add(new ProductoLeches("Leche Laive Sin Lactosa Bolsa 900ml", "leche_laive_bolsa", "fdf", 4.70));

        adapter3=new ProductoLechesAdaptor(productoLechesList);
        recyclerViewProductoLechesList.setAdapter(adapter3);
    }
}