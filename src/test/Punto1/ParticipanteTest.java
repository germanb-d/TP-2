package Punto1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParticipanteTest {
    @Test
    public void inscripcionFueraDeRango() {
        FakeGuardado registro = new FakeGuardado();
        FakeNotificacion mail = new FakeNotificacion();
        Concurso concurso = new Concurso(LocalDate.now().minusDays(10), LocalDate.now().minusDays(2), registro, mail);
        Participante pepe = new Participante("Don", "Pepe", "don.pepe@gmail.com");


        assertThrows(RuntimeException.class, () -> {
            pepe.inscribirse(concurso);
        });
    }
}
