package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final.Adaptor.CategoryAdaptor;
import com.example.proyecto_final.Adaptor.ProductoCuidadoBucalAdaptor;
import com.example.proyecto_final.Adaptor.ProductoHigienePersonalAdaptor;
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

public class CuidadoPersonalActivity extends AppCompatActivity {

    private Toolbar toolbar1;

    private RecyclerView.Adapter adapter, adapter2, adapter3;

    private RecyclerView recyclerViewCategoriaList, recyclerViewProductoCuidadoBucalList, recyclerViewProductoHigienePersonalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuidado_personal);

        toolbar1 = findViewById(R.id.toolbar1);
        toolbar1.setTitle("Categoria");
        setSupportActionBar(toolbar1);

        recyclerViewCategoria();
        recyclerViewProductoCuidadoBucal();
        recyclerViewProductoHigienePersonal();
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
                    case "BEBIDAS":{
                        Intent intent = new Intent(getApplicationContext(), BebidasActivity.class);
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

    private void recyclerViewProductoCuidadoBucal(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewProductoCuidadoBucalList = findViewById(R.id.rv2);
        recyclerViewProductoCuidadoBucalList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoCuidadoBucalList = new ArrayList<>();
        productoCuidadoBucalList.add(new ProductoGeneral("Pasta Dental Colgate Paquete 3un", "cu_colgate", "La Pasta Dental Colgate contiene enzimas naturales que ayudan a eliminar la placa y los residuos de comida de los dientes y encías",18.00));
        productoCuidadoBucalList.add(new ProductoGeneral("Listerine Enjuague Bucal 500ml", "cu_listerine", "Esta fórmula especializada está diseñada para combatir la placa y el mal aliento, dejando una sensación de limpieza en la boca.",17.00));
        productoCuidadoBucalList.add(new ProductoGeneral("Hilo Dental Oral-B X 1 Unidad", "cu_hilo", "Es una herramienta esencial para la limpieza dental diaria. Este hilo dental está diseñado para ayudar a eliminar la placa y los restos de comida entre los dientes y debajo de la línea de las encías, áreas donde el cepillado regular no puede llegar.",11.75));
        productoCuidadoBucalList.add(new ProductoGeneral("Cepillo Dental Colgate 3 Unidades", "cu_cepillo", "Estos cepillos dentales están diseñados para ayudar a eliminar la placa y los restos de comida entre los dientes y debajo de la línea de las encías, áreas donde el cepillado regular no puede llegar",15.20));
        productoCuidadoBucalList.add(new ProductoGeneral("Pasta Dental Oral-B Caja 75ml", "cu_oralb", "Esta pasta dental tiene una fórmula avanzada que contiene flúor y otros ingredientes que ayudan a fortalecer el esmalte dental y a proteger los dientes de las bacterias y los ácidos que pueden causar caries.",12.50));
        productoCuidadoBucalList.add(new ProductoGeneral("Colgate Enjuague Bucal X 500ml", "cu_colgateenjuage", "Este enjuague bucal tiene una fórmula avanzada que contiene fluoruro y otros ingredientes que ayudan a proteger los dientes y las encías de las bacterias que pueden causar caries, placa y problemas de las encías.\n",17.58));
        productoCuidadoBucalList.add(new ProductoGeneral("Pasta Dental Dento Tubo 75ml", "cu_dento", "Esta pasta dental contiene una fórmula básica que ayuda a eliminar la placa y los restos de comida de los dientes y las encías, y proporciona una sensación de limpieza en la boca después del cepillado.",15.20));
        productoCuidadoBucalList.add(new ProductoGeneral("Cepillo Electrico Oral-B Caja 1un", "cu_cepilloelectrico", "El cepillo eléctrico Oral-B cuenta con cerdas redondeadas y suaves que son suaves con los dientes y las encías. La cabeza del cepillo es oscilante y rotativa, lo que permite una limpieza efectiva y una eliminación más completa de la placa dental.",59.90));
        productoCuidadoBucalList.add(new ProductoGeneral("Dento Enjuague Bucal Menta 500ml", "cu_dentoenjuage", "Este enjuague bucal tiene una fórmula avanzada que contiene ingredientes que ayudan a combatir la placa bacteriana, previenen la caries y promueven una buena salud bucal.",14.50));
        productoCuidadoBucalList.add(new ProductoGeneral("Hilo Dental Colgate X 1 Unidad", "cu_colgatehilo", "Este hilo dental es suave y resistente, lo que le permite deslizarse fácilmente entre los dientes y eliminar los restos de comida y la placa bacteriana que se acumulan en los espacios interdentales.",13.19));

        adapter2=new ProductoCuidadoBucalAdaptor(productoCuidadoBucalList);
        recyclerViewProductoCuidadoBucalList.setAdapter(adapter2);
    }

    private void recyclerViewProductoHigienePersonal(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewProductoHigienePersonalList = findViewById(R.id.rv3);
        recyclerViewProductoHigienePersonalList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductoGeneral> productoHigienePersonalList = new ArrayList<>();
        productoHigienePersonalList.add(new ProductoGeneral("Jabón Dove Cremoso Original 3un", "hp_dove", "Esta suave fórmula limpiadora contiene 1/4 de crema humectante para darte una piel más suave, sedosa y de apariencia más saludable.",11.70));
        productoHigienePersonalList.add(new ProductoGeneral("Moncler Jabón Azul Barra 145g ", "hp_moncler", "Jabón de tocador unitario Moncler azul refrescante. Su inconfundible fragancia reproduce un aroma fresco y limpio. Perfecto para el cuidado corporal, ya que cuenta con excelente formulación, alto rendimiento y una forma anatómica. Moncler, dura toda una familia.",5.10));
        productoHigienePersonalList.add(new ProductoGeneral("Desodorante Axe Epic Fresh 150ml", "hp_axe", "Audaz, fresco y deportivo, el nuevo desodorante AXE Epic Fresh llegó para quedarse. Con una fragancia de notas amaderadas y un giro de frescura que le aportan el ananá y el pomelo, te va a llevar sin dudas a una experiencia épica.",12.90));
        productoHigienePersonalList.add(new ProductoGeneral("Jabón en Barra Protex Fresh", "hp_protex", "Jabón antibacterial en barra Protex® elimina impurezas suavemente para una piel saludable. Ofrece una protección antibacterial natural con óleo de linaza.\n" + "\n" + "Elimina el 99.9 % de las bacterias* naturalmente manteniendote protegido al largo del día**.",3.20));
        productoHigienePersonalList.add(new ProductoGeneral("Desodorante Lady Speed Stick Barra 45g", "hp_ladyspeed", "Este desodorante antitranspirante para mujer te mantiene ultra seca y protegida contra el sudor y mal olor hasta por 48 horas. Confía en ti misma y atrévete a hacer lo que te mueve con Lady Speed Stick® 24/7 Powder Fresh en barra, una protección tan bárbara como tú",19.30));
        productoHigienePersonalList.add(new ProductoGeneral("Desodorante Rexona Invisible X 150ml", "hp_rexona", "No más manchas de antitranspirante\n" + "Máxima protección contra manchas de sudor amarillas y blancas.\n" + "Protección superior por 48 horas sin dejar rastros ni manchas.\n"+ "Disponible para hombre y para mujer",17.58));
        productoHigienePersonalList.add(new ProductoGeneral("H&S Classic Clean 650ml", "hp_hs", "H&S Classic Clean Shampoo brinda un cuidado clásico que limpia profundamente tu cabello dejándolo fresco y cuidado además de ayudar a reducir la caspa y molestias como picazón y sequedad.",10.50));
        productoHigienePersonalList.add(new ProductoGeneral("Desodorante Old Spice - Spray 150ml", "hp_oldspice", "Conoce el desodorante en aerosol Old Spice\n" + "\n" + "- Con tecnología DuraScent ™, para oler increíble todo el dia\n" + "- Antibacterial: Elimina hasta 99.9% de las bacterias que producen el mal olor\n" + "- Body Spray: Puedes usarlo de pies a cabeza",17.40));
        productoHigienePersonalList.add(new ProductoGeneral("Jabón Liquido Aval Frutos Rojos 800ml", "hp_aval", "El Jabón Líquido Aval es hipoalergénico contiene extracto de vainilla que deja suavidad y un olor incomparable , además protege tu piel ya que es antibacterial y elimina el 99.99% de las bacterias.",13.20));
        productoHigienePersonalList.add(new ProductoGeneral("Nivea Soft Crema Humectante X 100 ml", "hp_nivea", "NIVEA Soft, la crema de humectación intensiva, es una emulsión de aceite en agua. ¿Que quiere decir? Las gotitas más pequeñas de aceite se sitúan dentro de una fase acuosa, absorbiéndose rápidamente en la piel. Cuando tu piel está bien hidratada, luce sedosa, fresca y te hace sentir bien.",18.90));

        adapter3=new ProductoHigienePersonalAdaptor(productoHigienePersonalList);
        recyclerViewProductoHigienePersonalList.setAdapter(adapter3);
    }
}