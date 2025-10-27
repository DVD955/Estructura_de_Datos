package mx.edu.uttt.recursividad;

import javax.swing.*;

public class MetodosRecursivos {
    public static void main(String[] args) {

        try {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Introduce n"));
            JOptionPane.showMessageDialog(null, "El factorial de: " + n
                    + "es: " + fact(n));
        }catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }



    }

    public static long fact(int n) throws IllegalArgumentException{

        if (n < 0) {

            throw new
                    IllegalArgumentException("El valor no puede ser negativo");
        }
        if (n == 1) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        return n * fact(n-1);
    }
}