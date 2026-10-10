package com.techlab.articulo.model;

public class ArticuloPlomeria extends Articulo {

    private String material;

    public ArticuloPlomeria(int codigo, String nombre, double precio, Categoria categoria, String material) {
        super(codigo, nombre, precio, categoria);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String getTipoArticulo() {
        return "Plomería";
    }

    @Override
    public String getDetalleEspecifico() {
        return "Material: " + material;
    }

    @Override
    public String toString() {
        return super.toString() + " [subtipo plomería]";
    }
}