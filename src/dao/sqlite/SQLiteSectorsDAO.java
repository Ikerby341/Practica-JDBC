package dao.sqlite;
import dao.DBConnection;
import dao.interfaces.DAO;
import model.*;
import view.Vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteSectorsDAO implements DAO {

    public static void crear(Connection con,Object o) {
        if (o instanceof Sectors) {
            String sql = "INSERT INTO escoles (nom, latitud, longitud, aproximacio, num_vies, popularitat, restriccions) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, ((Sectors) o).getNom());
                pstmt.setString(2, ((Sectors) o).getLatitud());
                pstmt.setLong(3, ((Sectors) o).getLongitud());
                pstmt.setString(4, ((Sectors) o).getAproximacio());
                pstmt.setInt(5, ((Sectors) o).getNumVies());
                pstmt.setString(6, ((Sectors) o).getPopularitat());
                pstmt.setString(7, ((Sectors) o).getRestriccions());
                pstmt.executeUpdate();
                Vista.mostrarMissatge("Registre insertat correctament.");
            } catch (SQLException e) {
                System.err.println("Error al insertar en la base de dades: " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("L'objecte proporcionat no es una instancia d'Escaladors.");
        }
    }


    public static void actualitzar(Connection con,String id, String quequiero, String comoquiero) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("UPDATE escoles SET " + quequiero + " = " + comoquiero + " WHERE sector_id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static String llistarID(Connection con, String id) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("SELECT * FROM escoles WHERE sector_id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }


    public static String  llistarTot(Connection con) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("SELECT * FROM sectors");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }


    public static void esborrar(Connection con,String id) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("DELETE FROM escoles WHERE sector_id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
