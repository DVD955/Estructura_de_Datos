package mx.edu.uttt.promedios;


public class calificacionesvector {

    private double[] calificaciones;

    private int TAMANIO = 5;

    private int ac = 0;


    public calificacionesvector() {
        this.calificaciones = new double[this.TAMANIO];
    }


    public calificacionesvector(int tamanio) {
        if (tamanio <= 0)
            this.calificaciones = new double[this.TAMANIO];
        else
            this.calificaciones = new double[tamanio];
    }


    public double getCalificacion(int index) {
        if (index >= 0 && index < ac) {
            return calificaciones[index];
        }
        return -1;
    }


    public void setCalificacion(int index, double valor) {
        if (index >= 0 && index < ac) {
            calificaciones[index] = valor;
        }
    }




    public int getCantidad() {
        return ac;
    }


    public void agregarCalificacion(double calificacion) {
        if (!estaLleno()) {
            this.calificaciones[ac] = calificacion;
            ac = ac + 1;
        } else {
            System.out.println("El vector está lleno");
        }
    }


    public boolean estaLleno() {
        return ac >= calificaciones.length;
    }


    public double getPromedio() {
        if (ac == 0) return 0;
        double suma = 0;
        int i = 0;
        while (i < ac) {
            suma = suma + calificaciones[i];
            i = i + 1;
        }
        return suma / ac;
    }

    public int cantidadMayoresQuePromedio() {
        double promedio = getPromedio();
        int cuenta = 0;
        int i = 0;
        while (i < ac) {
            if (calificaciones[i] > promedio) {
                cuenta = cuenta + 1;
            }
            i = i + 1;
        }
        return cuenta;
    }


    public double[] mayoresQuePromedio() {
        double promedio = getPromedio();
        int cuenta = cantidadMayoresQuePromedio();
        double[] mayores = new double[cuenta];
        int idx = 0;
        int i = 0;
        while (i < ac) {
            if (calificaciones[i] > promedio) {
                mayores[idx] = calificaciones[i];
                idx = idx + 1;
            }
            i = i + 1;
        }
        return mayores;
    }


    public String imprimirMayoresQuePromedio() {
        double[] mayores = mayoresQuePromedio();
        if (mayores.length == 0) return "no hay valores mayor al promedio\n";
        String resultado = "";
        for (int i = 0; i < mayores.length; i++) {
            resultado = resultado + mayores[i] + "\n";
        }
        return resultado;
    }


    public String imprimir() {
        String resultado = "";
        int i = 0;
        while (i < ac) {
            resultado = resultado + "Calificación " + (i + 1) + ": " + calificaciones[i] + "\n";
            i = i + 1;
        }
        return resultado;
    }


}