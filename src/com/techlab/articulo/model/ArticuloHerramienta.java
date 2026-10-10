package com.techlab.articulo.model;

public class ArticuloHerramienta extends Articulo {

    private String tipoHerramienta;

    public ArticuloHerramienta(int codigo, String nombre, double precio, Categoria categoria, String tipoHerramienta) {
        super(codigo, nombre, precio, categoria);
        this.tipoHerramienta = tipoHerramienta;
    }

    public String getTipoHerramienta() {
        return tipoHerramienta;
    }

    public void setTipoHerramienta(String tipoHerramienta) {
        this.tipoHerramienta = tipoHerramienta;
    }

    @Override
    public String getTipoArticulo() {
        return "Herramienta";
    }

    @Override
    public String getDetalleEspecifico() {
        return "Tipo: " + tipoHerramienta;
    }

    @Override
    public String toString() {
        return super.toString() + " [subtipo herramienta]";
    }
}