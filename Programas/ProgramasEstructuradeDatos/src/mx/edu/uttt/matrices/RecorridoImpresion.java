package mx.edu.uttt.matrices;

import javax.swing.*;

public class RecorridoImpresion {
    public static void main(String[] args){
        iniciar();
    }

    public static void iniciar(){
        int [][] matri = new int [solicitarNumeroFilas()][solicitarNumeroColumnas()];
        llenar(matri);
        imprimir(matri);
    }

    public static int solicitarNumeroFilas(){
        boolean sentinel = true;
        int numFilas = 0;
        do {
            try {
                numFilas =
                        Integer.parseInt
                                (JOptionPane.showInputDialog
                                        ("Introduce el nuemro de filas"));
                if (numFilas > 0){
                    sentinel = false;
                }else{
                    JOptionPane.showMessageDialog(null, "El valor debe ser mayor a 0");

                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "El valor debe der un entero");
            }

        }while (sentinel);

        return numFilas;
    }

    public static int solicitarNumeroColumnas(){
        boolean sentinel = true;
        int numColum = 0;
        do {
            try {
                numColum =
                        Integer.parseInt
                                (JOptionPane.showInputDialog
                                        ("Introduce el nuemro de columnas"));
                if (numColum > 0){
                    sentinel = false;
                }else{
                    JOptionPane.showMessageDialog(null, "El valor debe ser mayor a 0");

                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "El valor debe der un entero");
            }

        }while (sentinel);

        return numColum;
    }



    public static int solicitarValor() {
        int valor = 0;
        boolean seninel = true;
        do {

            try {
                valor = Integer.parseInt
                        (JOptionPane.showInputDialog(null,
                                "El valor debe ser un numero"));
                seninel = false;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El valor debe serr un numero");
            }
        } while (seninel);
        return valor;
    }



    public static void llenar(int [][] ma) {
        for (int i = 0; i < ma.length; i++) {
            for (int j = 0; j < ma[i].length; j++) {
                ma[i][j] = solicitarValor();

            }
        }
    }

    public static void imprimir(int [][] matrix){
        int i=0;
        int j=0;
        String salida = "";
        while (i<matrix.length){
            j=0;
            while (j<matrix[i].length){
                salida+= matrix[i][j] + "  ";
                j++;
            }
            salida+="\n";
            i++;
        }
        JOptionPane.showMessageDialog(null, salida);
    }

}