package dao.sqlite;
import java.sql.*;
import model.*;
import dao.interfaces.DAO;
import view.Vista;

public class SQLiteEscolesDAO implements DAO {
    public static void crear(Connection con, Object o) {
        if (o instanceof Escoles) {
            String sql = "INSERT INTO escoles (nom, lloc, aproximacio, num_vies, popularitat, restriccions) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, ((Escoles) o).getNom());
                pstmt.setString(2, ((Escoles) o).getLloc());
                pstmt.setString(3, ((Escoles) o).getAproximacio());
                pstmt.setInt(4, ((Escoles) o).getVies());
                pstmt.setString(5, ((Escoles) o).getPopularitat());
                pstmt.setString(6, ((Escoles) o).getRestriccions());
                pstmt.executeUpdate();
                Vista.mostrarMissatge("Registre insertat correctament.");
            } catch (SQLException e) {
                System.err.println("Error al insertar en la base de dades: " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("L'objecte proporcionat no es una instancia d'Escoles.");
        }
    }


    public static String llistarID(Connection con, String nom) {
        String fi = "";
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM escoles WHERE nom = '" + nom + "'")) {
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
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM escoles")) {
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



    public static void actualitzar(Connection con, String Nom, String quequiero, String comoquiero) {
        try (Statement stmt = con.createStatement()) {
            String sql = "UPDATE escoles SET " + quequiero + " = '" + comoquiero + "' WHERE nom = '" + Nom + "'";
            stmt.executeUpdate(sql); // Usa executeUpdate para consultas de actualización
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualitzar la base de dades", e);
        }
    }



    public static void esborrar(Connection con, String Nom) {
        try (Statement stmt = con.createStatement()) {
            int rowsAffected = stmt.executeUpdate("DELETE FROM escoles WHERE nom = '" + Nom + "'");
            if (rowsAffected > 0) {
                System.out.println("La tabla ha sigut eliminada amb éxit.");
            } else {
                System.out.println("No s'ha trobat cap fila amb el nom especificat.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la taula", e);
        }
    }

}
