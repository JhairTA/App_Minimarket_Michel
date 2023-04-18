package com.example.proyecto_final.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyecto_final.Activity.DetalleOferta;
//import com.example.proyecto_final.Domain.DataAnuncios;
import com.example.proyecto_final.R;
import com.example.proyecto_final.clases.DataAnuncios;

import java.util.ArrayList;
import java.util.List;

public class AdapterOfertas extends  RecyclerView.Adapter<MyViewHolderOfertas> {

    private Context context;
    private List<DataAnuncios> dataList;

    public AdapterOfertas(Context context, List<DataAnuncios> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolderOfertas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclercard, parent, false);
        return new MyViewHolderOfertas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderOfertas holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recTitle.setText(dataList.get(position).getDataTitle());


        //llama los datos
        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetalleOferta.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Descripcion", dataList.get(holder.getAdapterPosition()).getDataDesc());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("Key",dataList.get(holder.getAdapterPosition()).getKey());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
    public void searchDataList(ArrayList<DataAnuncios> searchList){
        dataList = searchList;
        notifyDataSetChanged();
    }

    }
class MyViewHolderOfertas extends RecyclerView.ViewHolder {

    ImageView recImage;
    TextView recTitle;
    CardView recCard;

    public MyViewHolderOfertas(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recTitle = itemView.findViewById(R.id.recTitle);

    }
}


