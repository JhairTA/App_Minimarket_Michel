package com.example.proyecto_final.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.proyecto_final.R;
import com.example.proyecto_final.pojo.Productos;

import java.util.ArrayList;
import java.util.List;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.viewholderproductos> {

    private Context context;
    List<Productos> productosList;

    public AdapterProducto(Context context, List<Productos> productosList) {
        this.context = context;
        this.productosList = productosList;
    }


    @NonNull
    @Override
    public viewholderproductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        viewholderproductos holder = new viewholderproductos(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholderproductos holder, int position) {
        Productos pd = productosList.get(position);
        Glide.with(context).load(productosList.get(position).getImagen()).into(holder.recImage);
        holder.recTitle.setText(pd.getNombre());
        holder.recPrecio.setText(pd.getPrecio());

    }

    @Override
    public int getItemCount() {
        return productosList.size();
    }

    public class viewholderproductos extends RecyclerView.ViewHolder {

        ImageView recImage;
        TextView recTitle, recPrecio;

        public viewholderproductos(@NonNull View itemView) {
            super(itemView);

            recImage = itemView.findViewById(R.id.recImage);
            recTitle = itemView.findViewById(R.id.recTitle);
            recPrecio = itemView.findViewById(R.id.recPrecio);
        }
    }
}
