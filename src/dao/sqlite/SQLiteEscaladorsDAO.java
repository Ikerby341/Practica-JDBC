package dao.sqlite;
import model.*;
import dao.DBConnection;
import dao.interfaces.DAO;
import view.Vista;

import java.sql.*;

public class SQLiteEscaladorsDAO implements DAO {

    public static void crear(Connection con,Object o) {
        if (o instanceof Escaladors) {
            String sql = "INSERT INTO escaladors (nom, alies, edat, nivell, via_id, estil_preferit, historial, fita) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, ((Escaladors) o).getNom());
                pstmt.setString(2, ((Escaladors) o).getAlies());
                pstmt.setInt(3, ((Escaladors) o).getEdat());
                pstmt.setString(4, ((Escaladors) o).getNivell());
                pstmt.setInt(5, ((Escaladors) o).getId_via());
                pstmt.setString(6, ((Escaladors) o).getEstil_pref());
                pstmt.setString(7, ((Escaladors) o).getHistorial());
                pstmt.setString(8, ((Escaladors) o).getFita());
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
            String sql = "UPDATE escaladors SET " + quequiero + " = '" + comoquiero + "' WHERE escalador_id = " + id;
            stmt.executeUpdate(sql); // Usa executeUpdate para consultas de actualización
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualitzar la base de dades", e);
        }
    }


    public static String llistarID(Connection con,String nom) {
        String fi = "";
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM escaladors WHERE nom = '" + nom + "'")) {
            ResultSet rs = stmt.executeQuery(); // Ejecutar y obtener resultados
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String nomCol = metaData.getColumnName(i);
                    String nomColumna = nomCol.substring(0, 1).toUpperCase() + nomCol.substring(1).replaceAll("_", " ");
                    fi += nomColumna + ": " + rs.getString(metaData.getColumnName(i)) + (i < metaData.getColumnCount() ? "\n" : "");
                }
                fi += "\n";
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al llistar per nom", e);
        }
        return fi;
    }


    public static String llistarTot(Connection con) {
        String fi = "";
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM escaladors")) {
            ResultSet rs = stmt.executeQuery(); // Ejecutar y obtener resultados
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String nomCol = metaData.getColumnName(i);
                    String nomColumna = nomCol.substring(0, 1).toUpperCase() + nomCol.substring(1).replaceAll("_", " ");
                    fi += nomColumna + ": " + rs.getString(metaData.getColumnName(i)) + (i < metaData.getColumnCount() ? "\n" : "");
                }
                fi += "\n";
            }

            if (fi.equals("")) fi = "No hi ha dades";
        } catch (SQLException e) {
            throw new RuntimeException("Error al llistar tot", e);
        }
        return fi;
    }


    public static void esborrar(Connection con,String id) {
        try (Statement stmt = con.createStatement()) {
            int rowsAffected = stmt.executeUpdate("DELETE FROM escaladors WHERE escalador_id = " + id);
            if (rowsAffected > 0) {
                System.out.println("La tabla ha sigut eliminada amb éxit.");
            } else {
                System.out.println("No s'ha trobat cap fila amb el id especificat.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la taula", e);
        }
    }
}
