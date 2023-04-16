package com.example.proyecto_final.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.proyecto_final.Domain.Producto;
import com.example.proyecto_final.Interface.ChangeNumberItemsListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class ManagementCart3 {
    private Context context;
    private TinyDB3 tinyDB3;
    public ManagementCart3(Context context) {
        this.context = context;
        this.tinyDB3= new TinyDB3(context);
    }

    public void insertProducto(Producto item){
        ArrayList<Producto> productosList= getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < productosList.size(); i++){
            if (productosList.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }

        if (existAlready){
            productosList.get(n).setNumberInCart(item.getNumberInCart());
        }else{
            productosList.add(item);
        }
        tinyDB3.putListObject("CartList", productosList);
        Toast.makeText(context, "Agregado al carrito", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Producto> getListCart(){
        return tinyDB3.getListObject("CartList");
    }

    public void plusNumberFood(ArrayList<Producto> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()+1);
        tinyDB3.putListObject("CartList",listFood);
        changeNumberItemsListener.changed();
    }
    public void minusNumberFood(ArrayList<Producto> listFood,int position, ChangeNumberItemsListener changeNumberItemsListener){
        if(listFood.get(position).getNumberInCart()==1){
            listFood.remove(position);
        }else{
            listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()-1);
        }
        tinyDB3.putListObject("CartList",listFood);
        changeNumberItemsListener.changed();
    }
    public Double getTotalFee(){
        ArrayList<Producto> listFood=getListCart();
        double fee=0;
        for (int i=0;i< listFood.size();i++){
            fee=fee+(listFood.get(i).getFee()*listFood.get(i).getNumberInCart());
        }
        return fee;
    }
}
