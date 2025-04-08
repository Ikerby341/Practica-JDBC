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
                pstmt.setString(5, ((Escoles) o).getPopularitat()); // Cambia si el tipo de dato es diferente
                pstmt.setString(6, ((Escoles) o).getRestriccions());
                pstmt.executeUpdate();
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
