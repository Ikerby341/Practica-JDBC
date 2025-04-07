package dao.sqlite;
import java.sql.*;
import model.*;
import dao.interfaces.DAO;
import view.Vista;

public class SQLiteEscolesDAO implements DAO {
    public static void crear(Connection con, Object o) {
        if (o instanceof Escoles) {
            try (Statement stmt = con.createStatement()) {
                stmt.executeQuery("INSERT INTO escoles (nom,lloc,aproximacio,num_vies,popularitat,restriccions) VALUES('"
                        + ((Escoles) o).getNom() + "', '"
                        + ((Escoles) o).getLloc() + "', '"
                        + ((Escoles) o).getAproximacio() + "', "
                        + ((Escoles) o).getVies() + ", "
                        + ((Escoles) o).getPopularitat() + ", '"
                        + ((Escoles) o).getRestriccions() + "')");
                Vista.mostrarMissatge("Registro insertado correctamente.");
            } catch (SQLException e) {
                System.err.println("Error al insertar en la base de datos: " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("El objeto proporcionado no es una instancia de Escoles.");
        }
    }

    public static String llistarID(Connection con, String nom) {
        String fi = "";
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM escoles WHERE nom = ?")) {
            stmt.setString(1, nom); // Evitar inyecciones SQL
            ResultSet rs = stmt.executeQuery(); // Ejecutar y obtener resultados

            while (rs.next()) {
                fi += ("Nom: " + rs.getString("nom") +
                        ", Lloc: " + rs.getString("lloc") +
                        ", Aproximacio: " + rs.getString("aproximacio") +
                        ", Vies: " + rs.getInt("vies") +
                        ", Popularitat: " + rs.getString("popularitat") +
                        ", Restriccions: " + rs.getString("restriccions"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar por ID", e);
        }
        return fi;
    }

    public static String llistarTot(Connection con) {
        String fi = "";
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM escoles")) {
            ResultSet rs = stmt.executeQuery(); // Ejecutar y obtener resultados

            while (rs.next()) {
                fi +=("Nom: " + rs.getString("nom") +
                        ", Lloc: " + rs.getString("lloc") +
                        ", Aproximacio: " + rs.getString("aproximacio") +
                        ", Vies: " + rs.getInt("vies") +
                        ", Popularitat: " + rs.getString("popularitat") +
                        ", Restriccions: " + rs.getString("restriccions"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al llistar tot", e);
        }
        return fi;
    }



    public static void actualitzar(Connection con,String Nom, String quequiero, String comoquiero) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("UPDATE escoles SET " + quequiero + " = " + comoquiero + " WHERE nom = " + Nom);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void esborrar(Connection con,String Nom) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("DELETE FROM escoles WHERE nom = " + Nom);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
