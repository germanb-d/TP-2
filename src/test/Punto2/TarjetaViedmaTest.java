package Punto2;


import Punto1.FakeGuardado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarjetaViedmaTest {

    @Test
    public void testViedma() { // no se porque sale este error
        FakeGuardado registro = new FakeGuardado();
        Mesa mesa = new Mesa(4, registro);
        mesa.ocuparMesa();
        mesa.agregarItem(new Bebida("CocaCola", 1000), 2);   // 2000 bebidas
        mesa.agregarItem(new Plato("Milanesa", 2000), 1);     // 2000 platos
        mesa.confirmarPedido();

        double total = mesa.pagarCuenta(new TarjetaViedma(), 5);

        /* Calculo:
        Total es 4000
        Sin descuento
        Propina 5% entonces 4000 * 1.05 = 4200
       */
        assertEquals(4200, total);
    }
}