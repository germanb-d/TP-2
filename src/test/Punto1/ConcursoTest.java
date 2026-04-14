package Punto1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConcursoTest {

    @Test
    public void inscripcion() {

        FakeGuardado registro = new FakeGuardado();
        FakeNotificacion mail = new FakeNotificacion();
        Concurso concurso = new Concurso(LocalDate.now().minusDays(3), LocalDate.now().plusDays(3), registro, mail);
        Participante pepe = new Participante("Don", "Pepe", "don.pepe@gmail.com");


        pepe.inscribirse(concurso);


        assertTrue(concurso.estaInscripto(pepe));
        assertEquals(0, pepe.devolverPuntos()); // no es el primer día, no suma puntos
        assertEquals(pepe.id(), registro.getIdParticipante());
        assertEquals(concurso.id(), registro.getIdConcurso());
        //assertEquals(Concuso.get,registro.getFecha());
    }

    @Test
    public void inscripcionInicio() {
        FakeGuardado registro = new FakeGuardado();
        FakeNotificacion mail = new FakeNotificacion();
        Concurso concurso = new Concurso(LocalDate.now(), LocalDate.now().plusDays(3), registro, mail);
        Participante pepe = new Participante("Don", "Pepe", "don.pepe@gmail.com");


        pepe.inscribirse(concurso);


        assertTrue(concurso.estaInscripto(pepe));
        assertEquals(10, pepe.devolverPuntos()); // es el primer día, suma puntos
        assertEquals(pepe.id(), registro.getIdParticipante());
        assertEquals(concurso.id(), registro.getIdConcurso());
    }

}
