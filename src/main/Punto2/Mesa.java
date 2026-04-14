package Punto2;

import Punto1.Guardado;

import java.time.LocalDate;

public class Mesa {
    private int capacidad;
    private Pedido pedido;
    private boolean ocupada;
    private Guardado registro;

    public Mesa(int capacidad, Guardado registro) {
        if (capacidad <= 0) {
            throw new RuntimeException("La capacidad debe ser mayor a 0");
        }
        this.capacidad = capacidad;
        this.ocupada = false; //cuando creas la mesa no hay personas ni pedidos q realizar
        this.pedido = null;
        this.registro = registro;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public void ocuparMesa() {
        if (ocupada) {
            throw new RuntimeException("La mesa ya esta ocupada");
        }
        ocupada = true;
        pedido = new Pedido();
    }

    /*
    No verifico la capacidad (osea cuando comensales se sientan) porque creo que la capacidad es un dato informativo
    , mas q una restrictivo. Creo q seria engorroso imaginar q cada vez q moves la cantidad de sillas por mesa debieras
    modificar la cantidad aca, y ademas no se especifica en el enunciado que se deba controlar eso.
    */
    public void liberarMesa() {
        if (!ocupada) {
            throw new RuntimeException("La mesa ya esta libre");
        }
        ocupada = false;
        pedido = null;
    }

    public void agregarItem(Alimento alimento, int cantidad) {
        if (!ocupada) {
            throw new RuntimeException("La mesa no esta ocupada");
        }
        pedido.agregarItem(alimento, cantidad);
    }

    public void confirmarPedido() {
        if (!ocupada) {
            throw new RuntimeException("La mesa no esta ocupada");
        }
        pedido.confirmarPedido();
    }


    public double pagarCuenta(TarjetaCredito tarjeta, int propina) {
        if (!pedido.estaConfirmado()) {
            throw new RuntimeException("El pedido debe estar confirmado antes de pagar");
        }
        if (!validarPropina(propina)) {
            throw new RuntimeException("La propina debe ser 2%, 3% o 5%");
        }

        double total = pedido.obtenerTotal();
        total -= pedido.obtenerPreciosBebidas() * tarjeta.descuentoBebidas();
        total -= pedido.obtenerPreciosPlatos() * tarjeta.descuentoPlatos();
        total -= total * tarjeta.descuentoTotal();

        total = total + (total * propina / 100.00); // lo divido porque es 2,3 y 5. Y quiero que sea 0.02, 0.03 o 0.05

        registro.guardarMesa(LocalDate.now(), total);

        return total;
    }

    private boolean validarPropina(int porcentaje) { //deberia de hacer la propina otra clase o esta bien asi?
        return porcentaje == 2 || porcentaje == 3 || porcentaje == 5;
    }
}