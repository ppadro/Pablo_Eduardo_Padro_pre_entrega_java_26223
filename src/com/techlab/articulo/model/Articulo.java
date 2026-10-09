package com.techlab.articulo.model;

public abstract class Articulo {

    private int codigo;
    private String nombre;
    private double precio;
    private Categoria categoria;

    // Constructor COMPLETO
    public Articulo(int codigo, String nombre, double precio, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    // Constructor SIMPLE (App.java lo usa)
    public Articulo(String nombre, double precio) {
        this.codigo = 0;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = null;
    }

    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public Categoria getCategoria() { return categoria; }

    public void setPrecio(double precio) { this.precio = precio; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public abstract String getDetalleEspecifico();

    @Override
    public String toString() {
        return "Nombre: " + nombre +
               ", Precio: " + precio +
               ", Categoría: " + (categoria != null ? categoria.getNombre() : "Sin categoría") +
               ", " + getDetalleEspecifico();
    }
}

