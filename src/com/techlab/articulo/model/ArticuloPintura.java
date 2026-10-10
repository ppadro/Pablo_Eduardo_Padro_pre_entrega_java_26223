package com.techlab.articulo.model;

public class ArticuloPintura extends Articulo {

    private String color;
    private double litros;

    public ArticuloPintura(int codigo, String nombre, double precio, Categoria categoria, String color, double litros) {
        super(codigo, nombre, precio, categoria);
        this.color = color;
        this.litros = litros;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    @Override
    public String getTipoArticulo() {
        return "Pintura";
    }

    @Override
    public String getDetalleEspecifico() {
        return "Color: " + color + ", Litros: " + litros + "L";
    }

    @Override
    public String toString() {
        return super.toString() + " [subtipo pintura]";
    }
}