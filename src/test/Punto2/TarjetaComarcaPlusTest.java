package Punto2;

import Punto1.FakeGuardado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarjetaComarcaPlusTest {

    @Test
    public void testComarcaPlus() {
        FakeGuardado registro = new FakeGuardado();
        Mesa mesa = new Mesa(4, registro);
        mesa.ocuparMesa();
        mesa.agregarItem(new Bebida("CocaCola", 1000), 2);   // 2000 bebidas
        mesa.agregarItem(new Plato("Milanesa", 2000), 1);     // 2000 platos
        mesa.confirmarPedido(); // buscar como hacer esto con el BeforeEach


        double total = mesa.pagarCuenta(new TarjetaComarcaPlus(), 5);

        /* Calculo:
        Total es 4000
        Descuento Comarca: 2% total (4000 * 0.02 = 80) = 3920
        Propina 5% entonces 3920 * 1.05 = 4116
       */
        assertEquals(4116, total);
    }
}