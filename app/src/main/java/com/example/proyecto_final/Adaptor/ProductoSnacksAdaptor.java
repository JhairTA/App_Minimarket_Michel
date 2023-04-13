package com.example.proyecto_final.Adaptor;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyecto_final.Activity.ShowDetailGeneralActivity;
import com.example.proyecto_final.Domain.ProductoGeneral;
import com.example.proyecto_final.R;

import java.util.ArrayList;

public class ProductoSnacksAdaptor extends RecyclerView.Adapter<ProductoSnacksAdaptor.ViewHolder> {
    ArrayList<ProductoGeneral> productoSnack;

    public ProductoSnacksAdaptor(ArrayList<ProductoGeneral> categoryProduct1) {
        this.productoSnack = categoryProduct1;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_producto_yogurts,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoSnacksAdaptor.ViewHolder holder, int position) {
        holder.title.setText(productoSnack.get(position).getTitle());
        holder.fee.setText(String.valueOf(productoSnack.get(position).getFee()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(productoSnack.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailGeneralActivity.class);
                intent.putExtra("object", productoSnack.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productoSnack.size();
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
