package com.example.proyecto_final.Adaptor;

import static java.lang.Thread.sleep;

import com.example.proyecto_final.Activity.ShowDetailActivity3;
import com.example.proyecto_final.R;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyecto_final.Domain.Producto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ProductoViewHolder> {
    private List<Producto> productoList;
    Context mCtx;

    public Adaptador(Context mCtx, List<Producto> category1){
        this.mCtx=mCtx;
        this.productoList=category1;
    }


    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_producto_yogurts,parent,false);

        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductoViewHolder holder, int position) {

        Producto productos =productoList.get(position);
        holder.tvnombre.setText(productos.getTitle());
        String precioCast= String.valueOf(productos.getFee());
        holder.tvprecio.setText(precioCast);
        //cargar imagen
        Glide.with(mCtx)
                .load(productos.getPic())
                .into(holder.ivimagen);
        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.itemView.getContext(), ShowDetailActivity3.class);
                intent.putExtra("object", productoList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder{

        TextView tvnombre,tvprecio;
        ImageView ivimagen;
        TextView addBtn;
        public ProductoViewHolder(View itemView) {
            super(itemView);
            tvnombre=(TextView)itemView.findViewById(R.id.title1);
            tvprecio=(TextView)itemView.findViewById(R.id.precio);
            ivimagen=(ImageView)itemView.findViewById(R.id.pic);
            addBtn=itemView.findViewById(R.id.addBtn);
        }


    }

}
