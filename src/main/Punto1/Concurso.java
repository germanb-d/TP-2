package Punto1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
    public static final String ASUNTO = "Inscripcion";
    public static final String CONTENIDO = "Se a incripto con exito al concurso";
    private ArrayList<Participante> inscriptos;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Guardado registro;
    private static int contadorId = 0;
    private int id;
    private Notificacion notificacion;

    public Concurso(LocalDate fechaInicio, LocalDate fechaFin, Guardado registro, Notificacion notificacion) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.inscriptos = new ArrayList<>();
        this.registro = registro;
        contadorId++;
        this.id = contadorId; //Buscar despues como usar UUID
        this.notificacion = notificacion;
    }

    public void inscribirParticipante(Participante p) {
        //validarParticipante(p); seria mejor esto en participante porque es quien se conoce a si mismo? si solo valido null
        if (LocalDate.now().isEqual(fechaInicio)) p.sumarPuntos(10);
        inscriptos.add(p);
        registro.guardar(LocalDate.now(), p.id(), this.id);
        //mail.mandarMail("concurso@gmail.com", p.getMail(), ASUNTO, CONTENIDO);
    }

    public boolean estaAbiertaInscripcion() {
        return !LocalDate.now().isBefore(fechaInicio) && !LocalDate.now().isAfter(fechaFin);
    }

    public boolean estaInscripto(Participante p) { // para al hacer el test validar que este el participante
        return inscriptos.contains(p);
    }

    private void validarParticipante(Participante p) {
        // Completar
    }

    public int id() {
        return id;
    }
}
