package Punto2;

import Punto1.FakeGuardado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarjetaMastercardTest {

    @Test
    public void testMastercard() {
        FakeGuardado registro = new FakeGuardado();
        Mesa mesa = new Mesa(4, registro);
        mesa.ocuparMesa();
        mesa.agregarItem(new Bebida("CocaCola", 1000), 2);   // 2000 bebidas
        mesa.agregarItem(new Plato("Milanesa", 2000), 1);     // 2000 platos
        mesa.confirmarPedido();

        double total = mesa.pagarCuenta(new TarjetaMastercard(), 5);

        /* Calculo:
        Total es 4000
        Descuento Mastercard: 2% de platos (2000 * 0.02 = 40) = 3960
        Propina 5% entonces 3960 * 1.05 = 4158
       */
        assertEquals(4158, total);
    }
}