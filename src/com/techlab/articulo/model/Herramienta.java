package com.techlab.articulo.model;

public class Herramienta extends Articulo {

    private String marca;

    // COMPLETO
    public Herramienta(int codigo, String nombre, double precio, Categoria categoria, String marca) {
        super(codigo, nombre, precio, categoria);
        this.marca = marca;
    }

    // SIMPLE (App.java lo usa)
    public Herramienta(String nombre, double precio, String marca) {
        super(nombre, precio);
        this.marca = marca;
    }

    @Override
    public String getDetalleEspecifico() {
        return "Marca: " + marca;
    }
}
