package mx.edu.uttt.matrices;

import javax.swing.*;

public class Letras { // Cambié el nombre de la clase un poco

    public static void main(String[] args) {

        // En esta parte definimos la matriz que sera char
        char[][] matriz = {
                {'H', 'O', 'L', 'A','S'},
                {'M', 'U', 'N', 'D', 'O'},
                {'P', 'E', 'R', 'R', 'O'},
                {'G', 'A', 'T', 'O', 'S'},

        };

        String palabra = "";
        boolean valido = false;




        while (valido == false) {
            palabra = JOptionPane.showInputDialog("Ingresa una palabra de hasta 5 letras:");




            if (palabra.length() > 0 && palabra.length() <= 5) {
                valido = true;
            } else {

                JOptionPane.showMessageDialog(null, "Palabra inválida. Intenta de nuevo.");
            }
        }


        boolean encontrada = false; // Bandera para saber si encontramos la palabra

        // 1. Recorremos cada fila de la matriz (cada "palabra" en la matriz)
        for (int i = 0; i < matriz.length; i++) {

            // 2. Primero, comparamos si la palabra del usuario tiene el MISMO tamaño
            //    que la palabra de la matriz en la fila 'i'.
            if (matriz[i].length == palabra.length()) {

                // 3. Si tienen el mismo tamaño, ¡hay que comparar letra por letra!
                //    Vamos a suponer que SÍ son iguales hasta que encontremos una letra diferente.
                boolean sonIguales = true;

                // 4. Recorremos cada letra de la fila 'i'
                for (int j = 0; j < matriz[i].length; j++) {

                    // 5. Comparamos la letra de la matriz con la letra de la palabra del usuario
                    if (matriz[i][j] != palabra.charAt(j)) {
                        // ¡Oh no! Una letra es diferente.
                        sonIguales = false; // Marcamos que no son iguales
                        break; // Dejamos de revisar esta fila, ya sabemos que no es
                    }
                }

                // Después de revisar todas las letras de la fila
                if (sonIguales == true) {
                    // Si la bandera 'sonIguales' sigue en 'true', ¡es porque todas las letras coincidieron!
                    encontrada = true; // ¡Encontramos la palabra!
                    break; // Dejamos de buscar en el resto de la matriz, ya la encontramos
                }
            }
            // Si las longitudes no eran iguales, el 'if' se salta y simplemente
            // continuamos con la siguiente fila (siguiente valor de 'i').
        }

        //  Al final, después de recorrer toda la matriz, revisamos nuestra bandera
        if (encontrada == true) {
            JOptionPane.showMessageDialog(null, "La palabra se encontró en la matriz.");
        } else {
            JOptionPane.showMessageDialog(null, "La palabra NO se encontró en la matriz.");
        }
    }
}