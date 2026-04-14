package Punto2;

public class ItemPedido {
    private Alimento alimento;
    private int cantidad;

    public ItemPedido(Alimento alimento, int cantidad) {
        if (alimento == null) {
            throw new RuntimeException("El alimento no puede ser nulo");
        }
        if (cantidad <= 0) {
            throw new RuntimeException("La cantidad debe ser mayor a 0");
        }
        this.alimento = alimento;
        this.cantidad = cantidad;
    }

    public double subtotalBebidas() {
        return alimento.devolverPrecioBebida() * cantidad;
    }

    public double subtotalAlimentos() {
        return alimento.devolverPrecioAlimento() * cantidad;
    }
}