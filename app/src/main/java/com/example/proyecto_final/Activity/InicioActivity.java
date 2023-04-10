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
import com.example.proyecto_final.Domain.Producto;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;
import android.os.Bundle;
import android.view.View;

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

    List<Producto> productosList;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        easySlider=findViewById(R.id.sliderId);
        List<SliderItem> easySliders=new ArrayList<>();

        easySliders.add(new SliderItem("p1",R.drawable.p1));
        easySliders.add(new SliderItem("p2",R.drawable.p2));
        easySliders.add(new SliderItem("p3",R.drawable.p3));

        easySlider.setPages(easySliders);
        rv1 = (RecyclerView) findViewById(R.id.rv1);
        rv1.setHasFixedSize(true);
        rv1.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        //rv1.setLayoutManager(new LinearLayoutManager(this));
        productosList=new ArrayList<>();
        adaptador=new Adaptador(getApplicationContext(),productosList);
        rv1.setAdapter(adaptador);
        load();
    }

    public void categoria(View view){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void menu(View view){
        Intent intent =new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void buscar(View view){
        Intent intent =new Intent(this, BuscadorActivity.class);
        startActivity(intent);
    }

    private void load(){
        int autor = 1;
        Query query = FirebaseDatabase.getInstance().getReference("Producto").orderByChild("recomendado").equalTo(autor);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                productosList.clear();
                for(DataSnapshot productoSnapshot : snapshot.getChildren()) {
                    Producto producto= productoSnapshot.getValue(Producto.class);
                    productosList.add(producto);
                }
                adaptador.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}