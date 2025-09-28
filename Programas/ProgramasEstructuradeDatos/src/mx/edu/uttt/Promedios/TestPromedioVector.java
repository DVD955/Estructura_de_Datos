package mx.edu.uttt.Promedios;

import javax.swing.*;


public class TestPromedioVector {

    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos valores deseas ingresar?"));
        PromedioVector pv = new PromedioVector(n);
        pv.llenar();
        double promedio = pv.calcularPromedio();
        int mayores = pv.contarMayores(promedio);
        String listaMayores = pv.listarMayores(promedio);

        StringBuilder resultado = new StringBuilder();
        resultado.append("Promedio: ").append(promedio).append("\n");
        resultado.append("Cantidad de valores mayores al promedio: ").append(mayores).append("\n");
        resultado.append("Lista de valores mayores al promedio:\n");
        resultado.append(listaMayores);

        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}
