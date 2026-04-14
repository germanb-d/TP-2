package Punto2;

public class TarjetaVisa extends TarjetaCredito {

    @Override
    public double descuentoBebidas() {
        return 0.03;
    }

    @Override
    public double descuentoPlatos() {
        return 0.0;
    }

    @Override
    public double descuentoTotal() {
        return 0.0;
    }
}