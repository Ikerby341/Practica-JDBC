package dao.sqlite;
import dao.interfaces.DAO;
import model.Vies;
import model.Escoles;
import model.Vies;
import view.Vista;

import java.sql.*;

public class SQLiteViesDAO implements DAO {
    public static void crear(Connection con,Object o) {
        if (o instanceof Vies) {
            String sql = "INSERT INTO vies (tipus_via,nom,llargada,grau_dificultat,orientacio,estat,escola,sector_id,ancoratges,tipus_roca,creador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, ((Vies) o).getTipusVia());
                pstmt.setString(2, ((Vies) o).getNom());
                pstmt.setInt(3, ((Vies) o).getLlargada());
                pstmt.setString(4, ((Vies) o).getGrauDificultat());
                pstmt.setString(5, ((Vies) o).getOrientacio());
                pstmt.setString(6, ((Vies) o).getEstat());
                pstmt.setString(7, ((Vies) o).getEscola());
                pstmt.setInt(8, ((Vies) o).getSectorID());
                pstmt.setString(9, ((Vies) o).getAncoratges());
                pstmt.setString(10, ((Vies) o).getTipusRoca());
                pstmt.setString(11, ((Vies) o).getCreador());
                pstmt.executeUpdate();
                Vista.mostrarMissatge("Registre insertat correctament.");
            } catch (SQLException e) {
                System.err.println("Error al insertar en la base de dades: " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("L'objecte proporcionat no es una instancia d'Vies.");
        }
    }

    public static String llistarID(Connection con,String nom) {
        String fi = "";
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM vies WHERE nom = '" + nom + "'")) {
            ResultSet rs = stmt.executeQuery(); // Ejecutar y obtener resultados
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    fi += metaData.getColumnName(i) + ": " + rs.getString(metaData.getColumnName(i)) + (i < metaData.getColumnCount() ? ", " : "");
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
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM vies")) {
            ResultSet rs = stmt.executeQuery(); // Ejecutar y obtener resultados
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    fi += metaData.getColumnName(i) + ": " + rs.getString(metaData.getColumnName(i)) + (i < metaData.getColumnCount() ? ", " : "");
                }
                fi += "\n";
            }

            if (fi.equals("")) fi = "No hi ha dades";
        } catch (SQLException e) {
            throw new RuntimeException("Error al llistar tot", e);
        }
        return fi;
    }


    public static void actualitzar(Connection con,String id, String quequiero, String comoquiero) {
        try (Statement stmt = con.createStatement()) {
            String sql = "UPDATE vies SET " + quequiero + " = '" + comoquiero + "' WHERE via_id = " + id;
            stmt.executeUpdate(sql); // Usa executeUpdate para consultas de actualización
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualitzar la base de dades", e);
        }
    }


    public static void esborrar(Connection con,String id) {
        try (Statement stmt = con.createStatement()) {
            int rowsAffected = stmt.executeUpdate("DELETE FROM vies WHERE via_id = " + id);
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
