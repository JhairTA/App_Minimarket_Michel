package com.example.proyecto_final.Domain;

import java.util.Map;

public class DataOrden {
    private String user1;
    private Map<String, DataProducto> productos;
    private double total;

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public DataOrden() {
    }

    public DataOrden(String user1, Map<String, DataProducto> productos, double total) {
        this.user1 = user1;
        this.productos = productos;
        this.total = total;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public Map<String, DataProducto> getProductos() {
        return productos;
    }

    public void setProductos(Map<String, DataProducto> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
