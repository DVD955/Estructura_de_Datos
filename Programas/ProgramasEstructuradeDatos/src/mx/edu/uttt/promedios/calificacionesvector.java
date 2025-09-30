package mx.edu.uttt.promedios;

// Clase para manejar un arreglo de calificaciones
public class calificacionesvector {
    // Arreglo para guardar las calificaciones
    private double[] calificaciones;
    // Tamaño máximo
    private int TAMANIO = 5;
    // Acumulador de elementos
    private int ac = 0;

    // Constructor por defecto
    public calificacionesvector() {
        this.calificaciones = new double[this.TAMANIO];
    }

    // Constructor con tamaño personalizado
    public calificacionesvector(int tamanio) {
        if (tamanio <= 0)
            this.calificaciones = new double[this.TAMANIO];
        else
            this.calificaciones = new double[tamanio];
    }

    // Agregar una calificación
    public void agregarCalificacion(double calificacion) {
        if (!estaLleno()) {
            this.calificaciones[ac] = calificacion;
            ac = ac + 1;
        } else {
            System.out.println("El vector está lleno");
        }
    }

    // Verificar si el vector está lleno
    public boolean estaLleno() {
        return ac >= calificaciones.length;
    }

    // Calcular el promedio
    public double calcularPromedio() {
        if (ac == 0) return 0;
        double suma = 0;
        int i = 0;
        while (i < ac) {
            suma = suma + calificaciones[i];
            i = i + 1;
        }
        return suma / ac;
    }

    // Contar cuántas calificaciones son mayores al promedio
    public int cantidadMayoresQuePromedio() {
        double promedio = calcularPromedio();
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

    // Obtener arreglo de calificaciones mayores al promedio
    public double[] mayoresQuePromedio() {
        double promedio = calcularPromedio();
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

    // Mostrar calificaciones mayores al promedio como texto
    public String imprimirMayoresQuePromedio() {
        double[] mayores = mayoresQuePromedio();
        if (mayores.length == 0) return "no hay valores mayor al promedio\n";
        String resultado = "";
        for (int i = 0; i < mayores.length; i++) {
            resultado = resultado + mayores[i] + "\n";
        }
        return resultado;
    }

    // Mostrar todas las calificaciones
    public String imprimir() {
        String resultado = "";
        int i = 0;
        while (i < ac) {
            resultado = resultado + "Calificación " + (i + 1) + ": " + calificaciones[i] + "\n";
            i = i + 1;
        }
        return resultado;
    }

    // Obtener cantidad de calificaciones
    public int getCantidad() {
        return ac;
    }

    // Obtener el promedio
    public double getPromedio() {
        return calcularPromedio();
    }

    // Obtener todas las calificaciones como arreglo de double
    public double[] obtenerCalificaciones() {
        double[] resultado = new double[ac];
        for (int i = 0; i < ac; i++) {
            resultado[i] = calificaciones[i];
        }
        return resultado;
    }

    // Permite actualizar el acumulador después de eliminar una calificación
    public void setCantidad(int nuevaCantidad) {
        this.ac = nuevaCantidad;
    }

    // Método para obtener una calificación por índice
    public double getCalificacion(int index) {
        if (index >= 0 && index < ac) {
            return calificaciones[index];
        }
        throw new IndexOutOfBoundsException("Índice fuera de rango");
    }

    // Método para establecer una calificación en un índice específico
    public void setCalificacion(int index, double valor) {
        if (index >= 0 && index < ac) {
            calificaciones[index] = valor;
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }

    // Método para eliminar una calificación por índice
    public void eliminarCalificacion(int index) {
        if (index >= 0 && index < ac) {
            for (int i = index; i < ac - 1; i++) {
                calificaciones[i] = calificaciones[i + 1];
            }
            calificaciones[ac - 1] = 0; // Limpiar el último elemento
            ac--;
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }

    // Método para obtener el tamaño máximo del arreglo
    public int getTamanio() {
        return calificaciones.length;
    }
}
