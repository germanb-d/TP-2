package Punto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class BaseDeDatos implements Guardado {
    private String url;
    private String usuario;
    private String contrasena;

    public BaseDeDatos(String url, String usuario, String contrasena) {
        this.url = url;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public void guardar(LocalDate fecha, int id_participante, int id_concurso) {
        String sql = "INSERT INTO inscripciones (fecha, id_participante, id_concurso) VALUES (?, ?, ?)";
        try {
            Connection con = DriverManager.getConnection(url, usuario, contrasena);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fecha));
            ps.setInt(2, id_participante);
            ps.setInt(3, id_concurso);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void guardarMesa(LocalDate fecha, double monto) {
        String sql = "INSERT INTO ventas (fecha, monto) VALUES (?, ?)";
        try {
            Connection con = DriverManager.getConnection(url, usuario, contrasena);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fecha));
            ps.setDouble(2, monto);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}