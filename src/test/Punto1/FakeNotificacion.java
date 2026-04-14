package Punto1;

public class FakeNotificacion implements Notificacion {
    private String origen;
    private String destino;
    private String asunto;
    private String contenido;


    @Override
    public void notificar(String origen, String destino, String asunto, String contenido) {
        this.origen = origen;
        this.destino = destino;
        this.asunto = asunto;
        this.contenido = contenido;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getContenido() {
        return contenido;
    }
}
