package com.example.proyecto_final.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final.Adaptor.AdapterProducto;
import com.example.proyecto_final.R;
import com.example.proyecto_final.pojo.Productos;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.os.Bundle;

import java.util.ArrayList;

public class BuscadorActivity extends AppCompatActivity {
    DatabaseReference ref;
    ArrayList<Productos> list;
    RecyclerView rv;
    SearchView searchView;
    AdapterProducto adapter;
    LinearLayoutManager lm;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Buscador");
        setSupportActionBar(toolbar);

        ref = FirebaseDatabase.getInstance().getReference().child("Producto");
        rv = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.search);
        lm = new LinearLayoutManager((this));

        rv.setLayoutManager(lm);
        list = new ArrayList<>();
        adapter = new AdapterProducto(getApplicationContext(),list);
        rv.setAdapter(adapter);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        Productos pd = snapshot.getValue(Productos.class);
                        list.add(pd);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                buscar(s);
                return true;
            }
        });
    }

    private void buscar(String s){
        ArrayList<Productos> milista = new ArrayList<>();
        for (Productos obj: list){
            if (obj.getNombre().toLowerCase().contains(s.toLowerCase())) {
                milista.add(obj);
            }
        }
        AdapterProducto adapter = new AdapterProducto(getApplicationContext(),milista);
        rv.setAdapter(adapter);
    }
}