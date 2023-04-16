package com.example.proyecto_final;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_final.Domain.DataBoleta;

import java.util.List;

public class adapterBoleta extends RecyclerView.Adapter<ViewHolderBoleta>{


    private Context context;

    private Button2ClickListener button2ClickListener;

    private List<DataBoleta> dataListboleta ;

    public adapterBoleta(Context context, List<DataBoleta> dataListboleta) {
        this.context = context;
        this.dataListboleta = dataListboleta;
    }




    @NonNull
    @Override
    public ViewHolderBoleta onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderBoleta holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }



    public interface Button2ClickListener {
        void onButton2Click(Button button);
    }
    public void setButton2ClickListener(Button2ClickListener listener) {
        button2ClickListener = listener;
    }



}


class  ViewHolderBoleta extends RecyclerView.ViewHolder {


    ImageView recImage;
    TextView user,bfecha, bmedPago,btotal,bprecio;
    CardView recCard;
    View itemView;


    public ViewHolderBoleta(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        recImage = itemView.findViewById(R.id.recImage);

    }
}
