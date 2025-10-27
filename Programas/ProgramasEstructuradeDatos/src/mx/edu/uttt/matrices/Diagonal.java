package mx.edu.uttt.matrices;

import javax.swing.*;

public class Diagonal {
    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar() {
        int filas = pedirF();
        int columnas = pedirC();
        int matriz[][] = new int[filas][columnas];

        llenarMatriz(matriz);
        mostrarMatriz(matriz);

        int sumaArriba = sumaArribaD(matriz);
        int sumaAbajo = sumaAbajoD(matriz);

        JOptionPane.showMessageDialog(null,
                "Suma de elementos arriba de la diagonal: " + sumaArriba + "\n" +
                        "Suma de elementos abajo de la diagonal: " + sumaAbajo
        );
    }

    public static int sumaArribaD(int m[][]) {
        int suma = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = i + 1; j < m[i].length; j++) { // j > i
                suma += m[i][j];
            }
        }
        return suma;
    }


    public static int sumaAbajoD(int m[][]) {
        int suma = 0;
        for (int i = 1; i < m.length; i++) {
            for (int j = 0; j < Math.min(i, m[i].length); j++) { // j < i
                suma += m[i][j];
            }
        }
        return suma;
    }


    public static void mostrarMatriz(int m[][]) {
        String salida = "";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                salida += m[i][j] + " | ";
            }
            salida += "\n";
        }
        JOptionPane.showMessageDialog(null, salida);
    }


    public static void llenarMatriz(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = (int) (Math.round(Math.random() * 10));
            }
        }
    }


    public static int pedirF() {
        int valor = 0;
        boolean sentinel = true;
        do {
            try {
                valor = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de filas:"));
                if (valor > 0) {
                    sentinel = false;
                } else {
                    JOptionPane.showMessageDialog(null, "El valor debe ser mayor que cero");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingresa un número válido");
            }
        } while (sentinel);
        return valor;
    }


    public static int pedirC() {
        int valor = 0;
        boolean sentinel = true;
        do {
            try {
                valor = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de columnas:"));
                if (valor > 0) {
                    sentinel = false;
                } else {
                    JOptionPane.showMessageDialog(null, "El valor debe ser mayor que cero");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingresa un número válido");
            }
        } while (sentinel);
        return valor;
    }
}
