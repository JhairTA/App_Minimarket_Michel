package com.example.proyecto_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.proyecto_final.Adaptor.CartListAdapter;
import com.example.proyecto_final.Helper.ManagementCart;
import com.example.proyecto_final.Interface.ChangeNumberItemsListener;
import com.example.proyecto_final.R;
import com.example.proyecto_final.ViewPagos;
import com.example.proyecto_final.ViewPedidos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CarritoActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    TextView totalFeeTxt, taxTxt,deliveryTxt,totalTxt,emptyTxt;

    private double tax;
    private ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        managementCart=new ManagementCart(this);
        initView();
        initList();
        CalculateCart();
    }

    public void buscar(View view){
        Intent intent =new Intent(this, BuscadorActivity.class);
        startActivity(intent);
    }

    public void IngresarPedidos (View view){
        CalculateCart();
        Intent i = new Intent(this, ViewPedidos.class);
        i.putExtra("itemTotal",totalFeeTxt.getText().toString());
        i.putExtra("delivery",deliveryTxt.getText().toString());
        i.putExtra("total",totalTxt.getText().toString());

        startActivity(i);



    }
    public void inicio(View view){
        Intent intent =new Intent(this, InicioActivity.class);
        startActivity(intent);
    }

    public void menu(View view){
        Intent intent =new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
    public void categoria(View view){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void initView() {
        recyclerViewList=findViewById(R.id.recyclerView);
        totalFeeTxt=findViewById(R.id.totalFeeTxt);
        taxTxt=findViewById(R.id.taxTxt);
        deliveryTxt=findViewById(R.id.deliveryTxt);
        totalTxt=findViewById(R.id.totalTxt);
        emptyTxt=findViewById(R.id.emptyTxt);
        scrollView=findViewById(R.id.scrollView3);
        recyclerViewList=findViewById(R.id.recyclerView);
    }
    private void initList(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter=new CartListAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                CalculateCart();
            }
        });
        recyclerViewList.setAdapter(adapter);
        if(managementCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else{
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }
    public void CalculateCart(){


        Bundle cartData = new Bundle();

        double percentTax=0.02;
        double delivery=10;

        tax =Math.round((managementCart.getTotalFee()*percentTax)*100)/100;
        double total=Math.round((managementCart.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal=Math.round(managementCart.getTotalFee()*100)/100;

        totalFeeTxt.setText("S/"+" "+itemTotal);
        taxTxt.setText("$"+tax);
        deliveryTxt.setText("S/"+" "+delivery);
        totalTxt.setText(" "+total);

    }

    public Bundle getCartData() {
        Bundle cartData = new Bundle();
        double percentTax=0.02;
        double delivery=10;

        tax =Math.round((managementCart.getTotalFee()*percentTax)*100)/100;
        double total=Math.round((managementCart.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal=Math.round(managementCart.getTotalFee()*100)/100;

        cartData.putDouble("itemTotal", itemTotal);
        cartData.putDouble("tax", tax);
        cartData.putDouble("delivery", delivery);
        cartData.putDouble("total", total);

        //
        Intent intent =new Intent(CarritoActivity.this,ViewPedidos.class);
        intent.putExtras(cartData);
        startActivity(intent);
        //
        return cartData;
    }

}