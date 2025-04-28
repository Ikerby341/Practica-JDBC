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
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String nomCol = metaData.getColumnName(i);
                String nomColumna = nomCol.substring(0, 1).toUpperCase() + nomCol.substring(1).replaceAll("_", " ");
                if (i == 3){
                    fi += String.format("%-65s", nomColumna);
                } else if (i == 4 || i == 5) {
                    fi += String.format("%-15s", nomColumna);
                } else {
                    fi += String.format("%-25s", nomColumna);
                }

            }
            fi += "\n";

            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    if (i == 3){
                        fi += String.format("%-65s", rs.getString(i));
                    } else if (i == 4 || i == 5) {
                        fi += String.format("%-15s", rs.getString(i));
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
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM escoles")) {
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String nomCol = metaData.getColumnName(i);
                String nomColumna = nomCol.substring(0, 1).toUpperCase() + nomCol.substring(1).replaceAll("_", " ");
                if (i == 3){
                    fi += String.format("%-65s", nomColumna);
                } else if (i == 4 || i == 5) {
                    fi += String.format("%-15s", nomColumna);
                } else {
                    fi += String.format("%-25s", nomColumna);
                }

            }
            fi += "\n";

            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    if (i == 3){
                        fi += String.format("%-65s", rs.getString(i));
                    } else if (i == 4 || i == 5) {
                        fi += String.format("%-15s", rs.getString(i));
                    } else {
                        fi += String.format("%-25s", rs.getString(i));
                    }

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
                System.out.println("La escola ha sigut eliminada amb éxit.");
            } else {
                System.out.println("No s'ha trobat cap fila amb el nom especificat.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la taula", e);
        }
    }

    public static String llistarAmbRest(Connection con) {
        String fi = "";
        try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM escoles WHERE restriccions IS NOT NULL")) {
            ResultSet rs = stmt.executeQuery(); // Ejecutar y obtener resultados
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String nomCol = metaData.getColumnName(i);
                String nomColumna = nomCol.substring(0, 1).toUpperCase() + nomCol.substring(1).replaceAll("_", " ");
                if (i == 3){
                    fi += String.format("%-65s", nomColumna);
                } else if (i == 4 || i == 5) {
                    fi += String.format("%-15s", nomColumna);
                } else {
                    fi += String.format("%-25s", nomColumna);
                }

            }
            fi += "\n";

            while (rs.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    if (i == 3){
                        fi += String.format("%-65s", rs.getString(i));
                    } else if (i == 4 || i == 5) {
                        fi += String.format("%-15s", rs.getString(i));
                    } else {
                        fi += String.format("%-25s", rs.getString(i));
                    }

                }
                fi += "\n";
            }

            if (fi.equals("")) fi = "No hi ha dades";
        } catch (SQLException e) {
            throw new RuntimeException("Error al llistar tot", e);
        }
        return fi;
    }

    public static void actualitzarVies(Connection con, String escola) throws SQLException {
        try (Statement stmt = con.createStatement()) {
            PreparedStatement stmt2 = con.prepareStatement("SELECT COUNT(*) FROM vies WHERE escola = '" + escola + "'");
            ResultSet rs = stmt2.executeQuery();
            String sql = "UPDATE escoles SET num_vies = " + rs.getString(1) + " WHERE nom = '" + escola + "'";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualitzar la base de dades", e);
        }
    }
}
