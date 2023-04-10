package com.example.proyecto_final.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.proyecto_final.Domain.ProductoYogurts;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB=new TinyDB(context);
    }

    public void insertYogurt(ProductoYogurts item){
        ArrayList<ProductoYogurts> listYogurts= getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listYogurts.size(); i++){
            if (listYogurts.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }

        if (existAlready){
            listYogurts.get(n).setNumberInCart(item.getNumberInCart());
        }else{
            listYogurts.add(item);
        }
        tinyDB.putListObject("CartList", listYogurts);
        Toast.makeText(context, "Agregado al carrito", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ProductoYogurts> getListCart(){
        return tinyDB.getListObject("CartList");
    }

}
