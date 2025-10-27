package mx.edu.uttt.ejercicio;

import javax.swing.*;

// Clase que maneja un arreglo (vector) de objetos Productos
// Contiene operaciones básicas: agregar, eliminar, buscar, modificar e imprimir
public class ProductoVector {
    // Arreglo que almacena los productos
    private Productos[] productos;
    // Tamaño por defecto del arreglo
    private  int TAMANIO = 2;

    // Constructor por defecto: crea el arreglo con el tamaño por defecto
    public ProductoVector() {
        this.productos = new Productos[this.TAMANIO];
    }

    // Constructor con parámetro: crea el arreglo con el tamaño indicado
    public ProductoVector(int tamanio) {
        if (tamanio <= 0)
            this.productos = new Productos[this.TAMANIO];
        else
            this.productos = new Productos[tamanio];
    }

    // Agrega un producto en la primera posición vacía
    // Si el vector está lleno muestra un mensaje
    public void llenarArreglo(Productos productos) {
        if (estaLleno()) {
            JOptionPane.showMessageDialog(null, "El vector está lleno");
        } else {
            this.productos[buscarposicion()] = productos;
        }
    }

    // Busca la primera posición vacía en el arreglo
    // Devuelve el índice o -1 si no hay posiciones vacías
    private int buscarposicion() {
        int posicion = -1;
        for (int i = 0; i < this.productos.length; i++) {
            if (this.productos[i] == null) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    // Elimina (pone null) el producto que coincida por nombre
    // Devuelve true si se eliminó, false si no se encontró
    public boolean eliminarp(String nombre) {
        int indice = buscarIndicePorNombre(nombre);
        if (indice != -1) {
            this.productos[indice] = null;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
            return false;
        }
    }


    // Comprueba si el arreglo está lleno (sin posiciones null)
    public boolean estaLleno() {
        for (Productos productos : this.productos) {
            if (productos == null) {
                return false;
            }
        }
        return true;
    }


    // Devuelve una cadena con la lista de productos y el importe (precio * stock)
    // Si no hay productos devuelve un mensaje indicando que está vacío
    public String imprimir() {
        String salida = "Lista de Productos:\n";
        boolean vacio = true;

        for (int i = 0; i < this.productos.length; i++) {
            if (this.productos[i] != null) {
                vacio = false;
                salida += this.productos[i].toString() + "\n" +
                        "Importe: " + (productos[i].getPrecio() * productos[i].getStock()) + "\n\n";
            }
        }

        if (vacio) {
            salida = "No hay productos registrados.";
        }

        return salida;
    }

    // Busca el índice de un producto por su nombre (ignora mayúsculas)
    // Devuelve el índice o -1 si no se encuentra
    public int buscarIndicePorNombre(String nombre) {
        for (int i = 0; i < this.productos.length; i++) {
            if (this.productos[i] != null && this.productos[i].getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    // Modifica el producto en la posición indicada por un nuevo objeto Productos
    public void modificarProducto(int indice, Productos productoModificado) {
        if (indice >= 0 && indice < this.productos.length) {
            this.productos[indice] = productoModificado;
        }
    }

    // Busca por nombre y permite reemplazar el producto por uno nuevo (interactivo)
    // Devuelve true si se modificó
    public boolean modificarProducto(String nombre) {
        int indice = buscarIndicePorNombre(nombre);
        if (indice != -1) {
            String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre del producto:");
            int nuevoStock = Integer.parseInt(JOptionPane.showInputDialog("Nueva existencia:"));
            double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:"));
            Productos productoModificado = new Productos(nuevoNombre, nuevoStock, nuevoPrecio);
            this.productos[indice] = productoModificado;
            return true;
        }
        return false;
    }

    // Modificar producto con opciones interactivas (nombre, precio o stock)
    // Permite al usuario elegir qué campo cambiar y realiza las validaciones básicas
    public boolean modificarProductoInteractivo(String nombre) {
        int indice = buscarIndicePorNombre(nombre);
        if (indice != -1) {
            Productos producto = this.productos[indice];
            String[] opciones = {"Nombre", "Precio", "Stock", "Cancelar"};
            boolean modificado = false;
            while (true) {
                int seleccion = JOptionPane.showOptionDialog(null, "¿Qué deseas modificar?", "Modificar Producto",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                if (seleccion == 0) { // Nombre
                    String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre del producto:", producto.getNombre());
                    if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
                        producto.setNombre(nuevoNombre);
                        modificado = true;
                    }
                } else if (seleccion == 1) { // Precio
                    String nuevoPrecioStr = JOptionPane.showInputDialog("Nuevo precio:", producto.getPrecio());
                    try {
                        if (nuevoPrecioStr != null && !nuevoPrecioStr.isEmpty()) {
                            double nuevoPrecio = Double.parseDouble(nuevoPrecioStr);
                            producto.setPrecio(nuevoPrecio);
                            modificado = true;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Precio inválido");
                    }
                } else if (seleccion == 2) { // Stock
                    String nuevoStockStr = JOptionPane.showInputDialog("Nueva existencia:", producto.getStock());
                    try {
                        if (nuevoStockStr != null && !nuevoStockStr.isEmpty()) {
                            int nuevoStock = Integer.parseInt(nuevoStockStr);
                            producto.setStock(nuevoStock);
                            modificado = true;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Existencia inválida");
                    }
                } else {
                    break;
                }
            }
            return modificado;
        }
        return false;
    }
}
