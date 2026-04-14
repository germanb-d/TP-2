package Punto1;

import java.time.LocalDate;


public class FakeGuardado implements Guardado {

    private LocalDate fecha;
    private int idParticipante;
    private int idConcurso;

    @Override
    public void guardar(LocalDate fecha, int id_participante, int id_concurso) {
        this.fecha = fecha;
        this.idParticipante = id_participante;
        this.idConcurso = id_concurso;
    }

    @Override
    public void guardarMesa(LocalDate date, double monto) {
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public int getIdConcurso() {
        return idConcurso;
    }
}

