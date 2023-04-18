package com.example.proyecto_final.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import com.example.proyecto_final.Adaptor.MyAdapter;
import com.example.proyecto_final.R;
import android.os.Bundle;
import android.view.View;

//import com.example.minimark_michael.clases.DataAnuncios;
import com.example.proyecto_final.clases.DataAnuncios;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Rcyv_itemAnuncios extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    FloatingActionButton fab;
    RecyclerView recyclerView;
    List<DataAnuncios> dataList;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;

    MyAdapter adapter;
    SearchView searchView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcyv_item_anuncios);

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.search);
        searchView.clearFocus();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(Rcyv_itemAnuncios.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        AlertDialog.Builder builder = new AlertDialog.Builder(Rcyv_itemAnuncios.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        dataList = new ArrayList<>();

        //
        adapter= new MyAdapter(Rcyv_itemAnuncios.this,dataList);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Anuncios");
        dialog.show();


        eventListener = databaseReference.addValueEventListener((new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for (DataSnapshot itemSnapshot: snapshot.getChildren()){
                    DataAnuncios dataClass = itemSnapshot.getValue(DataAnuncios.class);
                    dataClass.setKey(itemSnapshot.getKey());
                    dataList.add(dataClass);
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
            }
        }));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Rcyv_itemAnuncios.this, UploadActivity.class);
                startActivity(intent);
            }
        });
    }
    public void searchList(String text){
        ArrayList<DataAnuncios> searchList = new ArrayList<>();
        for (DataAnuncios dataAnuncios: dataList){
            if (dataAnuncios.getDataTitle().toLowerCase().contains(text.toLowerCase())){
                searchList.add(dataAnuncios);
            }
        }
        adapter.searchDataList(searchList);
    }
}