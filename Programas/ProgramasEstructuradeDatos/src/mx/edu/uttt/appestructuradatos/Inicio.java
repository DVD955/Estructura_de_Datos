package mx.edu.uttt.appestructuradatos;

import javax.swing.*;

public class Inicio {
    public static void main(String[] args) {
        iniciar();

    }

    public static void iniciar() {
        String opcion = "";
        boolean sentinel = true;
        do {
            opcion = JOptionPane.showInputDialog(Menus.obtenerMenuPrincipal());

            switch (opcion) {
                case "1":
                    JOptionPane.showMessageDialog(null, "Opcion 1");
                    break;

                case "2":
                    JOptionPane.showMessageDialog(null, "Opcion 2");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Opcion 3");
                    break;

                case "4":
                    JOptionPane.showMessageDialog(null, "Opcion 4");
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Opcion 5");
                    break;

                case "6":
                    JOptionPane.showMessageDialog(null, "Opcion 6");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Valor No Valido");
            }

            }   while (sentinel) ;





    }
}


