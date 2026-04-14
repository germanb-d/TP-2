package Punto2;

public abstract class TarjetaCredito {
    //antes los descuentos se realizaban el la tarjeta, ahora solo devuelve el porcentaje de descuento
    public abstract double descuentoBebidas();

    public abstract double descuentoPlatos();

    public abstract double descuentoTotal();
}