package Punto2;

public class Bebida extends Alimento {

    public Bebida(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double devolverPrecioBebida() {
        return precio();
    }
}
