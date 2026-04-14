package Punto2;

public class TarjetaComarcaPlus extends TarjetaCredito {

    @Override
    public double descuentoBebidas() {
        return 0.0;
    }

    @Override
    public double descuentoPlatos() {
        return 0.0;
    }

    @Override
    public double descuentoTotal() {
        return 0.02;
    }
}