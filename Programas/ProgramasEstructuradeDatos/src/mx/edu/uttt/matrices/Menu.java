package mx.edu.uttt.matrices;

import javax.swing.JOptionPane;

public class Menu {

    public static void main(String[] args) {
        mostrarMenu();
    }
    public static void mostrarMenu() {
        int opcion;
        do {
            String menu = "---- MENU PRINCIPAL ----\n"
                    + "1. Diagonal\n"
                    + "2. Margen\n"
                    + "3. Salir\n\n"
                    + "Selecciona una opción:";
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (opcion) {
                    case 1:
                        Diagonal.main(null);
                        break;
                    case 2:
                        Margen.main(null);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Sal del programa");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida. Intenta de nuevo.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un número válido.");
                opcion = -1;
            }

        } while (opcion != 3);
    }
}
