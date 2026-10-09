package com.techlab.articulo.model;

public class Electricidad extends Articulo {

    private String voltaje;


    public Electricidad(int codigo, String nombre, double precio, Categoria categoria,
                        String voltaje) {
        super(codigo, nombre, precio, categoria);
        this.voltaje = voltaje;
    }

    // Constructor SIMPLE
    public Electricidad(String nombre, double precio, String voltaje) {
        super(nombre, precio);
        this.voltaje = voltaje;
    }

    public String getVoltaje() { return voltaje; }
    public void setVoltaje(String voltaje) { this.voltaje = voltaje; }

    @Override
    public String getDetalleEspecifico() {
        return "Voltaje: " + voltaje;
    }
}
