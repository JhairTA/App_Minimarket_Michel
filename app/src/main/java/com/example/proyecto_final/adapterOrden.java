package com.example.proyecto_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyecto_final.Domain.DataProducto;

import java.util.List;

public class adapterOrden extends RecyclerView.Adapter<MyViewHolder> {


    private Context context;

    private List<DataProducto> dataList;

    public adapterOrden(Context context, List<DataProducto> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_dtorden, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(context).load(dataList.get(position).getImgProducto()).into(holder.recImage);
        holder.recTitle.setText(dataList.get(position).getNombreProducto());
        holder.recSubtotal.setText("S/"+String.valueOf(dataList.get(position).getPrecioUnitario()));
        holder.recCantd.setText("Cantidad :"+String.valueOf(dataList.get(position).getCantidad()));
        //holder.recCantd.setText(String.valueOf(dataList.get(position).get()));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}


class  MyViewHolder extends RecyclerView.ViewHolder {


    ImageView recImage;
    TextView recTitle, recCantd, recSubtotal;
    CardView recCard;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);


        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recTitle = itemView.findViewById(R.id.recTitle);
        recSubtotal = itemView.findViewById(R.id.recSubtotal);
        recCantd = itemView.findViewById(R.id.recCantd);


    }
}
