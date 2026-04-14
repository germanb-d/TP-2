package Punto2;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> consumos;
    private boolean confirmado;
    // antes lo manejaba con un arraylist de alimentos pero no me permitia cumplir con la cantidad:
    // "seleccionando platos y bebidas del menú, más la cantidad para cada caso"

    public Pedido() {
        this.consumos = new ArrayList<>();
        this.confirmado = false;
    }

    public void agregarItem(Alimento alimento, int cantidad) {
        if (confirmado) {
            throw new RuntimeException("El pedido ya fue confirmado y no puede modificarse");
        }
        consumos.add(new ItemPedido(alimento, cantidad));
    }

    public void confirmarPedido() {
        confirmado = true;
    }

    public boolean estaConfirmado() {
        return confirmado;
    }

    public double obtenerPreciosBebidas() {
        double precio = 0;
        for (ItemPedido item : consumos) {
            precio += item.subtotalBebidas();
        }
        return precio;
    }

    public double obtenerPreciosPlatos() {
        double precio = 0;
        for (ItemPedido item : consumos) {
            precio += item.subtotalAlimentos();
        }
        return precio;
    }

    public double obtenerTotal() {
        return obtenerPreciosBebidas() + obtenerPreciosPlatos();
    }
}