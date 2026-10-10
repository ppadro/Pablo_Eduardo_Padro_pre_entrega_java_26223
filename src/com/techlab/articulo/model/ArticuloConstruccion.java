package com.techlab.articulo.model;

public class ArticuloConstruccion extends Articulo {

    private double pesoKg;

    public ArticuloConstruccion(int codigo, String nombre, double precio, Categoria categoria, double pesoKg) {
        super(codigo, nombre, precio, categoria);
        this.pesoKg = pesoKg;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    @Override
    public String getTipoArticulo() {
        return "Construcción";
    }

    @Override
    public String getDetalleEspecifico() {
        return "Peso: " + pesoKg + " kg";
    }

    @Override
    public String toString() {
        return super.toString() + " [subtipo construcción]";
    }
}