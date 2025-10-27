package mx.edu.uttt.promedios;


public class calificaciones {

    private double calificacion;


    public calificaciones() {

    }


    public calificaciones(double calificacion) {
        this.calificacion = calificacion;
    }


    public double getCalificacion() {
        return calificacion;
    }


    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }


    @Override
    public String toString() {
        return "Calificacion: " + getCalificacion();
    }
}
