package com.example.proyecto_final.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.proyecto_final.Domain.ProductoLeches;

import java.util.ArrayList;

public class ManagementCart2 {
    private Context context;
    private TinyDB2 tinyDB2;

    public ManagementCart2(Context context) {
        this.context = context;
        this.tinyDB2= new TinyDB2(context);
    }

    public void insertLeches(ProductoLeches item){
        ArrayList<ProductoLeches> listLeches= getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listLeches.size(); i++){
            if (listLeches.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }

        if (existAlready){
            listLeches.get(n).setNumberInCart(item.getNumberInCart());
        }else{
            listLeches.add(item);
        }
        tinyDB2.putListObject("CartList", listLeches);
        Toast.makeText(context, "Agregado al carrito", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ProductoLeches> getListCart(){
        return tinyDB2.getListObject("CartList");
    }

}
