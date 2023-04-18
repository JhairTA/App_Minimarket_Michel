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
        productoAguasList.add(new ProductoGeneral("Agua Cielo Botella 600ml", "agua_cielo", "CIELO es la marca de agua que te acompaña en cada una de tus actividades diarias, guiándote hacia el estilo de vida que deseas, aportando una sensación de bienestar interior y haciéndote sentir parte de un universo de belleza y sensualidad.",1.50));
        productoAguasList.add(new ProductoGeneral("Agua San Luis Botella 625ml", "agua_sanluis", "Descubre todas nuestras presentaciones como bidones de agua mineral y agua mineral en caja. Recuerda mantenerte siempre hidratado ya que el agua regula tu grasa mala y toxinas. Esto te ayuda a conservar tu peso ideal y una piel tersa naturalmente",1.30));
        productoAguasList.add(new ProductoGeneral("Agua San Carlos Botella 500ml", "agua_sancarlos", "¡Ahora es más fácil comprar Agua SAN CARLOS sin Gas Botella 500ml!" + "\n"+ "\n"+ "\n",3.70));
        productoAguasList.add(new ProductoGeneral("Agua Loa Botella 625ml", "agua_loa", "Agua extraída de yacimientos subterráneos, elimina toxinas y ayuda a fortalecer el sistema inmunológico, es tratada bajo altos estándares de calidad. Agua ligera, con el mejor sabor y ph alcalino que ayuda al correcto funcionamiento del cuerpo",1.20));
        productoAguasList.add(new ProductoGeneral("Agua San Mateo Botella 600ml", "agua_sanmateo", "El agua mineral San Mateo tiene origen de manantial y contiene minerales buenos para tu cuerpo. Mantente siempre hidratado. Encuéntrala Con Gas o Sin Gas en sus presentaciones de 600ml, 1.5 litros y 2 litros.",1.50));
        productoAguasList.add(new ProductoGeneral("Agua Socosani Botella 500ml", "agua_socosani", "Socosani está clasificada como agua mineral natural. Esto significa que tiene efectos fisiológicos beneficiosos para la salud, tiene una composición química constante, su pureza es original y es de origen subterráneo.",6.40));
        productoAguasList.add(new ProductoGeneral("Agua Pura Vida Botella 635ml", "agua_puravida", "Agua tratada y ozonizada. Está dirigida a toda la familia y puede consumirse en cualquier momento del día. El agua favorece la hidratación, facilita el transporte de nutrientes y oxígeno, y regula la temperatura, entre otros muchos beneficios",1.20));
        productoAguasList.add(new ProductoGeneral("Agua Bells Sin Gas Botella 2.5L", "agua_bells", "Caracteristicas: \n" + "Agua Mineral\n"+ "\n" + "Presentación : Botella de 2.5 Litros"+ "\n"+ "\n",2.29));
        productoAguasList.add(new ProductoGeneral("Agua Benedictino Botella 600ml", "agua_benedictino", " Considerada una de las aguas más puras del mundo, gracias su riguroso proceso productivo, Benedictino se caracteriza por ser un agua purificada en su máximo estado. ** Es decir, es sometida a diferentes e innumerables procesos de purificación, que como resultado logra un agua libre de sodio y de cualquier agente externo.",4.99));
        productoAguasList.add(new ProductoGeneral("Agua San Luis Bidón 7L", "agua_sanluisbidon", "Para jovenes adultos que buscan el balance perfecto entre vitalidad y bienestar.\n" + "La frescura y pureza de san luis permite a sus consumidores encontrar el equilibrio que el cuerpo y ala mente necesitan, mejorando las experiencias de la vida diaria, porque su alta pureza no solo pureza no solo brnda un fresco sabor si no que ayuda a sentirse bien dia a dia.",22.50));

        adapter2 = new ProductoAguasAdaptor(productoAguasList);
        recyclerViewAguaList.setAdapter(adapter2);
    }

    private void recyclerViewProductoGasesosas(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewGaseosaList = findViewById(R.id.rv3);
        recyclerViewGaseosaList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoGaseosasList = new ArrayList<>();
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Inca Kola Botella 500ml", "gaseosa_incakola", "Denominación: Bebida clasificada.\n" + "\n" + "Ingredientes: Agua Carbonatada, azúcar, regulador de la acidez (sin 330), SUSTANCIA CONSERVADORA (SIN 211), CAFEÍNA, SABORIZANTES Y COLORANTE (SIN 102). CONTIENE: TARTRAZINA.",1.70));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Coca Cola Botella 600ml", "gaseosa_cocacola", "Bebida gaseosa y refrescante. El refresco más popular de la historia. Sabor original. Contiene cafeína.\n" + "Valor Energético: 84 kcal = 353 kJ y 4\n" + "Carbohidratos: 22 g\n" + "Grasas Totales: 0 g\n" + "Sodio: 8 mg",2.60));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Fanta Naranja Botella 500ml", "gaseosa_fanta", "Fanta es una bebida carbonatada sabor naranja que intensifica la diversión con amigos a través de su sabor superior, frutal e intenso, una bebida refrescante con un 8% de zumo de naranja",2.50));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Sprite Botella 500ml", "gaseosa_sprite", "Sprite ofrece hidratación baja en sodio y una personalidad divertida, honesta e irreverente. Sabor: Lima-Limón. Ingredientes: Agua carbonatada, azúcares, concentrado Sprite, benzoato de sodio y estevia (1,4 mg/ 100 g).",2.30));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Pepsi Botella 500ml", "gaseosa_pepsi", "Es una gaseosa inspiradora, que llama al cambio y a salirse de lo convencional. \n" + "Agua carbonatada, azúcar, colorante: E-150d, acidulante: E-338, aromas (contiene cafeína), edulcorantes: acesulfamo K y sucralosa.\n" + "No contiene alérgenos de obligada declaración.",2.20));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Guarana Botella 450ml", "gaseosa_guarana", "La clásica Guaraná de Backus, con una refrescancia única que te invita a ver el mundo de una manera original. Prueba las nuevas variedades inspiradas en el sabor natural: Guaraná Camu Camu y Guaraná Copoazú. Encuéntrala en sus presentaciones de 450ml, 2 litros y 3 litros.",2.10));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Viva Backus Botella 450ml", "gaseosa_viva", "Jóvenes que buscan divertirse sin complicaciones, solo Viva Backus hace que tus momentos de diversión duren más y el disfrute sea mayor gracias a su rico sabor. Además tiene menos gas y empalaga menos. ¡Es una gaseosa Libre de Octógonos!",1.20));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Concordia Botella 500ml", "gaseosa_concordia", "Concordia es una bebida carbonatada sabor naranja que intensifica la diversión con amigos a través de su sabor superior, frutal e intenso, una bebida refrescante con un 8% de zumo de naranja",2.70));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa 7UP Botella 355ml", "gaseosa_7up", "Si te gusta disfrutar de la vida de una manera descomplicada, esta gaseosa es para ti. 7up es una bebida transparente que al probarla lleva a una experiencia refrescante con su sabor a lima-limón. 7up también se encuentra en versión light.",1.20));
        productoGaseosasList.add(new ProductoGeneral("Gaseosa Crush Botella 450ml", "gaseosa_crush", "Bebida sin alcohol dietética gasificada con sabor a guaraná. \n" + "Para los jóvenes y jóvenes adultos que tienen una personalidad más atrevida. Crush es la gaseosa que te da un golpe de sabor para que te atrevas a pasar por experiencias diferentes.",1.90));

        adapter3 = new ProductoGaseosasAdaptor(productoGaseosasList);
        recyclerViewGaseosaList.setAdapter(adapter3);
    }

    private void recyclerViewProductoJugos(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewJugoList = findViewById(R.id.rv4);
        recyclerViewJugoList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoJugosList = new ArrayList<>();
        productoJugosList.add(new ProductoGeneral("Frugos Durazno Caja 235ml", "jugo_frugos", "Frugos es un néctar constituido por el jugo y la pulpa de la fruta finamente dividida y tamizada adicionada de agua, azúcar y sometido a un proceso que asegura su conservación, de modo que no utiliza preservantes.",3.50));
        productoJugosList.add(new ProductoGeneral("Bebida Gloria Naranja Caja 1L", "jugo_gloria", "Es un producto obtenido mediante la dilución con agua tratada del jugo concentrado de naranja, con adición de azúcar blanco, fortificado con hierro, zinc y vitaminas B6, B12, ácido fólico y C; además contiene aditivos autorizados.  Es ideal para ser consumido en cualquier momento del día.",3.90));
        productoJugosList.add(new ProductoGeneral("Chica Morada Naturale Botella 500ml", "jugo_naturale", "La Chicha Morada es la bebida no gasificada. Nuestra chicha morada lista para tomar NATURALE está hecha a base de pura fruta, sin ningún tipo de saborizante y respetando todos los ingredientes de la receta tradicional: Maíz morado, Membrillo, Piña, Manzana, Canela y Clavo de olor.",4.50));
        productoJugosList.add(new ProductoGeneral("Tampico Citrus Punch Botella 600ml", "jugo_tampico", "Bebida refrescante elaborada con jugo concentrado de frutas (naranja, mandarina y limón) y enriquecida con vitamina C. Es ideal para jóvenes entre 18 y 25 años que estudian y/o trabajan y a quienes les gusta viajar, experimentar y divertirse con amigos.",3.50));
        productoJugosList.add(new ProductoGeneral("Bio Amayu Arandano Botella 300ml", "jugo_bioamayu", "El Acaí es una súper fruta antioxidante por excelencia, rica en vitaminas E, C y B y delicioso sabor. Nuestro jugo con Acaí Amazónico contiene fibra dietética de fuente natural y Acaí cultivado sosteniblemente por comunidades que permiten la reforestación de la Amazonía Colombiana.",3.50));
        productoJugosList.add(new ProductoGeneral("Refresco Clight Sobre Doble 14g", "jugo_clight", "Acido cítrico, Maltodextrina, Fosfato tricálcico (agente antiaglomerante), Citrato trisódico (regulador de acidez), Edulcorante artificial sucralosa, Edulcorante artificial acesulfame -k, Sabor natural a naranja, Sabor artificial a naranja, Colorante artificial dióxido de titanio",2.09));
        productoJugosList.add(new ProductoGeneral("Cifrut Citrus Punch Botella 350ml", "jugo_cifrut", "Bebida con vitaminas esenciales C, B6, A, B12 y mezcla de jugos de naranja, mandarina y limón proveniente de concentrado. Composición Naranja, mandarina y limón Azúcares Totales 36g Grasas Totales 73kcal Proteínas Totales 0g Sodio Total 99mg ",2.20));
        productoJugosList.add(new ProductoGeneral("Refresco Instantaneo Zuko Sobre 15g", "jugo_zuko", "Zuko es polvo para preparar bebidas de fruta en 17 diferentes sabores tales como horchata, piña, naranja, mango, limonada, tamarindo, jamaica, fresa, ponche de frutas, manzana, melón y durazno, es que es fácil de preparar. Sólo agregue agua y listo!",1.20));
        productoJugosList.add(new ProductoGeneral("Umsha Chica Morada Bolsa 13g", "jugo_umsha", "Descripción: mezcla en polvo para preparar bebida instantánea sabor a chicha morada. Rinde en dos litros de agua y no necesita azúcar.\n" + "Endulzado con Stevia\n" + "Peso neto 20 g\n" + "Marca: Negrita\n" + "Procedencia: producto peruano",1.10));
        productoJugosList.add(new ProductoGeneral("Bebida Frutaris Botella 500ml", "jugo_frutaris", " Frutaris es una bebida ligeramente gasificada, con sabor a frutas. Su sabor refrescante y su contenido cero calorías es ideal para el día a día. Frutaris cuenta con sabor a manzana, fresaris, durazno y pera. ",1.50));

        adapter4 = new ProductoJugosAdaptor(productoJugosList);
        recyclerViewJugoList.setAdapter(adapter4);
    }
}