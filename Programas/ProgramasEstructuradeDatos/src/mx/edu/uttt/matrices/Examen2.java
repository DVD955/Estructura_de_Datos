package mx.edu.uttt.matrices;

import javax.swing.JOptionPane;

public class Examen2 {

    public static void main(String[] args) {
        iniciar();


    }

    public static void iniciar() {
        int Estudiantes  = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de estudiantes:"));
        int examenes = 5;

        double [][] calificaciones = new double [Estudiantes][examenes];
        double [] promediosEstudiantes = new double [Estudiantes];
        double [] promediosExamenes = new double [examenes];
        llenarMatrizAleatoria(calificaciones);

        calcularPromediosEs(calificaciones, promediosEstudiantes);
        calcularPromediosEx(calificaciones, promediosExamenes);

        int EstudianteMejorCal3ex = tercerExamen(calificaciones);
        double mayorCal1ex = mayorExamen(calificaciones, 0);
        double mayorCal5ex = mayorExamen(calificaciones , 4);
        int cantidadEstudiantesMayor1y5 = contarEstudiantesMayor1y5(calificaciones, mayorCal1ex, mayorCal5ex);
        int examenMayorPromedio = examenConMayorPromedio(promediosExamenes);

        String salida = "Calificaciones:\n";
        salida += "Est | Ex1  | Ex2  | Ex3  | Ex4  | Ex5\n";
        salida += "--------------------------------------\n";
        for (int i = 0; i < calificaciones.length; i++) {
            salida += String.format("%3d |", i + 1);
            for (int j = 0; j < calificaciones[i].length; j++) {
                salida += String.format(" %4.1f |", calificaciones[i][j]);
            }
            salida += "\n";
        }

        salida += "\nPromedio de cada Estudiante:\n";
        for (int i = 0; i < promediosEstudiantes.length; i++) {
            salida += String.format("Estudiante %d: %.2f\n", i + 1, promediosEstudiantes[i]);
        }

        salida += "\nPromedio por Examen:\n";
        for (int j = 0; j < promediosExamenes.length; j++) {
            salida += String.format("Examen %d: %.2f\n", j + 1, promediosEstudiantes[j]);
        }

        salida += "\nMejor calificación en el 3er examen es el Estudiante " + EstudianteMejorCal3ex;
        salida += "\nLa mayor calificación examen 1: " + mayorCal1ex;
        salida += "\nLa mayor calificación examen 5: " + mayorCal5ex;
        salida += "\nCantidad de estudiantes con máximas calificaciones en 1° y 5° examen: " + cantidadEstudiantesMayor1y5;
        salida += "\nExamen con mayor promedio: Examen " + examenMayorPromedio;

        JOptionPane.showMessageDialog(null, salida);
    }
    public static void llenarMatrizAleatoria(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = Math.round(Math.random() * 100) / 10.0; // 0.0 a 10.0
            }
        }
    }
    public static void calcularPromediosEs(double[][] m, double[] promedios) {
        for (int i = 0; i < m.length; i++) {
            double suma = 0;
            for (int j = 0; j < m[i].length; j++) {
                suma += m[i][j];
            }
            promedios[i] = suma / m[i].length;
        }
    }

    public static void calcularPromediosEx(double[][] m, double[] promedios) {
        for (int j = 0; j < m[0].length; j++) {
            double suma = 0;
            for (int i = 0; i < m.length; i++) {
                suma += m[i][j];
            }
            promedios[j] = suma / m.length;
        }
    }

    public static int tercerExamen(double[][] m) {
        int estudianteMejor = 0;
        double mejorCalificacion = -1;
        for (int i = 0; i < m.length; i++) {
            if (m[i][2] > mejorCalificacion) {
                mejorCalificacion = m[i][2];
                estudianteMejor = i + 1; // +1 para ajustar al número de estudiante
            }
        }
        return estudianteMejor;
    }
    public static double mayorExamen(double[][] m, int examen) {
        double mayor = m[0][examen];
        for (int i = 1; i < m.length; i++) {
            if (m[i][examen] > mayor) mayor = m[i][examen];
        }
        return mayor;
    }
    public static int contarEstudiantesMayor1y5(double[][] m, double mayor1, double mayor5) {
        int contador = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] == mayor1 && m[i][4] == mayor5) contador++;
        }
        return contador;
    }

        public static int examenConMayorPromedio(double[] promedioExamen) {
            double mayor = promedioExamen[0];
            int examenMayor = 1;
            for (int j = 1; j < promedioExamen.length; j++) {
                if (promedioExamen[j] > mayor) {
                    mayor = promedioExamen[j];
                    examenMayor = j + 1;
                }
            }
            return examenMayor;

        }
    }

