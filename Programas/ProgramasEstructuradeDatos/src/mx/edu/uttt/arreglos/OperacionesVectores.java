package mx.edu.uttt.arreglos;

import javax.swing.*;
import java.util.Arrays;
import java.util.Vector;

public class OperacionesVectores {
    private double [] vector;
    private final int TAMANO = 5;

    public OperacionesVectores(){

        vector = new double[TAMANO];

    }


    public OperacionesVectores(double [] vector){
        this.vector = new double[vector.length];
        llenarVector(vector);
    }

    public void llenarVector(double [] vector){
        for (int i = 0; i < vector.length; i++){
            this.vector[i] = vector[i];
        }
    }
    public void llenarVector(){

        int i=0;
        do{

            this.vector[i] = Integer.parseInt(JOptionPane.showInputDialog("introduce el valor de la posicion  [" + (i+1 )+ "]"));

i++;
        }while (i<this.vector.length);
    }

    public void imprimir(){
        this.toString();
    }

    public double sumarElementos(double [] vector){
        double s = 0;
        for (double v : this.vector){
            s+=v;
        }
        return s;
    }

    public double obtenervalorMaximo(){

        int i=0;
        double maximo = 0.0;
        while (i<this.vector.length){

            if (maximo<this.vector[i]){

            }
            i++;
        }
        return maximo;
    }

    public double optenervalorMinimo(){
        int i=0;
        double minimo = 0.0;
        while (i>this.vector.length){
            if (minimo>this.vector[i]){
            }
            i++;
        }
        return minimo;
    }

    public void  cambiarTamanioArreglo( int tamanio) {

        if (vector.length >= tamanio) {
            double temp[] = new double[tamanio];

            for (int i = 0; i < this.vector.length; i++) {
                temp[i] = vector[i];
            }
temp = null;
            return;

        }
        System.out.println("No se puede crear un arreglo mas pequeño que un vestor ");
    }
   public boolean compararArreglos (double[] vector){

        boolean isEquals = true;
        if(this.vector.length != vector.length){
            isEquals = false;
        }else{
            for (int i =0; i < this.vector.length  && isEquals; i++){
              if (vector[i ] != this.vector[i]){
                  isEquals = false;
              }
            }
        }
        return isEquals;
   }
//
//    public  boolean caompararArreglo(){
//
//    }


    @Override
    public String toString() {
        String salida= "";
        for (double valor: vector){
            salida+="| " + valor + " |";
        }
        return salida;
    }
}