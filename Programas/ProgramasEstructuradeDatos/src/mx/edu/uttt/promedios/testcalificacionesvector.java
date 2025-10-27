package mx.edu.uttt.promedios;

import javax.swing.*;


public class testcalificacionesvector {
    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar() {
        int tamanio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de calificaciones"));
        calificacionesvector vector = new calificacionesvector(tamanio);
        String opcion = "";
        boolean sentinel = true;
        do {
            opcion = JOptionPane.showInputDialog(menu());
            switch (opcion) {
                case "1":
                    if (!vector.estaLleno())
                        vector.agregarCalificacion(LlenarCalificacion());
                    else
                        JOptionPane.showMessageDialog(null, "El vector está lleno");
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, vector.imprimir());
                    break;

                case "3":
                    double promedio = vector.getPromedio();
                    int cantidadMayores = vector.cantidadMayoresQuePromedio();
                    String msg = "El promedio es: " + String.format("%.2f", promedio) + "\n";
                    msg += "Cantidad de valores mayores que el promedio: " + cantidadMayores + "\n";
                    msg += "Valores mayores que el promedio:\n" + vector.imprimirMayoresQuePromedio();
                    JOptionPane.showMessageDialog(null, msg);
                    break;
                case "4":
                    sentinel = false;
                    JOptionPane.showMessageDialog(null, "ADIOS");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (sentinel);
    }

    // Menú de opciones
    public static String menu() {
        return "Menu Principal\n" +
                "1) Agregar Calificación \n" +
                "2) Imprimir Calificaciones \n" +

                "3) Calcular promedio y mostrar mayores al promedio \n" +
                "4) Salir \n" +
                "Elegir Opcion: ";
    }

    // Pedir una calificación al usuario
    public static double LlenarCalificacion() {
        return Double.parseDouble(JOptionPane.showInputDialog("Introduce la calificación"));
    }




}
