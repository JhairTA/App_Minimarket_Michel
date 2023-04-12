package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

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

        CategoryAdaptor adapter=new CategoryAdaptor(categoria);
        adapter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String posinom = categoria.get(recyclerViewCategoriaList.getChildAdapterPosition(view)).getTitle();
                Toast.makeText(getApplicationContext(), "Seleccion: " + posinom, Toast.LENGTH_SHORT).show();

                switch (posinom){
                    case "BEBIDAS":{
                        Intent intent = new Intent(getApplicationContext(), BebidasActivity.class);
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
        productoLechesList.add(new ProductoLeches("Leche Gloria Evapo. Lata 400g", "leche_gloria", "Esta combinación le da la cremosidad, consistencia y sabor que la hacen la leche favorita de los peruanos. Aporta nutrientes propios de la leche como proteínas de alta calidad, calcio y fósforo, que promueven el crecimiento, conservan la masa muscular y mantienen huesos y dientes. Además, está enriquecida con vitaminas A y D.", 3.99));
        productoLechesList.add(new ProductoLeches("Leche Pura Vida Lata 400g", "leche_puravida", "Es una mezcla láctea compuesta con aceite vegetal y maltodextrina, enriquecida con vitaminas (A y D) y minerales (hierro y zinc).\n" +
                                                        "Producto fortificado con hierro y zinc, nutrientes importantes que ayudan al control de la anemia unido a una alimentación balanceada y saludable.\n" +
                                                        "Fuente de vitaminas A, D y zinc", 3.70));
        productoLechesList.add(new ProductoLeches("Leche Ideal Amanecer Lata 400g", "leche_ideal", "Contiene Hierro, Zinc, Calcio y Vitaminas A, C y D; nutrientes claves que contribuyen a la buena nutrición de tu familia. Alimentos fortificados con Hierro y Vitamina C como Ideal Amanecer contribuyen a reducir el riesgo de deficiencia de Hierro en los niños, el cual puede causar anemia.", 3.80));
        productoLechesList.add(new ProductoLeches("Leche Bonlé Cremosa Lata 395g", "leche_bonle", "Es una mezcla láctea que gracias a su aporte de vitaminas: A y D, calcio y fósforo, contribuye al funcionamiento del sistema de defensas y al mantenimiento de los huesos. Está dirigida a toda la familia. Por su presentación en caja Tetrabrik con abre fácil, se adapta a cualquier momento y lugar.", 4.50));
        productoLechesList.add(new ProductoLeches("Leche UHT Bells Caja 1L", "leche_bells", "Producto líquido homogéneo de color blanco crema con olor y sabor a leche, a partir de leche cruda y/o concentrada, con posibilidad de agregar leche en polvo descremada, grasa anhidra láctea y/o agua según sea necesario para normalizarla hasta cumplir con los requisitos físico químicos del ingrediente leche entera.", 5.20));
        productoLechesList.add(new ProductoLeches("Leche Gloria Light Lata 400g", "leche_gloria_light", "Desarrollada especialmente con el delicioso sabor de siempre, pero con menos calorías y 50% menos grasa que una leche entera. Aporta nutrientes propios de la leche como proteínas de alta calidad, calcio y fósforo, que promueven el crecimiento, conservan la masa muscular y mantienen huesos y dientes. Además, está enriquecida con vitaminas A y D.", 4.99));
        productoLechesList.add(new ProductoLeches("Leche Laive Vitamin Caja 500g", "leche_laive", "Leche concentrada con 6.4% de grasa. Producto liquido homogéneo, de color blanco crema con olor y sabor característico de leche, con adición de vitaminas (A, C y D), además de aportar los nutrientes naturales de la leche. A partir de leche concentrada y leche recombinada o reconstituida", 5.50));
        productoLechesList.add(new ProductoLeches("Leche Bonlé Light Caja 500g", "leche_bonle_light", "Es una mezcla láctea especialmente para personas que requieren una dieta con menos grasa. Gracias a su aporte de vitaminas: A y D, calcio y fósforo, contribuye al fortalecimiento del sistema inmunológico y al mantenimiento de los huesos. Por su presentación en caja Tetrabrik con abre fácil, se adapta a cualquier momento y lugar.", 4.20));
        productoLechesList.add(new ProductoLeches("Leche Gloria Evapo. Lata 400g", "leche_gloria_morado", "Hecha con leche fluida de la mejor calidad, tiene una textura ligera y un delicioso sabor. Aporta nutrientes propios de la leche como proteínas de alta calidad, calcio y fósforo, que promueven el crecimiento, conservan la masa muscular y mantienen huesos y dientes. Además, está enriquecida con vitaminas A y D.", 3.60));
        productoLechesList.add(new ProductoLeches("Leche Laive Sin Lactosa Bolsa 900ml", "leche_laive_bolsa", "Elaborada con 100% leche de vaca.\n" +
                                                                                                                                "Fuente de calcio.\n" +
                                                                                                                                "Sin perservantes.\n" +
                                                                                                                                "¡Sin lactosa, Sin molestias!\n" +
                                                                                                                                "Disfruta nuevamente de los beneficios nutricionales de la leche sin sentir molestias, gracias a LAIVE SIN LACTOSA.", 4.70));

        adapter3=new ProductoLechesAdaptor(productoLechesList);
        recyclerViewProductoLechesList.setAdapter(adapter3);
    }
}