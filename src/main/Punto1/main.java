package Punto1;

import java.time.LocalDate;


public class main {
    public static void main(String[] args) {


        Notificacion mail = new Mail("05383d2a787f02", "31bc3b351ed927");
        mail.notificar("german.beratz@gmail.com", "Helados.com", "Funciona?", "Si funciona");


        String url = "jdbc:mysql://localhost:3306/tp_poo2";
        String usuario = "root";
        String contrasena = "1Wr7!LqS6a^hoH";

        //--------------- Ejemplo usando base de datos
        Guardado guardadoBD = new BaseDeDatos(url, usuario, contrasena);
        Concurso concursoBD = new Concurso(LocalDate.now().minusDays(3), LocalDate.now().plusDays(1), guardadoBD, mail);
        Participante pablo = new Participante("Don", "Pepa", "don.pepa@gmail.com");
        pablo.inscribirse(concursoBD);
        System.out.println(pablo.devolverPuntos());

        //--------------- Ejemplo usando txt
        Guardado guardados = new Documento("pepe");
        Concurso truco = new Concurso(LocalDate.now().minusDays(3), LocalDate.now().plusDays(1), guardados, mail);
        Participante pepe = new Participante("Don", "Pepe", "don.pepe@gmail.com");
        //salen con Id 2 y 3 en el txt por los dos anteriores que se crearon para la bd
        pepe.inscribirse(truco);
        Participante pepa = new Participante("Don", "Pepa", "don.pepa@gmail.com");
        pepa.inscribirse(truco);
        System.out.println(pepe.devolverPuntos());


    }
}

