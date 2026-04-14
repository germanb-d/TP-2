package Punto2;

import Punto1.BaseDeDatos;
import Punto1.Documento;
import Punto1.Guardado;

public class main {
    public static void main(String[] args) {

        //--------------- Ejemplo usando base de datos
        String url = "jdbc:mysql://localhost:3306/tp_poo2";
        String usuario = "root";
        String contrasena = "1Wr7!LqS6a^hoH";
        Guardado registroBD = new BaseDeDatos(url, usuario, contrasena);


        Mesa mesaBD = new Mesa(4, registroBD);
        System.out.println(mesaBD.estaOcupada());
        mesaBD.ocuparMesa();


        Plato plato1 = new Plato("Milanesa", 1500.0);
        Plato plato2 = new Plato("Ensalada", 800.0);
        Bebida bebida1 = new Bebida("Coca Cola", 300.0);
        Bebida bebida2 = new Bebida("Agua", 200.0);

        mesaBD.agregarItem(plato1, 2);
        mesaBD.agregarItem(plato2, 1);
        mesaBD.agregarItem(bebida1, 3);
        mesaBD.agregarItem(bebida2, 1);

        mesaBD.confirmarPedido();
        System.out.println("pedido confirmado en bd");

        TarjetaCredito tarjeta = new TarjetaVisa();
        double total = mesaBD.pagarCuenta(tarjeta, 5);
        System.out.println("total pagado con descuento y propina: " + total);

        mesaBD.liberarMesa();


        //--------------- Ejemplo usando txt
        Guardado registroDoc = new Documento("ventas");

        Mesa mesaDoc = new Mesa(2, registroDoc);
        System.out.println(mesaDoc.estaOcupada());

        mesaDoc.ocuparMesa();

        Plato plato3 = new Plato("Pizza", 1200.0);
        Bebida bebida3 = new Bebida("Jugo", 250.0);

        mesaDoc.agregarItem(plato3, 1);
        mesaDoc.agregarItem(bebida3, 2);

        mesaDoc.confirmarPedido();
        System.out.println("pedido confirmado en txt");

        TarjetaCredito tarjeta2 = new TarjetaMastercard();
        double total2 = mesaDoc.pagarCuenta(tarjeta2, 3);
        System.out.println("total pagado con descuento y propina: " + total2);

        mesaDoc.liberarMesa();
        System.out.println(mesaDoc.estaOcupada());
    }
}
