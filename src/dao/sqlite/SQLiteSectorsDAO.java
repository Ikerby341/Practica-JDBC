package dao.sqlite;
import dao.interfaces.DAO;
import model.*;
import view.Vista;
import java.sql.*;

public class SQLiteSectorsDAO implements DAO {

    public static void crear(Connection con,Object o) {
        if (o instanceof Sectors) {
            String sql = "INSERT INTO sectors (nom, latitud, longitud, aproximacio, num_vies, popularitat, restriccions) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
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
            String sql = "UPDATE sectors SET " + quequiero + " = '" + comoquiero + "' WHERE sector_id = " + id;
            stmt.executeUpdate(sql); // Usa executeUpdate para consultas de actualización
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualitzar la base de dades", e);
        }
    }


    public static String llistarID(Connection con, String nom) {
        String fi = "";
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM sectors WHERE nom = '" + nom + "'")) {
            ResultSet rs = stmt.executeQuery(); // Ejecutar y obtener resultados
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String nomCol = metaData.getColumnName(i);
                String nomColumna = nomCol.substring(0, 1).toUpperCase() + nomCol.substring(1).replaceAll("_", " ");
                fi += String.format("%-25s", nomColumna);
            }
            fi += "\n";

            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    fi += String.format("%-25s", rs.getString(i));
                }
                fi += "\n";
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al llistar per nom", e);
        }
        return fi;
    }


    public static String  llistarTot(Connection con) {
        String fi = "";
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM sectors")) {
            ResultSet rs = stmt.executeQuery(); // Ejecutar y obtener resultados
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String nomCol = metaData.getColumnName(i);
                String nomColumna = nomCol.substring(0, 1).toUpperCase() + nomCol.substring(1).replaceAll("_", " ");
                fi += String.format("%-25s", nomColumna);
            }
            fi += "\n";

            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    fi += String.format("%-25s", rs.getString(i));
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
            int rowsAffected = stmt.executeUpdate("DELETE FROM sectors WHERE sector_id = " + id);
            if (rowsAffected > 0) {
                System.out.println("La tabla ha sigut eliminada amb éxit.");
            } else {
                System.out.println("No s'ha trobat cap fila amb el id especificat.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la taula", e);
        }
    }

    public static String llistarAmbNumVies(Connection con, int numV) {
        String fi = "";
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM sectors s WHERE (SELECT COUNT(*) FROM vies v WHERE v.sector_id = s.sector_id AND v.estat = 'Apte') >=" + numV)) {
            ResultSet rs = stmt.executeQuery(); // Ejecutar y obtener resultados
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String nomCol = metaData.getColumnName(i);
                String nomColumna = nomCol.substring(0, 1).toUpperCase() + nomCol.substring(1).replaceAll("_", " ");
                fi += String.format("%-25s", nomColumna);
            }
            fi += "\n";

            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    fi += String.format("%-25s", rs.getString(i));
                }
                fi += "\n";
            }

            if (fi.equals("")) fi = "No hi ha dades";
        } catch (SQLException e) {
            throw new RuntimeException("Error al llistar tot", e);
        }
        return fi;
    }

}
