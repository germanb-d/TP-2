package Punto1;

import java.time.LocalDate;

public interface Guardado {

    void guardar(LocalDate fecha, int id_participante, int id_concurso);

    void guardarMesa(LocalDate date, double monto);
}

