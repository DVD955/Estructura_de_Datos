package mx.edu.uttt.matrices;

import javax.swing.*;

public class TestOperacionesMatrices {
    public static void main(String[] args) {
        iniciar();
    }
    public static void  iniciar(){

        int filas= obtenerTamanio();
        int columnas = obtenerTamanio();
        OperacionesMatrices oper = new OperacionesMatrices(filas,columnas);
        double [][] m = new double[filas][columnas];
        llenarMatriz(m);
        oper.setM(m);
        oper.imprimir();
        try {
            JOptionPane.showInputDialog(null, oper.sumaDiagonal2());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public  static int obtenerTamanio(){
        int valor = 0;
        boolean setinel = true;


        do{

            try{
                valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrea el valor de :"))  ;

                if(valor>0){
                    setinel = false;

                }else{
                    JOptionPane.showMessageDialog(null, "El valor debe de ser mayor a 0");
                }

            }catch (NumberFormatException ex){
                System.out.println("El valor debe de ser un numero");

            }
        }while(setinel);
        return  valor;
    }

    public static  void llenarMatriz(double[][] matrix){
        int i = 0 , j = 0;
        boolean setinel = false;
        do{
            do{

                do {
                    try{
                        matrix[i][j] = Double.parseDouble(JOptionPane.showInputDialog("Ingresa  el tamanio"));
                        setinel = false;

                    }catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "El valor debe de ser un numero");


                    }

                }while(setinel);

                j++;
            }while (j<matrix[i].length);
            j=0;
            i++;

        }while (i<matrix.length);
    }

    public static void sumarMatrices(){



    }

}