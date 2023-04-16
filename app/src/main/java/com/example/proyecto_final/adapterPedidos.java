package com.example.proyecto_final;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final.Domain.DataOrden;

import java.util.List;

public class adapterPedidos extends RecyclerView.Adapter<ViewHolderPedidos>{


    private Context context;

    private List<DataOrden> dataListprod;


    public adapterPedidos(Context context, List<DataOrden> dataListprod) {
        this.context = context;
        this.dataListprod = dataListprod;
    }

    @NonNull
    @Override
    public ViewHolderPedidos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPedidos holder, int position) {


        holder.txtuser.setText(dataListprod.get(position).getUser1());
        holder.txttotal.setText(String.valueOf(dataListprod.get(position).getTotal()));

    }

    @Override
    public int getItemCount() {
        return dataListprod.size();
    }
}

class  ViewHolderPedidos extends RecyclerView.ViewHolder {


    TextView txtuser, txttotal, recSubtotal;
    CardView recCardpedidos;


    public ViewHolderPedidos(@NonNull View itemView) {
        super(itemView);



        recCardpedidos = itemView.findViewById(R.id.cardViewPedidos);
        txtuser = itemView.findViewById(R.id.txtusuariopedido);
        txttotal = itemView.findViewById(R.id.txtpreciototal);

    }
}