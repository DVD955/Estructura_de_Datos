package mx.edu.uttt.promedios;

import javax.swing.*;

// Clase principal con menú para trabajar con calificaciones
public class testcalificacionesvector {
    public static void main(String[] args) {
        iniciar();
    }

    // Método para mostrar el menú y controlar el flujo
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
                    String mensaje = "Introduce el valor a eliminar";
                    double valorEliminar = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
                    boolean eliminado = eliminarCalificacion(vector, valorEliminar);
                    if (eliminado) {
                        JOptionPane.showMessageDialog(null, "Calificación eliminada");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la calificación");
                    }
                    break;
                case "4":
                    String mensajeMod = "Introduce el valor a modificar";
                    double valorAntiguo = Double.parseDouble(JOptionPane.showInputDialog(mensajeMod));
                    double valorNuevo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el nuevo valor"));
                    boolean modificado = modificarCalificacion(vector, valorAntiguo, valorNuevo);
                    if (modificado) {
                        JOptionPane.showMessageDialog(null, "Calificación modificada correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la calificación o no se modificó nada");
                    }
                    break;
                case "5":
                    double promedio = vector.getPromedio();
                    int cantidadMayores = vector.cantidadMayoresQuePromedio();
                    String msg = "El promedio es: " + String.format("%.2f", promedio) + "\n";
                    msg += "Cantidad de valores mayores que el promedio: " + cantidadMayores + "\n";
                    msg += "Valores mayores que el promedio:\n" + vector.imprimirMayoresQuePromedio();
                    JOptionPane.showMessageDialog(null, msg);
                    break;
                case "6":
                    sentinel = false;
                    JOptionPane.showMessageDialog(null, "Gracias por todo");
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
                "3) Eliminar Calificación \n" +
                "4) Modificar Calificación \n" +
                "5) Calcular promedio y mostrar mayores al promedio \n" +
                "6) Salir \n" +
                "Elegir Opcion: ";
    }

    // Pedir una calificación al usuario
    public static double LlenarCalificacion() {
        return Double.parseDouble(JOptionPane.showInputDialog("Introduce la calificación"));
    }

    // Eliminar una calificación específica
    public static boolean eliminarCalificacion(calificacionesvector vector, double valor) {
        int cantidad = vector.getCantidad();
        for (int i = 0; i < cantidad; i++) {
            if (vector.getCalificacion(i) == valor) {
                vector.eliminarCalificacion(i);
                return true;
            }
        }
        return false;
    }

    // Modificar una calificación específica
    public static boolean modificarCalificacion(calificacionesvector vector, double valorAntiguo, double valorNuevo) {
        int cantidad = vector.getCantidad();
        for (int i = 0; i < cantidad; i++) {
            if (vector.getCalificacion(i) == valorAntiguo) {
                vector.setCalificacion(i, valorNuevo);
                return true;
            }
        }
        return false;
    }
}
