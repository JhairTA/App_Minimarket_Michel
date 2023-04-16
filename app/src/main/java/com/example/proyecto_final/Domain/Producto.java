package com.example.proyecto_final.Domain;

import java.io.Serializable;

public class Producto implements Serializable {
    private String title;
    private String pic;
    private String description;
    private double fee;
    private int recomendado;
    private int numberInCart;

    public Producto(String title, String pic, String description, double fee, int recomendado) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
        this.recomendado = recomendado;
    }

    public Producto() {
    }

    public Producto(String title, String pic, String description, double fee, int recomendado, int numberInCart) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
        this.recomendado = recomendado;
        this.numberInCart = numberInCart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getRecomendado() {
        return recomendado;
    }

    public void setRecomendado(int recomendado) {
        this.recomendado = recomendado;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
