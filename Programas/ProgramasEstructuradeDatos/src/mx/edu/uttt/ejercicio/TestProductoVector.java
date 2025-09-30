package mx.edu.uttt.ejercicio;

import javax.swing.*;

public class TestProductoVector {
    public static void main(String[] arg){
        iniciar();
    }

    public static void iniciar() {
        int tamanio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de productos"));

        ProductoVector pv = new ProductoVector(tamanio);

        String opcion = "";
        boolean sentinel = true;

        do {
            opcion = JOptionPane.showInputDialog(menu());

            switch (opcion) {
                case "1":
                    if (!pv.estaLleno())
                        pv.llenarArreglo(LlenarProducto());
                    else
                        JOptionPane.showMessageDialog(null, "El vector está lleno");
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, pv.imprimir());
                    break;
                case "3":
                    String nombre = JOptionPane.showInputDialog("Introduce el nombre del producto a eliminar");
                    boolean eliminado = pv.eliminarp(nombre);
                    if (eliminado) {
                        JOptionPane.showMessageDialog(null, "Producto eliminado ");
                    }
                    break;
                case "4":
                    // Modificar producto interactivo
                    String nombreModificar = JOptionPane.showInputDialog("Introduce el nombre del producto a modificar");
                    boolean modificado = pv.modificarProductoInteractivo(nombreModificar);
                    if (modificado) {
                        JOptionPane.showMessageDialog(null, "Producto modificado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado o no se modificó nada");
                    }
                    break;
                case "5":
                    sentinel = false;
                    JOptionPane.showMessageDialog(null, "Gracias por todo");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (sentinel);
    }

    public static String menu (){
        return "Menu Principal\n"  +
                "1) Agregar Producto \n" +
                "2) Imprimir Productos \n" +
                "3) Eliminar Producto \n" +
                "4) Modificar \n" +
                "5) Salir \n" +
                "Elegir Opcion: ";
    }

    public static Productos LlenarProducto (){
        Productos productos = new Productos();
        String nombre = JOptionPane.showInputDialog("Introduce el nombre del producto");
        int existencia = Integer.parseInt(JOptionPane.showInputDialog("Introduce la existencia"));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio"));

        productos.setNombre(nombre);
        productos.setStock(existencia);
        productos.setPrecio(precio);

        return productos;
    }
}
