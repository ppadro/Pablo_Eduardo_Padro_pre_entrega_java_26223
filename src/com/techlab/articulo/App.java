package com.techlab.articulo;

import java.util.ArrayList;
import java.util.Scanner;

import com.techlab.articulo.model.Categoria;
import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.Herramienta;
import com.techlab.articulo.model.MaterialConstruccion;
import com.techlab.articulo.model.Pintura;
import com.techlab.articulo.model.Electricidad;
import com.techlab.articulo.model.Plomeria;

public class App {

    private static ArrayList<Articulo> articulos = new ArrayList<>();
    private static ArrayList<Categoria> categorias = new ArrayList<>();

    public static void main(String[] args) {

        cargarCategorias();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("===========================================================");
            System.out.println(" SISTEMA DE ARTÍCULOS - MODELO COMPLETO");
            System.out.println("===========================================================");
            System.out.println("1 - Ingresar artículo");
            System.out.println("2 - Listar artículos");
            System.out.println("3 - Consultar un artículo");
            System.out.println("4 - Modificar un artículo");
            System.out.println("5 - Eliminar un artículo");
            System.out.println("6 - Listar categorías");
            System.out.println("0 - Salir");
            System.out.println("===========================================================");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    ingresarArticulo(scanner);
                    break;
                case 2:
                    listarArticulos();
                    break;
                case 3:
                    consultarArticulo(scanner);
                    break;
                case 4:
                    modificarArticulo(scanner);
                    break;
                case 5:
                    eliminarArticulo(scanner);
                    break;
                case 6:
                    listarCategorias();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    // ============================================================
    // INGRESAR ARTÍCULO (MODELO COMPLETO)
    // ============================================================

    private static void ingresarArticulo(Scanner scanner) {

        System.out.println("\n--- INGRESAR ARTÍCULO ---");

        // Primero pedimos el código
        System.out.print("Ingrese código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("1 - Herramienta");
        System.out.println("2 - Material de construcción");
        System.out.println("3 - Pintura");
        System.out.println("4 - Electricidad");
        System.out.println("5 - Plomería");
        System.out.print("Seleccione el tipo de artículo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        // Pedimos nombre y precio (comunes)
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        // Pedimos categoría ANTES de crear el objeto
        System.out.println("\nCategorías disponibles:");
        for (Categoria c : categorias) {
            System.out.println(c.getCodigo() + " - " + c.getNombre() + " (" + c.getDescripcion() + ")");
        }

        System.out.print("Ingrese el código de categoría: ");
        int codCat = scanner.nextInt();
        scanner.nextLine();

        Categoria categoriaSeleccionada = null;
        for (Categoria c : categorias) {
            if (c.getCodigo() == codCat) {
                categoriaSeleccionada = c;
                break;
            }
        }

        if (categoriaSeleccionada == null) {
            System.out.println("Categoría inválida.");
            return;
        }

        Articulo nuevo = null;

        switch (tipo) {
            case 1:
                System.out.print("Ingrese marca: ");
                String marca = scanner.nextLine();
                nuevo = new Herramienta(codigo, nombre, precio, categoriaSeleccionada, marca);
                break;

            case 2:
                System.out.print("Ingrese tipo de material: ");
                String tipoMat = scanner.nextLine();
                nuevo = new MaterialConstruccion(codigo, nombre, precio, categoriaSeleccionada, tipoMat);
                break;

            case 3:
                System.out.print("Ingrese color: ");
                String color = scanner.nextLine();

                System.out.print("Ingrese litros: ");
                double litros = scanner.nextDouble();
                scanner.nextLine();

                nuevo = new Pintura(codigo, nombre, precio, categoriaSeleccionada, color, litros);
                break;

            case 4:
                System.out.print("Ingrese voltaje: ");
                String voltaje = scanner.nextLine();
                nuevo = new Electricidad(codigo, nombre, precio, categoriaSeleccionada, voltaje);
                break;

            case 5:
                System.out.print("Ingrese material: ");
                String material = scanner.nextLine();
                nuevo = new Plomeria(codigo, nombre, precio, categoriaSeleccionada, material);
                break;

            default:
                System.out.println("Tipo inválido.");
                return;
        }

        articulos.add(nuevo);
        System.out.println("\nArtículo ingresado correctamente.");
    }

    // ============================================================
    // LISTAR ARTÍCULOS
    // ============================================================

    private static void listarArticulos() {
        System.out.println("\n--- LISTA DE ARTÍCULOS ---");

        if (articulos.isEmpty()) {
            System.out.println("No hay artículos cargados.");
            return;
        }

        for (Articulo a : articulos) {
            System.out.println(a);
        }
    }

    // ============================================================
    // CONSULTAR ARTÍCULO
    // ============================================================

    private static void consultarArticulo(Scanner scanner) {
        System.out.print("Ingrese nombre del artículo a consultar: ");
        String nombre = scanner.nextLine();

        for (Articulo a : articulos) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(a);
                return;
            }
        }

        System.out.println("Artículo no encontrado.");
    }

    // ============================================================
    // MODIFICAR ARTÍCULO
    // ============================================================

    private static void modificarArticulo(Scanner scanner) {
        System.out.print("Ingrese nombre del artículo a modificar: ");
        String nombre = scanner.nextLine();

        for (Articulo a : articulos) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {

                System.out.print("Nuevo precio: ");
                double nuevoPrecio = scanner.nextDouble();
                scanner.nextLine();

                a.setPrecio(nuevoPrecio);

                System.out.println("Artículo modificado.");
                return;
            }
        }

        System.out.println("Artículo no encontrado.");
    }

    // ============================================================
    // ELIMINAR ARTÍCULO
    // ============================================================

    private static void eliminarArticulo(Scanner scanner) {
        System.out.print("Ingrese nombre del artículo a eliminar: ");
        String nombre = scanner.nextLine();

        for (Articulo a : articulos) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                articulos.remove(a);
                System.out.println("Artículo eliminado.");
                return;
            }
        }

        System.out.println("Artículo no encontrado.");
    }

    // ============================================================
    // LISTAR CATEGORÍAS
    // ============================================================

    private static void listarCategorias() {
        System.out.println("\n--- CATEGORÍAS ---");
        for (Categoria c : categorias) {
            System.out.println(c);
        }
    }

    // ============================================================
    // CARGA INICIAL DE CATEGORÍAS
    // ============================================================

    private static void cargarCategorias() {
        categorias.add(new Categoria(1, "Herramientas", "Herramientas manuales y eléctricas"));
        categorias.add(new Categoria(2, "Construcción", "Materiales de obra"));
        categorias.add(new Categoria(3, "Pintura", "Pinturas y accesorios"));
        categorias.add(new Categoria(4, "Electricidad", "Cables, tomas y disyuntores"));
        categorias.add(new Categoria(5, "Plomería", "Caños y griferías"));
    }
}
