package com.techlab.articulo.model;

public class ArticuloElectricidad extends Articulo {

    private int voltaje;

    public ArticuloElectricidad(int codigo, String nombre, double precio, Categoria categoria, int voltaje) {
        super(codigo, nombre, precio, categoria);
        this.voltaje = voltaje;
    }

    public int getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(int voltaje) {
        this.voltaje = voltaje;
    }

    @Override
    public String getTipoArticulo() {
        return "Electricidad";
    }

    @Override
    public String getDetalleEspecifico() {
        return "Voltaje: " + voltaje + "V";
    }

    @Override
    public String toString() {
        return super.toString() + " [subtipo electricidad]";
    }
}