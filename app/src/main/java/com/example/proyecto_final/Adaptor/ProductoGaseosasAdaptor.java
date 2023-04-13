package com.example.proyecto_final.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyecto_final.Domain.ProductoGeneral;
import com.example.proyecto_final.R;

import java.util.ArrayList;

public class ProductoGaseosasAdaptor extends RecyclerView.Adapter<ProductoGaseosasAdaptor.ViewHolder> {
    ArrayList<ProductoGeneral> productoGaseosa;

    public ProductoGaseosasAdaptor(ArrayList<ProductoGeneral> categoryProduct1) {
        this.productoGaseosa = categoryProduct1;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_producto_yogurts,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoGaseosasAdaptor.ViewHolder holder, int position) {
        holder.title.setText(productoGaseosa.get(position).getTitle());
        holder.fee.setText(String.valueOf(productoGaseosa.get(position).getFee()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(productoGaseosa.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);

        /*holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetail2Activity.class);
                intent.putExtra("object", productoAgua.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return productoGaseosa.size();
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
