package com.example.proyecto_final.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyecto_final.Activity.ShowDetailActivity;
import com.example.proyecto_final.Activity.ShowDetailActivity3;
import com.example.proyecto_final.Domain.Producto;
import com.example.proyecto_final.Domain.ProductoYogurts;
import com.example.proyecto_final.R;

import java.util.ArrayList;

public class ProductoRecomendadoAdaptor extends RecyclerView.Adapter<ProductoRecomendadoAdaptor.ViewHolder> {
    ArrayList<Producto> productoYogurt;

    public ProductoRecomendadoAdaptor(ArrayList<Producto> categoryProduct1) {
        this.productoYogurt = categoryProduct1;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_producto_yogurts,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(productoYogurt.get(position).getTitle());
        holder.fee.setText(String.valueOf(productoYogurt.get(position).getFee()));

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.itemView.getContext(), ShowDetailActivity3.class);
                intent.putExtra("object", productoYogurt.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productoYogurt.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView title, fee;
        ImageView pic;
        TextView addBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title1);
            fee = itemView.findViewById(R.id.precio);
            pic = itemView.findViewById(R.id.pic);
            addBtn=itemView.findViewById(R.id.addBtn);

        }
    }
}
