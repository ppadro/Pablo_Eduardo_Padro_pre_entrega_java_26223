package com.techlab.articulo.model;

public class Plomeria extends Articulo {

    private String material;

    // Constructor COMPLETO
    public Plomeria(int codigo, String nombre, double precio, Categoria categoria,
                    String material) {
        super(codigo, nombre, precio, categoria);
        this.material = material;
    }

  
    public Plomeria(String nombre, double precio, String material) {
        super(nombre, precio);
        this.material = material;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    @Override
    public String getDetalleEspecifico() {
        return "Material: " + material;
    }
}
