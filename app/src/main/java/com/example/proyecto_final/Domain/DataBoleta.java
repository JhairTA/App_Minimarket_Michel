package com.example.proyecto_final.Domain;

import java.util.Map;

public class DataBoleta {

    private String idBoleta;
    private String apellido;
    private Map<String, DataProducto> productos;
    private double total;
    private String medioPago;
    private String fecha;
    private double totalproducto;

    public DataBoleta() {
    }

    public DataBoleta(String apellido, double total, String fecha) {
        this.apellido = apellido;
        this.total = total;
        this.fecha = fecha;
    }

    public String getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(String idBoleta) {
        this.idBoleta = idBoleta;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public double getTotalproducto() {
        return totalproducto;
    }

    public void setTotalproducto(double totalproducto) {
        this.totalproducto = totalproducto;
    }
}
