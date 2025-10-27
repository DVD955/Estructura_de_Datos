package mx.edu.uttt.matrices;

import javax.swing.JOptionPane;

public class Examen1 {

    public static void main(String[] args) {

        int[][] datos = new int[10][3]; // 10 personas y 3 datos por persona

        // === LLENAR LA MATRIZ CON DATOS ALEATORIOS ===
        for (int i = 0; i < 10; i++) {
            datos[i][0] = (int) (Math.random() * 2) + 1; // 1 = hombre, 2 = mujer
            datos[i][1] = (int) (Math.random() * 2) + 1; // 1 = trabaja, 2 = no trabaja

            if (datos[i][1] == 1) {
                datos[i][2] = (int) (Math.random() * 1401) + 600; // sueldo entre 600 y 2000
            } else {
                datos[i][2] = 0; // si no trabaja, sueldo = 0
            }
        }

        // === MOSTRAR MATRIZ DE DATOS ===
        String salida = "N° | Sexo | Trabaja | Sueldo\n";
        salida += "-----------------------------\n";

        for (int i = 0; i < 10; i++) {
            salida += (i + 1) + "   |   " + datos[i][0] + "   |   " + datos[i][1] + "   |   " + datos[i][2] + "\n";
        }

        JOptionPane.showMessageDialog(null, salida);

        // === VECTORES PARA RESULTADOS ===
        int[] conteo = new int[4];      // [0]=hombres, [1]=mujeres, [2]=hombresTrabajan, [3]=mujeresTrabajan
        int[] sumaSueldos = new int[2]; // [0]=hombres, [1]=mujeres
        double[] promedios = new double[2]; // [0]=hombres, [1]=mujeres

        // === RECORRER MATRIZ Y CONTAR ===
        for (int i = 0; i < 10; i++) {
            if (datos[i][0] == 1) { // Hombre
                conteo[0]++;
                if (datos[i][1] == 1) {
                    conteo[2]++;
                    sumaSueldos[0] += datos[i][2];
                }
            } else { // Mujer
                conteo[1]++;
                if (datos[i][1] == 1) {
                    conteo[3]++;
                    sumaSueldos[1] += datos[i][2];
                }
            }
        }

        // === CALCULAR PROMEDIOS ===
        if (conteo[2] > 0) {
            promedios[0] = (double) sumaSueldos[0] / conteo[2];
        }
        if (conteo[3] > 0) {
            promedios[1] = (double) sumaSueldos[1] / conteo[3];
        }

        // === CALCULAR PORCENTAJES ===
        double porcHombres = (conteo[0] * 100.0) / 10;
        double porcMujeres = (conteo[1] * 100.0) / 10;
        double porcHombresTrabajan = (conteo[2] * 100.0) / 10;
        double porcMujeresTrabajan = (conteo[3] * 100.0) / 10;

        // === MOSTRAR RESULTADOS ===
        String resultados = "RESULTADOS\n";
        resultados += "Porcentaje de hombres: " + porcHombres + "%\n";
        resultados += "Porcentaje de mujeres: " + porcMujeres + "%\n";
        resultados += "Porcentaje de hombres que trabajan: " + porcHombresTrabajan + "%\n";
        resultados += "Porcentaje de mujeres que trabajan: " + porcMujeresTrabajan + "%\n";
        resultados += "Sueldo promedio de hombres que trabajan: " + promedios[0] + "\n";
        resultados += "Sueldo promedio de mujeres que trabajan: " + promedios[1] + "\n";

        JOptionPane.showMessageDialog(null, resultados);
    }
}
