package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;*/
import com.example.proyecto_final.Adaptor.Adaptador;
import com.example.proyecto_final.Adaptor.ProductoRecomendadoAdaptor;
import com.example.proyecto_final.Domain.Producto;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.proyecto_final.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ahmed.easyslider.EasySlider;
import ahmed.easyslider.SliderItem;

public class InicioActivity extends AppCompatActivity {

    EasySlider easySlider;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;
    RecyclerView rv1;

    private RecyclerView recyclerViewProductoYogurtsList;


    private ProductoRecomendadoAdaptor adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        rv1 = findViewById(R.id.rv1);

        easySlider=findViewById(R.id.sliderId);
        List<SliderItem> easySliders=new ArrayList<>();

        easySliders.add(new SliderItem("Anuncio 1",R.drawable.p1));
        easySliders.add(new SliderItem("Anuncio 2",R.drawable.p2));
        easySliders.add(new SliderItem("Anuncio 3",R.drawable.p3));

        easySlider.setPages(easySliders);
        rv1 = (RecyclerView) findViewById(R.id.rv1);
        rv1.setHasFixedSize(true);
         rv1.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        rv1.setLayoutManager(new LinearLayoutManager(this));
        //productosList=new ArrayList<>();
        //adaptador=new Adaptador(getApplicationContext(),productosList);
        //rv1.setAdapter(adaptador);

        recyclerViewProductoYogurts();
        bottonNavigation();
        //load();
    }

    public void categoria(View view){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void menu(View view){
        Intent intent =new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void ofertas(View view){
        Intent intent =new Intent(this, MasOfertas.class);
        startActivity(intent);
    }

    public void buscar(View view){
        Intent intent =new Intent(this, BuscadorActivity.class);
        startActivity(intent);
    }
    private void bottonNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InicioActivity.this, CarritoActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InicioActivity.this,InicioActivity.class));
            }
        });
    }

    //opcion
    public void Registro(View view){
        Intent intent =new Intent(this, LoginRegistrar.class);
        startActivity(intent);
    }


    private void load(){

    }


    private void recyclerViewProductoYogurts(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewProductoYogurtsList = findViewById(R.id.rv1);
        recyclerViewProductoYogurtsList.setLayoutManager(linearLayoutManager);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Recomendados");
        Producto producto1 = new Producto("Yogurt Griego", "yogurt_griego", "Con la perfecta combinación de cremosidad, textura y deliciosos sabores  40g de proteína en una botella. SIN azúcar añadida.", 7.90,1);
        reference.child("producto1").setValue(producto1);
       //Producto producto2 = new Producto("Gaseosa Coca Cola Botella 600ml", "https://backusyaperu.vtexassets.com/arquivos/ids/155718/Gaseosa-Coca-Cola-500ml..jpg?v=637761566527370000", "Con la perfecta combinación de cremosidad, textura y deliciosos sabores  40g de proteína en una botella. SIN azúcar añadida.", 7.90,1);
        //reference.child("producto2").setValue(producto2);
        //Producto producto3 = new Producto("Yogurt Griego", "yogurt_griego", "Con la perfecta combinación de cremosidad, textura y deliciosos sabores  40g de proteína en una botella. SIN azúcar añadida.", 7.90,1);
        //reference.child("producto3").setValue(producto3);
        ArrayList<Producto> productoYogurtsList = new ArrayList<>();
        int autor = 1;
        Query query = FirebaseDatabase.getInstance().getReference("Recomendado").orderByChild("recomendado").equalTo(autor);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                productoYogurtsList.clear();
                for(DataSnapshot productoSnapshot : snapshot.getChildren()) {
                    Producto producto= productoSnapshot.getValue(Producto.class);
                    productoYogurtsList.add(producto);
                }
                adaptador.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


        adaptador=new ProductoRecomendadoAdaptor(productoYogurtsList);
        recyclerViewProductoYogurtsList.setAdapter(adaptador);
    }
}