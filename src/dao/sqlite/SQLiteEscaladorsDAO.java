package dao.sqlite;
import model.*;
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
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualitzar la base de dades", e);
        }
    }


    public static String llistarID(Connection con,String nom) {
        String fi = "";
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM escaladors WHERE nom = '" + nom + "'")) {
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String nomCol = metaData.getColumnName(i);
                String nomColumna = nomCol.substring(0, 1).toUpperCase() + nomCol.substring(1).replaceAll("_", " ");
                if (i == 4 || i == 5 || i == 6){
                    fi += String.format("%-10s", nomColumna);
                } else if (i == 1) {
                    fi += String.format("%-15s", nomColumna);
                } else if (i == 8) {
                    fi += String.format("%-80s", nomColumna);
                } else {
                    fi += String.format("%-25s", nomColumna);
                }
            }
            fi += "\n";

            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    if (i == 4 || i == 5 || i == 6) {
                        fi += String.format("%-10s", rs.getString(i));
                    } else if (i == 1) {
                        fi += String.format("%-15s", rs.getString(i));
                    } else if (i == 8) {
                        fi += String.format("%-80s", rs.getString(i));
                    } else {
                        fi += String.format("%-25s", rs.getString(i));
                    }
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
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String nomCol = metaData.getColumnName(i);
                String nomColumna = nomCol.substring(0, 1).toUpperCase() + nomCol.substring(1).replaceAll("_", " ");
                if (i == 4 || i == 5 || i == 6){
                    fi += String.format("%-10s", nomColumna);
                } else if (i == 1) {
                    fi += String.format("%-15s", nomColumna);
                } else if (i == 8) {
                    fi += String.format("%-80s", nomColumna);
                } else {
                    fi += String.format("%-25s", nomColumna);
                }
            }
            fi += "\n";

            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    if (i == 4 || i == 5 || i == 6) {
                        fi += String.format("%-10s", rs.getString(i));
                    } else if (i == 1) {
                        fi += String.format("%-15s", rs.getString(i));
                    } else if (i == 8) {
                        fi += String.format("%-80s", rs.getString(i));
                    } else {
                        fi += String.format("%-25s", rs.getString(i));
                    }
                }
                fi += "\n";
            }

            if (fi.isEmpty()) fi = "No hi ha dades";
        } catch (SQLException e) {
            throw new RuntimeException("Error al llistar tot", e);
        }
        return fi;
    }


    public static void esborrar(Connection con,String nom) {
        try (Statement stmt = con.createStatement()) {
            int rowsAffected = stmt.executeUpdate("DELETE FROM escaladors WHERE nom = '" + nom + "'");
            if (rowsAffected > 0) {
                System.out.println("L'escalador ha sigut eliminat amb éxit.");
            } else {
                System.out.println("No s'ha trobat cap fila amb el id especificat.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la taula", e);
        }
    }

    public static String llistarNivellMaxEscaladors(Connection con, String nivell) {
        String fi = "";
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM escaladors WHERE nivell = '" + nivell + "'")) {
            ResultSet rs = stmt.executeQuery(); // Ejecutar y obtener resultados
            ResultSetMetaData metaData = rs.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String nomCol = metaData.getColumnName(i);
                String nomColumna = nomCol.substring(0, 1).toUpperCase() + nomCol.substring(1).replaceAll("_", " ");
                if (i == 4 || i == 5 || i == 6){
                    fi += String.format("%-10s", nomColumna);
                } else if (i == 1) {
                    fi += String.format("%-15s", nomColumna);
                } else if (i == 8) {
                    fi += String.format("%-80s", nomColumna);
                } else {
                    fi += String.format("%-25s", nomColumna);
                }
            }
            fi += "\n";

            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    if (i == 4 || i == 5 || i == 6) {
                        fi += String.format("%-10s", rs.getString(i));
                    } else if (i == 1) {
                        fi += String.format("%-15s", rs.getString(i));
                    } else if (i == 8) {
                        fi += String.format("%-80s", rs.getString(i));
                    } else {
                        fi += String.format("%-25s", rs.getString(i));
                    }
                }
                fi += "\n";
            }

            if (fi.isEmpty()) fi = "No hi ha dades";
        } catch (SQLException e) {
            throw new RuntimeException("Error al mostrar escaladors amb el mateix nivell indicat", e);
        }
        return fi;
    }
}
