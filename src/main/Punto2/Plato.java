package Punto2;

public class Plato extends Alimento {

    public Plato(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double devolverPrecioAlimento() {
        return precio();
    }
}
