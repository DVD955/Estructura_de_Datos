package mx.edu.uttt.matrices;

import javax.swing.*;

public class OperacionesMatrices {
    private double [][] m;

    public OperacionesMatrices(int numFilas, int numColumnas){
        if (validarTamanio(numFilas) && validarTamanio(numColumnas)){
            m= new double[numFilas][numColumnas];

        }else{
            m = new double[2][2];
        }
    }

    private boolean validarTamanio(int tamanio){
        return tamanio > 0;
    }

    public double [][] getM(){
        return this.m;
    }
    public void setM(double [][]m){
        if (!(m.length == this.m.length
                &&m[0].length == this.m[0].length))
            for (int i = 0; i <this.m.length; i++){
                for (int j = 0; j < this.m[i].length; j++){
                    this.m[i][j] = m[i][j];

                }
            }
    }

    private boolean validarCuadrada(){
        return this.m.length == this.m[0].length;
    }

    public double SumarDiagonal()throws Exception{
        if(!(validarCuadrada())) throw new Exception("La matriz no es cuadrada");

        int i = 0;
        double suma = 0.0;
        while (i<m.length){
            for(int j = 0; j < m[i].length; j++){
                if (i==j)
                    suma+= m[i][j];
            }
            i++;
        }
        return suma;
    }

    public double sumaDiagonal2()throws Exception{
        if(!(validarCuadrada())) throw new Exception("La matriz no es cuadrada");
        double suma = 0.0;
        for (int i = 0; i <this.m.length; i++){
            suma+=m[i][i];
        }
        return suma;
    }

    public double SumarDiagonalInversa()throws Exception{
        if(!(validarCuadrada())) throw new Exception("La matriz no es cuadrada");
        double suma = 0.0;
        int j = 0;
        for (int i = m.length-1; i<=0; i--){
            suma += m[i][j];
            j++;
        }
        return suma;
    }

    public double sumarDiagonalInversa2()throws Exception{
        if(!(validarCuadrada())) throw new Exception("La matriz no es cuadrada");
        double suma = 0.0;
        int j= m.length-1;
        for (int i = 0; i <m.length; i++){
            suma+=m[i][j-1];
            j--;
        }
        return suma;
    }


    public double SumarDiagonalInversa3()throws Exception{
        if(!(validarCuadrada())) throw new Exception("La matriz no es cuadrada");
        double suma = 0.0;
        int j = 0;
        for (int i = m.length-1; i<=0; i--){
            suma += m[j][i];
            j++;
        }
        return suma;
    }

    public double SumarDiagonalInversa4()throws Exception{
        if(!(validarCuadrada())) throw new Exception("La matriz no es cuadrada");
        double suma = 0.0;

        for (int i = m.length; i >= 0; i--){
            suma+=m[i][m.length-1-i];
        }
        return suma;
    }


    public void imprimir(){
        String salida = "";
        for (double [] fila: this.m){
            for (double valor: fila){
                salida += valor + " | ";

            }
            salida+="\n";
        }
        JOptionPane.showMessageDialog(null, salida);
    }

    public double []sumarFilas(){
        double [] sumarFilas = new double[m.length];
        double suma = 0.0;
        for (int j = 0; j<this.m.length; j++) {
            for (int i = 0; i < this.m.length; i++) {
                suma+= m[i][j];
            }
            sumarFilas[j]=suma;
            suma=0;
        }
        return sumarFilas;
    }

    public double [] sumarColumnas(){
        double [] sumarColumnas = new double[m.length];
        double suma = 0.0;
        for (int i = 0; i<this.m.length; i++) {
            for (int j = 0; j < this.m.length; j++) {
                suma+= m[j][i];
            }
            sumarColumnas[i]=suma;
            suma=0;

        }
        return sumarColumnas;
    }



    private boolean validarMatricesIguales (double [][] m1, double [][] m2){
        return (m1.length == m2.length) && (m1[0].length == m2[0].length);
    }
    private boolean validarMultiplicacion (double [][] m1, double [][] m2){
        return (m1[0].length == m2.length);
    }


    public void imprimirSumaColumnasFilas(double[] fila, double [] columnas) {
        for (int i = 0; i < fila.length; i++) {
            System.out.println( "|" + fila[i] + "|");
        }

        for (int j = 0; j < columnas.length; j++) {
            System.out.print("|" + columnas[j] + "|");
        }
    }

    public double [][] sumarMatrices (double [][] m1, double [][] m2) throws Exception {
        double suma = 0.0;
        double [][] m3 = new double[m1.length][m1[0].length];
        if (validarMatricesIguales(m1, m2)){
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    suma = m1[i][j] + m2[i][j];
                    m3[i][j] = suma;
                }
            }

            return m3;
        }else {
            throw new Exception("Las matrices deben ser del mismo tamaño");
        }

    }

    public double [][] restarMatrices (double [][] m1, double [][] m2) throws Exception {
        double suma = 0.0;
        double [][] m3 = new double[m1.length][m1[0].length];
        if (validarMatricesIguales(m1, m2)){
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    suma = m1[i][j] - m2[i][j];
                    m3[i][j] = suma;
                }
            }
            return m3;
        }else {
            throw new Exception("Las matrices deben ser del mismo tamaño");
        }
    }

    public double [][] multiplicarMatrices (double [][] m1, double [][] m2) throws Exception {
        double [][] m3 =  new double[m1.length][m2[0].length];
        if (validarMultiplicacion(m1, m2)){
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m2[0].length; j++) {
                    for (int k = 0; k < m1[0].length; k++) {
                        m3[i][j] += m1[i][k] * m2[k][j];
                    }
                }
            }
            return m3;
        }else {
            throw new Exception("El numero de columnas de la matriz 1 no son iguales al numero de filas de la matriz 2, no se pueden multiplicar");
        }
    }

    public double [][] calcularTranspuesta (){
        double [][] m3 = new double[m[0].length][m.length];
        for (int i = 0; i< m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m3[j][i] =  m[i][j];
            }
        }
        return m3;
    }



}

