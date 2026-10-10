package com.techlab.articulo;

import java.util.ArrayList;
import java.util.Scanner;

import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.ArticuloElectricidad;
import com.techlab.articulo.model.ArticuloPintura;
import com.techlab.articulo.model.ArticuloHerramienta;
import com.techlab.articulo.model.ArticuloConstruccion;
import com.techlab.articulo.model.ArticuloPlomeria;
import com.techlab.articulo.model.Categoria;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Articulo> articulos = new ArrayList<>();
        ArrayList<Categoria> categorias = new ArrayList<>();
        precargarCategorias(categorias);

        int opcion;

        do {
            System.out.println("\n======================================================");
            System.out.println(" SISTEMA DE ARTICULOS - FERRETERIA");
            System.out.println("======================================================");
            System.out.println("1 - Ingresar artículo");
            System.out.println("2 - Listar artículos");
            System.out.println("3 - Consultar un artículo");
            System.out.println("4 - Modificar un artículo");
            System.out.println("5 - Eliminar un artículo");
            System.out.println("6 - Listar categorías");
            System.out.println("0 - Salir");
            System.out.println("======================================================");

            opcion = leerEntero(scanner, "Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    ingresarArticulo(scanner, articulos, categorias);
                    break;
                case 2:
                    listarArticulos(articulos);
                    break;
                case 3:
                    consultarArticulo(scanner, articulos);
                    break;
                case 4:
                    modificarArticulo(scanner, articulos, categorias);
                    break;
                case 5:
                    eliminarArticulo(scanner, articulos);
                    break;
                case 6:
                    listarCategorias(categorias);
                    break;
                case 0:
                    System.out.println("\nSaliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("\nError: la opción ingresada no es válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    public static void precargarCategorias(ArrayList<Categoria> categorias) {
        categorias.add(new Categoria(1, "Electricidad", "Materiales e insumos eléctricos"));
        categorias.add(new Categoria(2, "Pintura", "Pinturas, látex y esmaltes"));
        categorias.add(new Categoria(3, "Herramientas", "Herramientas manuales y eléctricas"));
        categorias.add(new Categoria(4, "Construcción", "Materiales para la construcción"));
        categorias.add(new Categoria(5, "Plomería", "Tubos, conexiones y grifería"));
    }

    public static void ingresarArticulo(
            Scanner scanner,
            ArrayList<Articulo> articulos,
            ArrayList<Categoria> categorias
    ) {
        System.out.println("\n--- INGRESAR ARTÍCULO ---");
        System.out.println("1 - Artículo de Electricidad");
        System.out.println("2 - Artículo de Pintura");
        System.out.println("3 - Artículo Herramienta");
        System.out.println("4 - Artículo de Construcción");
        System.out.println("5 - Artículo de Plomería");

        int tipo;
        do {
            tipo = leerEntero(scanner, "Seleccione el tipo de artículo: ");

            if (tipo < 1 || tipo > 5) {
                System.out.println("Error: debe elegir entre 1 y 5.");
            }

        } while (tipo < 1 || tipo > 5);

        int codigo = leerEntero(scanner, "Ingrese el código del artículo: ");

        if (buscarArticuloPorCodigo(articulos, codigo) != null) {
            System.out.println("Error: ya existe un artículo con ese código.");
            return;
        }

        String nombre = leerTextoNoVacio(scanner, "Ingrese el nombre del artículo: ");
        double precio = leerDoubleNoNegativo(scanner, "Ingrese el precio del artículo: ");

        listarCategorias(categorias);
        Categoria categoria = pedirCategoriaExistente(scanner, categorias);

        Articulo articulo = null;

        if (tipo == 1) {
            int voltaje = leerEnteroNoNegativo(scanner, "Ingrese el voltaje: ");
            articulo = new ArticuloElectricidad(codigo, nombre, precio, categoria, voltaje);
        } else if (tipo == 2) {
            String color = leerTextoNoVacio(scanner, "Ingrese el color: ");
            double litros = leerDoubleNoNegativo(scanner, "Ingrese la cantidad de litros: ");
            articulo = new ArticuloPintura(codigo, nombre, precio, categoria, color, litros);
        } else if (tipo == 3) {
            String tipoHerramienta = leerTextoNoVacio(scanner, "Ingrese el tipo de herramienta: ");
            articulo = new ArticuloHerramienta(codigo, nombre, precio, categoria, tipoHerramienta);
        } else if (tipo == 4) {
            double pesoKg = leerDoubleNoNegativo(scanner, "Ingrese el peso en kg: ");
            articulo = new ArticuloConstruccion(codigo, nombre, precio, categoria, pesoKg);
        } else if (tipo == 5) {
            String material = leerTextoNoVacio(scanner, "Ingrese el material: ");
            articulo = new ArticuloPlomeria(codigo, nombre, precio, categoria, material);
        }

        articulos.add(articulo);

        System.out.println("Artículo ingresado correctamente.");
        System.out.println("Resumen del objeto creado:");
        System.out.println(articulo);
    }

    public static void listarArticulos(ArrayList<Articulo> articulos) {
        System.out.println("\n--- LISTADO DE ARTÍCULOS ---");

        if (articulos.isEmpty()) {
            System.out.println("No hay artículos cargados.");
            return;
        }

        for (Articulo articulo : articulos) {
            System.out.println(articulo);
        }
    }

    public static void consultarArticulo(Scanner scanner, ArrayList<Articulo> articulos) {
        System.out.println("\n--- CONSULTAR ARTÍCULO ---");

        if (articulos.isEmpty()) {
            System.out.println("No hay artículos cargados.");
            return;
        }

        int codigo = leerEntero(scanner, "Ingrese el código del artículo a consultar: ");

        Articulo articulo = buscarArticuloPorCodigo(articulos, codigo);

        if (articulo == null) {
            System.out.println("El artículo no existe.");
            return;
        }

        System.out.println("Artículo encontrado:");
        System.out.println(articulo);
        System.out.println("Detalle específico: " + articulo.getDetalleEspecifico());
    }

    public static void modificarArticulo(
            Scanner scanner,
            ArrayList<Articulo> articulos,
            ArrayList<Categoria> categorias
    ) {
        System.out.println("\n--- MODIFICAR ARTÍCULO ---");

        if (articulos.isEmpty()) {
            System.out.println("No hay artículos cargados.");
            return;
        }

        int codigo = leerEntero(scanner, "Ingrese el código del artículo a modificar: ");

        Articulo articulo = buscarArticuloPorCodigo(articulos, codigo);

        if (articulo == null) {
            System.out.println("El artículo no existe.");
            return;
        }

        String nuevoNombre = leerTextoNoVacio(scanner, "Ingrese el nuevo nombre del artículo: ");
        double nuevoPrecio = leerDoubleNoNegativo(scanner, "Ingrese el nuevo precio del artículo: ");

        listarCategorias(categorias);
        Categoria nuevaCategoria = pedirCategoriaExistente(scanner, categorias);

        articulo.setNombre(nuevoNombre);
        articulo.setPrecio(nuevoPrecio);
        articulo.setCategoria(nuevaCategoria);

        if (articulo instanceof ArticuloElectricidad) {
            ArticuloElectricidad electricidad = (ArticuloElectricidad) articulo;
            int nuevoVoltaje = leerEnteroNoNegativo(scanner, "Ingrese el nuevo voltaje: ");
            electricidad.setVoltaje(nuevoVoltaje);
        } else if (articulo instanceof ArticuloPintura) {
            ArticuloPintura pintura = (ArticuloPintura) articulo;
            String nuevoColor = leerTextoNoVacio(scanner, "Ingrese el nuevo color: ");
            double nuevosLitros = leerDoubleNoNegativo(scanner, "Ingrese la nueva cantidad de litros: ");
            pintura.setColor(nuevoColor);
            pintura.setLitros(nuevosLitros);
        } else if (articulo instanceof ArticuloHerramienta) {
            ArticuloHerramienta herramienta = (ArticuloHerramienta) articulo;
            String nuevoTipo = leerTextoNoVacio(scanner, "Ingrese el nuevo tipo de herramienta: ");
            herramienta.setTipoHerramienta(nuevoTipo);
        } else if (articulo instanceof ArticuloConstruccion) {
            ArticuloConstruccion construccion = (ArticuloConstruccion) articulo;
            double nuevoPeso = leerDoubleNoNegativo(scanner, "Ingrese el nuevo peso en kg: ");
            construccion.setPesoKg(nuevoPeso);
        } else if (articulo instanceof ArticuloPlomeria) {
            ArticuloPlomeria plomeria = (ArticuloPlomeria) articulo;
            String nuevoMaterial = leerTextoNoVacio(scanner, "Ingrese el nuevo material: ");
            plomeria.setMaterial(nuevoMaterial);
        }

        System.out.println("Artículo modificado correctamente.");
    }

    public static void eliminarArticulo(Scanner scanner, ArrayList<Articulo> articulos) {
        System.out.println("\n--- ELIMINAR ARTÍCULO ---");

        if (articulos.isEmpty()) {
            System.out.println("No hay artículos cargados.");
            return;
        }

        int codigo = leerEntero(scanner, "Ingrese el código del artículo a eliminar: ");

        Articulo articulo = buscarArticuloPorCodigo(articulos, codigo);

        if (articulo == null) {
            System.out.println("El artículo no existe.");
            return;
        }

        articulos.remove(articulo);
        System.out.println("Artículo eliminado correctamente.");
    }

    public static void listarCategorias(ArrayList<Categoria> categorias) {
        System.out.println("\n--- CATEGORÍAS DISPONIBLES ---");

        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }

    public static Categoria pedirCategoriaExistente(Scanner scanner, ArrayList<Categoria> categorias) {
        while (true) {
            int codigoCategoria = leerEntero(scanner, "Ingrese el código de la categoría: ");

            Categoria categoria = buscarCategoriaPorCodigo(categorias, codigoCategoria);

            if (categoria != null) {
                return categoria;
            }

            System.out.println("Error: la categoría no existe.");
        }
    }

    public static Articulo buscarArticuloPorCodigo(ArrayList<Articulo> articulos, int codigo) {
        for (Articulo articulo : articulos) {
            if (articulo.getCodigo() == codigo) {
                return articulo;
            }
        }
        return null;
    }

    public static Categoria buscarCategoriaPorCodigo(ArrayList<Categoria> categorias, int codigo) {
        for (Categoria categoria : categorias) {
            if (categoria.getCodigo() == codigo) {
                return categoria;
            }
        }
        return null;
    }

    public static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero válido.");
            }
        }
    }

    public static int leerEnteroNoNegativo(Scanner scanner, String mensaje) {
        while (true) {
            int valor = leerEntero(scanner, mensaje);

            if (valor < 0) {
                System.out.println("Error: el valor no puede ser negativo.");
                continue;
            }

            return valor;
        }
    }

    public static double leerDoubleNoNegativo(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                double valor = Double.parseDouble(scanner.nextLine());

                if (valor < 0) {
                    System.out.println("Error: el precio no puede ser negativo.");
                    continue;
                }

                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número decimal válido.");
            }
        }
    }

    public static String leerTextoNoVacio(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine();

            if (!texto.trim().isEmpty()) {
                return texto.trim();
            }

            System.out.println("Error: el texto no puede estar vacío.");
        }
    }
}