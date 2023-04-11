package com.example.proyecto_final.Domain;

public class Producto {
    int id;
    String nombre;
    String precio;
    int recomendado;
    String imagen;

    public Producto(int id, String nombre, String precio, int recomendado, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.recomendado = recomendado;
        this.imagen = imagen;
    }

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getRecomendado() {
        return recomendado;
    }

    public void setRecomendado(int recomendado) {
        this.recomendado = recomendado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
