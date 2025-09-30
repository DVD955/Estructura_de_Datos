package mx.edu.uttt.promedios;

// Clase para representar una calificación
public class calificaciones {
    // Valor de la calificación
    private double calificacion;

    // Constructor vacío
    public calificaciones() {
        // ...
    }

    // Constructor con parámetro
    public calificaciones(double calificacion) {
        this.calificacion = calificacion;
    }

    // Obtener la calificación
    public double getCalificacion() {
        return calificacion;
    }

    // Cambiar la calificación
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    // Mostrar la calificación como texto
    @Override
    public String toString() {
        return "Calificacion: " + getCalificacion();
    }
}
