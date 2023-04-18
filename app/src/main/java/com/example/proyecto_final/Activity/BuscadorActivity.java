package com.example.proyecto_final.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final.Adaptor.AdapterProducto;
import com.example.proyecto_final.R;
import com.example.proyecto_final.pojo.Productos;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;

import java.util.ArrayList;

public class BuscadorActivity extends AppCompatActivity {
    DatabaseReference ref;
    ArrayList<Productos> list;
    RecyclerView rv;
    SearchView searchView;
    AdapterProducto adapter;
    LinearLayoutManager lm;

    CoordinatorLayout menu;

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
        //menu= findViewById(R.id.menu);

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

        //*****************************************************************************
        /*final Context c = this;
        final View activityRootView = findViewById(R.id.activityRoot);
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();
                if (heightDiff > dpToPx(c, 200)) {
                    menu.setVisibility(View.GONE); // Lo haces invisible y que no ocupe espacio.
                }
                else {
                    menu.setVisibility(View.VISIBLE); // Lo haces visible
                }
            }
        });*/
        //*****************************************************************************

    }

    //*****************************************************************************
    /*public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }*/
    //*****************************************************************************
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

    public void categoria(View view){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void menu(View view){
        Intent intent =new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void inicio(View view){
        Intent intent =new Intent(this, InicioActivity.class);
        startActivity(intent);
    }
}