package com.example.proyecto_final.Domain;

import java.util.Map;

public class DataBoleta {

    private String idBoleta;
    private String usuario;
    private Map<String, DataProducto> productos;
    private double total;
    private String medioPago;
    private String fecha;
    private int totalproducto;

    public DataBoleta() {
    }

    public DataBoleta(double total, String fecha) {
        this.total = total;
        this.fecha = fecha;
    }

    public int getTotalproducto() {
        return totalproducto;
    }

    public void setTotalproducto(int totalproducto) {
        this.totalproducto = totalproducto;
    }

    public String getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(String idBoleta) {
        this.idBoleta = idBoleta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
