package Punto1;

import java.util.Objects;

public class Participante {
    private String name;
    private String lastName;
    private String mail;
    private int puntos;
    private static int contadorId = 0;
    private int id;


    public Participante(String name, String lastName, String mail) {
        this.name = name;
        this.lastName = lastName;
        puntos = 0;
        contadorId++;
        this.id = contadorId;
        this.mail = mail;
    }

    public void sumarPuntos(int puntos) {
        verificarPuntos(puntos);
        this.puntos += puntos;
    }
/*
    public void restarPuntos(int puntos) {
        verificarPuntos(puntos);
        this.puntos -= puntos;
    }
*/

    public int devolverPuntos() {
        return this.puntos;
    }

    public void inscribirse(Concurso c) { //deberia agregar una fecha para pasar
        if (c.estaAbiertaInscripcion())
            c.inscribirParticipante(this);
        else throw new RuntimeException("La inscripción está cerrada");
    }

    private void verificarPuntos(int puntos) {
        if (puntos <= 0) {
            throw new IllegalArgumentException("No se puede operar con puntos negativos");
        }
    }

    public int id() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
