import clases.Producto;
import filtros.Descartable;
import filtros.Imperecedero;
import filtros.Vendible;
import interfaces.Filtrable;

import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Crear array de productos
        Producto[] productos = new Producto[] {
                new Producto("Producto 1", 50.0, 1),
                new Producto("Producto 2", 25.0, 2),
                new Producto("Producto 3", 150.0, 3),
                new Producto("Descartable 1", 5.0, 4),
                new Producto("Descartable 2", 10.0, 5)
        };
        // Ordenar proudctos precio
        Arrays.sort(productos);

        System.out.println("Array de productos ordenado por precio:");
        for (Producto producto: productos){
            System.out.println(producto);
        };
        System.out.println("\nProductos que cumplen con el filtro 'Vendible':");
        Filtrable vendibleFiltro=new Vendible();
        filtrarProducttos(productos, vendibleFiltro);

        System.out.println("\nProductos que cumplen con el filtro 'Descartable:'");
        Filtrable descartableFiltro = new Descartable();
        filtrarProducttos(productos, descartableFiltro);

        System.out.println("\nProductos que cumplen con el filtro 'Imperecedero'");
        Filtrable imperecedroFiltro= new Imperecedero();
        filtrarProducttos(productos, imperecedroFiltro);
    }

    private static void filtrarProducttos(Producto[] productos, Filtrable filtro) {
        System.out.println("Productos que cumplen con el filtro '"+ filtro.getClass().getSimpleName()+"':");
        for (Producto producto:productos){
            if(filtro.cumpleFiltro(producto)){
                System.out.println(producto);
            }
        }
    }
}