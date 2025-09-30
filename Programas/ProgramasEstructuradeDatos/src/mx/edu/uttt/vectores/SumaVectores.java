package mx.edu.uttt.vectores;

import javax.swing.*;

public class SumaVectores {
    public static void main(String[] args) {
        // Pedir el tamaño de los vectores
        int n = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño de los vectores:"));
        // Declarar los tres vectores
        int[] vectorA = new int[n];
        int[] vectorB = new int[n];
        int[] vectorC = new int[n];
        // Llenar vector A
        for (int i = 0; i < n; i++) {
            vectorA[i] = Integer.parseInt(JOptionPane.showInputDialog("Introduce el elemento " + (i+1) + " del vector A:"));
        }
        // Llenar vector B
        for (int i = 0; i < n; i++) {
            vectorB[i] = Integer.parseInt(JOptionPane.showInputDialog("Introduce el elemento " + (i+1) + " del vector B:"));
        }
        // Sumar A y B, guardar en C
        for (int i = 0; i < n; i++) {
            vectorC[i] = vectorA[i] + vectorB[i];
        }
        // Preparar el resultado para mostrar
        String resultado = "Vector A: ";
        for (int i = 0; i < n; i++) resultado += vectorA[i] + " ";
        resultado += "\nVector B: ";
        for (int i = 0; i < n; i++) resultado += vectorB[i] + " ";
        resultado += "\nVector C (A + B): ";
        for (int i = 0; i < n; i++) resultado += vectorC[i] + " ";
        // Mostrar el resultado final
        JOptionPane.showMessageDialog(null, resultado);
    }
}
