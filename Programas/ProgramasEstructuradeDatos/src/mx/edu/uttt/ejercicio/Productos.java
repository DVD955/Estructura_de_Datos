package mx.edu.uttt.ejercicio;

import java.util.Scanner;

public class Productos {

    private String nombre;
    private int stock;
    private double precio;


    public Productos() {
        this.nombre = "Sin Nombre";


    }

    public Productos(String nombre, int stock, double precio) {
        this.setNombre(nombre);
        this.setStock(stock);
        this.setPrecio(precio);



    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        if(stock >=0 )
            this.stock = stock;


    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        if (precio>=0.0)
            this.precio = precio;

    }

    @Override
    public String toString() {
        return "\nNombre Producto: " +getNombre() +  "\nStock"+ getStock() +  "\n Precio:" + getPrecio();
    }
}
