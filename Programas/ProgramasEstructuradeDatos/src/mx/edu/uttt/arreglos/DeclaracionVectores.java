package mx.edu.uttt.arreglos;

import mx.edu.uttt.poo.Alumno;

public class DeclaracionVectores {
    public static void main(String[] args) {
        //Declaracion de vectores

        int v1[];
        double v2[], v3[];
        boolean v4[];
        char[] v5;
        String v6[];
        // Alumno v7[];

        //Crear el vector en Memoria

        v1 = new int[4];
        v2 = new double[3];
        v3 = new double[3];
        v4 = new boolean[4];
        v5 = new char[5];
        v6 = new String[4];
        Alumno[] v7 = new Alumno[3];


        //Declaracion de vector con valores iniciales

        double[] v8 = {3.2, 8.5, 8.9, 7.4};


        int tamaño = v1.length;
        System.out.println(tamaño);

        //Imprimir valor de un arrreglo


        try {
            System.out.println(v3[3]);
        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("El arreglo se desbordo");
        }
        System.out.println(esTamanio(v1));
    }

    public static int esTamanio(int[] vector) {
        return vector.length;
    }
}
