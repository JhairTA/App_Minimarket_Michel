package com.example.proyecto_final.pojo;

public class Productos {
    private String nombre;
    private String precio;
    private String imagen;
    private int recomendado;

    public Productos() {
    }

    public Productos(String nombre, String precio, String imagen, int recomendado) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.recomendado = recomendado;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getRecomendado() {
        return recomendado;
    }

    public void setRecomendado(int recomendado) {
        this.recomendado = recomendado;
    }
}
