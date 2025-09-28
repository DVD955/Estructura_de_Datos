package mx.edu.uttt.Promedios;

import javax.swing.*;

public class PromedioVector {
    private Calificacion[] calificaciones;

    public PromedioVector(int n) {
        this.calificaciones = new Calificacion[n];
    }

    public void llenar() {
        for (int i = 0; i < calificaciones.length; i++) {
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Introduce el valor " + (i + 1) + ":"));
            calificaciones[i] = new Calificacion(valor);
        }
    }

    public double calcularPromedio() {
        double suma = 0;
        for (Calificacion c : calificaciones) {
            suma += c.getValor();
        }
        return suma / calificaciones.length;
    }

    public int contarMayores(double promedio) {
        int contador = 0;
        for (Calificacion c : calificaciones) {
            if (c.getValor() > promedio) {
                contador++;
            }
        }
        return contador;
    }

    public String listarMayores(double promedio) {
        StringBuilder lista = new StringBuilder();
        for (Calificacion c : calificaciones) {
            if (c.getValor() > promedio) {
                lista.append(c.getValor()).append("\n");
            }
        }
        return lista.length() > 0 ? lista.toString() : "Ninguno\n";
    }
}

