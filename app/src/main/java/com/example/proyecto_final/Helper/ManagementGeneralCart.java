package com.example.proyecto_final.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.proyecto_final.Domain.ProductoGeneral;

import java.util.ArrayList;

public class ManagementGeneralCart {
    private Context context;
    private TinyDBGeneral tinyDBGeneral;

    public ManagementGeneralCart(Context context) {
        this.context = context;
        this.tinyDBGeneral=new TinyDBGeneral(context);
    }

    public void insertGerenal(ProductoGeneral item){
        ArrayList<ProductoGeneral> listGeneral= getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i <  listGeneral.size(); i++){
            if ( listGeneral.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }

        if (existAlready){
            listGeneral.get(n).setNumberInCart(item.getNumberInCart());
        }else{
            listGeneral.add(item);
        }
        tinyDBGeneral.putListObject("CartList",  listGeneral);
        Toast.makeText(context, "Agregado al carrito", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ProductoGeneral> getListCart(){
        return tinyDBGeneral.getListObject("CartList");
    }

}
