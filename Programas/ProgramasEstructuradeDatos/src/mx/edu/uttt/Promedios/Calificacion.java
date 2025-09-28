package mx.edu.uttt.Promedios;

public class Calificacion {
    private double valor;

    public Calificacion() {
        this.valor = 0.0;
    }

    public Calificacion(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}

