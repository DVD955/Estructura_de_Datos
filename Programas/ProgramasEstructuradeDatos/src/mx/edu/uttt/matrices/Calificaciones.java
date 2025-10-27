package mx.edu.uttt.matrices;

import javax.swing.JOptionPane;

public class Calificaciones {

    public static void main(String[] args) {
        iniciar();


    }



    public static void iniciar() {

        int filas = 3;
        int columnas = 3;
        double[][] calificaciones = new double[filas][columnas];
        double [][] matrizAleatoria = new double[filas][columnas];
        String opcion = "";
        boolean sentinel = true;

        do {
            opcion = JOptionPane.showInputDialog(
                    "Menú Principal:\n" +
                            "1. Llenar matriz manualmente\n" +
                            "2. Llenar matriz aleatoriamente\n" +
                            "3. Mostrar matriz y promedios\n" +
                            "4. Mostrar matriz aleatoria\n" +
                            "0. Salir"
            );

            switch (opcion) {
                case "1":
                    llenarMatriz(calificaciones);
                    break;

                case "2":
                    llenarCalif(calificaciones);
                    break;

                case "3":
                    imprimir(calificaciones);
                    break;
                case "4":
                    llenarCalif(matrizAleatoria);
                    imprimirMA(matrizAleatoria);
                    break;

                case "0":
                    JOptionPane.showMessageDialog(null, "FIN");
                    sentinel = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }

        } while (sentinel);
    }


    public static void llenarMatriz(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                boolean sentinel = false;

                do {
                    try {
                        String input = JOptionPane.showInputDialog("Ingresa el valor para [" + i + "][" + j + "]");
                        Double valor = Double.parseDouble(input);
                        matrix[i][j] = valor;
                        sentinel = true;


                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "El valor debe ser un número válido.");
                    }

                } while (!sentinel);

            }
        }

    }

    public static void imprimir(double[][] matrix) {
        double[] promAlumnos = promedioAlumno(matrix);
        double[] promMaterias = promedioMaterias(matrix);
        String salida = "";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                salida += matrix[i][j] + "  ";
            }
            salida += "| " + promAlumnos[i] + "\n";
        }

        salida += "\n";
        for (int j = 0; j < promMaterias.length; j++) {
            salida += promMaterias[j] + "  ";
        }

        JOptionPane.showMessageDialog(null, salida);
    }


    public static double[] promedioAlumno(double[][] matrix) {
        double[] promediosA = new double[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            double suma = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                suma += matrix[i][j];
            }
            promediosA[i] = suma / matrix[i].length;
        }
        return promediosA;


    }
    public static double[] promedioMaterias(double[][] matrix) {

        double[] promediosM = new double[matrix[0].length];

        for (int j = 0; j < matrix[0].length; j++) {
            double suma = 0;
            for (int i = 0; i < matrix.length; i++) {
                suma += matrix[i][j];
            }
            promediosM[j] = suma / matrix.length;
        }
        return promediosM;

    }

    public static void llenarCalif(double[][] matrixx) {
        for (int i = 0; i < matrixx.length; i++) {
            for (int j = 0; j < matrixx[i].length; j++) {
                matrixx[i][j] = Math.round(Math.random() * 10.0 * 10.0) / 10.0;


            }
        }
    }





    public  static  void  imprimirMA(double [][] matrixx) {
        String salida = "";
        for (int i = 0; i < matrixx.length; i++) {
            for (int j = 0; j < matrixx[i].length; j++) {
                salida += matrixx[i][j] + "  ";
            }
            salida += "\n";
        }
        JOptionPane.showMessageDialog(null, salida);
    }
}



