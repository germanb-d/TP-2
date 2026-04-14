package Punto2;

public abstract class Alimento {
    private String nombre;
    private double precio;

    public Alimento(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String nombre() {
        return nombre;
    }

    public double precio() {
        return precio;
    }

    // Por defecto devuelve 0 para no preguntar el tipo con instanceof
    public double devolverPrecioBebida() {
        return 0;
    }

    // Por defecto devuelve 0 para no preguntar el tipo con instanceof
    public double devolverPrecioAlimento() {
        return 0;
    }
}