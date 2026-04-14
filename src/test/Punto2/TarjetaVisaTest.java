package Punto2;

import Punto1.FakeGuardado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarjetaVisaTest {

    @Test
    public void testVisa() {
        FakeGuardado registro = new FakeGuardado();
        Mesa mesa = new Mesa(4, registro);
        mesa.ocuparMesa();
        mesa.agregarItem(new Bebida("CocaCola", 1000), 2);   // 2000 bebidas
        mesa.agregarItem(new Plato("Milanesa", 2000), 1); // 2000 platos
        mesa.confirmarPedido();

        double total = mesa.pagarCuenta(new TarjetaVisa(), 5);

        /* Calculo:
        Total es 4000
        Descuento Visa: 3% de bebidas (2000 * 0.03 = 60) = 3940
          Propina 5% entonces 3940 * 1.05 = 4137
       */
        assertEquals(4137, total);
    }
}