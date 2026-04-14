package Punto1;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Documento implements Guardado {
    private String name;

    public Documento(String name) {
        this.name = name;
    }

    @Override
    public void guardar(LocalDate fecha, int id_participante, int id_concurso) {

        try {
            FileWriter fw = new FileWriter(name + ".txt", true); // true = append, no sobreescribe
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaFormateada = fecha.format(formato);

            fw.write(fechaFormateada + ", " + id_participante + ", " + id_concurso + "\n");
            fw.close();
        } catch (IOException e) { //
            e.printStackTrace();
        }
    }

    @Override
    public void guardarMesa(LocalDate date, double monto) {
        try {
            FileWriter fw = new FileWriter(name + ".txt", true);
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaFormateada = date.format(formato);
            fw.write(fechaFormateada + " || " + monto + "\n");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
