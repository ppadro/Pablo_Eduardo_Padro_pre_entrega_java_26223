package com.techlab.articulo.model;

public class Pintura extends Articulo {

    private String color;
    private double litros;

 
    public Pintura(int codigo, String nombre, double precio, Categoria categoria,
                   String color, double litros) {
        super(codigo, nombre, precio, categoria);
        this.color = color;
        this.litros = litros;
    }

    // Constructor SIMPLE (App.java lo usa)
    public Pintura(String nombre, double precio, String color) {
        super(nombre, precio);
        this.color = color;
        this.litros = 0;
    }

    public String getColor() { return color; }
    public double getLitros() { return litros; }

    public void setColor(String color) { this.color = color; }
    public void setLitros(double litros) { this.litros = litros; }

    @Override
    public String getDetalleEspecifico() {
        return "Color: " + color + ", Litros: " + litros;
    }
}
