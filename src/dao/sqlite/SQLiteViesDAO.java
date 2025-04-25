package dao.sqlite;
import dao.interfaces.DAO;
import model.Vies;
import model.Escoles;
import model.Vies;
import view.Vista;

import java.sql.*;
import java.util.Arrays;
import java.util.InputMismatchException;

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
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM vies")) {
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

    public static String llistarTotPerEscola(Connection con,String escola) {
        String fi = "";
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM vies WHERE escola = '" + escola + "' AND estat = 'Apte'")) {
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

    public static String llistarPerRang(Connection con, String grau1, String grau2) {
        String resultat = "";

        String diffBase = "000,4,4+,5,5+,6a,6a+,6b,6b+,6c,6c+,7a,7a+,7b,7b+,7c,7c+,8a,8a+,8b,8b+,8c,8c+,9a,9a+,9b,9b+,9c,9c+";
        String[] difficultats = diffBase.split(",");

        int grauTrobat = 0;
        int grauTrobat2 = 0;

        for (int i = 0; i < difficultats.length; i++) {
            if (difficultats[i].equals(grau1)) grauTrobat = i;
            if (difficultats[i].equals(grau2)) grauTrobat2 = i;
        }

        if (grauTrobat > grauTrobat2 || grauTrobat == 0 || grauTrobat2 == 0){
            throw new InputMismatchException("El grau(s) introduït(s) no es correcte");
        }

        String GrauS = "";

        for (int i = grauTrobat; i <= grauTrobat2;i++){
            if(GrauS.isEmpty()){
                GrauS = "'" + difficultats[i] + "'";
            } else {
                GrauS += ", '" + difficultats[i] + "'";
            }
        }

        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM vies WHERE grau_dificultat IN (" + GrauS + ")")) {
            ResultSet rs = stmt.executeQuery(); // Ejecutar y obtener resultados
            ResultSetMetaData metaData = rs.getMetaData();

            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String nomCol = metaData.getColumnName(i);
                    String nomColumna = nomCol.substring(0, 1).toUpperCase() + nomCol.substring(1).replaceAll("_", " ");
                    resultat += nomColumna + ": " + rs.getString(metaData.getColumnName(i)) + (i < metaData.getColumnCount() ? "\n" : "");
                }
                resultat += "\n";
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al llistar per Grau de Dificultat", e);
        }
        return resultat;
    }

    public static String llistarPerEstat(Connection con,String estat) {
        String fi = "";
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM vies WHERE estat = '" + estat + "'")) {
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
}
