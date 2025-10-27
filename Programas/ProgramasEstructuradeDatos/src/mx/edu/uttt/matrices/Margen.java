package mx.edu.uttt.matrices;

import javax.swing.*;

public class Margen {

    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar() {
        int filas = rellenarF();
        int columnas = rellenarC();
        int[][] matriz = new int[filas][columnas];

        llenarMatriz(matriz);
        mostrarMatriz(matriz);
        laterales(matriz);
        mostrarMatriz(matriz);
    }

    public static void laterales(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i == 0 || j == 0 || i == m.length - 1 || j == m[i].length - 1) {
                    m[i][j] = 1;
                }
            }
        }
    }

    public static void mostrarMatriz(int[][] m) {
        StringBuilder mensaje = new StringBuilder();
        for (int[] fila : m) {
            for (int valor : fila) {
                mensaje.append(valor).append(" | ");
            }
            mensaje.append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    public static void llenarMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    public static int rellenarF() {
        int filas = 0;
        boolean valido = false;

        do {
            try {
                filas = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de filas:"));
                if (filas > 0) {
                    valido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "El número de filas debe ser mayor que cero.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un número válido para las filas.");
            }
        } while (!valido);

        return filas;
    }

    public static int rellenarC() {
        int columnas = 0;
        boolean valido = false;

        do {
            try {
                columnas = Integer.parseInt(JOptionPane.showInputDialog(" Ingresa el número de columnas:"));
                if (columnas > 0) {
                    valido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "El número de columnas debe ser mayor que cero.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un número válido para las columnas.");
            }
        } while (!valido);

        return columnas;
    }
}
