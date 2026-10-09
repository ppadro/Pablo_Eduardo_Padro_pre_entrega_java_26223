package com.techlab.articulo.model;

public class MaterialConstruccion extends Articulo {

    private String tipoMaterial;

    // Constructor COMPLETO
    public MaterialConstruccion(int codigo, String nombre, double precio, Categoria categoria,
                                String tipoMaterial) {
        super(codigo, nombre, precio, categoria);
        this.tipoMaterial = tipoMaterial;
    }

  
    public MaterialConstruccion(String nombre, double precio, String tipoMaterial) {
        super(nombre, precio);
        this.tipoMaterial = tipoMaterial;
    }

    public String getTipoMaterial() { return tipoMaterial; }
    public void setTipoMaterial(String tipoMaterial) { this.tipoMaterial = tipoMaterial; }

    @Override
    public String getDetalleEspecifico() {
        return "Material: " + tipoMaterial;
    }
}
