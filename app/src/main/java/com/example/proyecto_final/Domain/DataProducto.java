package com.example.proyecto_final.Domain;

public class DataProducto {

    String ID;
    private String nombreProducto;
    private int cantidad;
    private String imgProducto;
    private Double subtotal;
    private int precioUnitario;



    public DataProducto() {
    }

    public DataProducto(String ID, String nombreProducto, int cantidad, String imgProducto, Double subtotal, int precioUnitario) {
        this.ID = ID;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.imgProducto = imgProducto;
        this.subtotal = subtotal;
        this.precioUnitario = precioUnitario;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getImgProducto() {
        return imgProducto;
    }

    public void setImgProducto(String imgProducto) {
        this.imgProducto = imgProducto;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
