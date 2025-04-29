package dao.sqlite;

import model.Trams;
import view.Vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteTramsDAO {
    public static void crear(Connection con, Object o) {
        if (o instanceof Trams) {
            String sql = "INSERT INTO trams (via,llargada,grau_dificultat) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, ((Trams) o).getVia());
                pstmt.setInt(2, ((Trams) o).getLlargada());
                pstmt.setString(3, ((Trams) o).getGrauDificultat());
                pstmt.executeUpdate();
                Vista.mostrarMissatge("Tram insertat correctament.");
            } catch (SQLException e) {
                System.err.println("Error al insertar tram en la base de dades: " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("L'objecte proporcionat no es una instancia d'Vies.");
        }
    }
}