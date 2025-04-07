package dao.sqlite;
import dao.interfaces.DAO;
import model.Escoles;
import model.Vies;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteViesDAO implements DAO {
    public static void crear(Connection con,Object o) {
        if (o instanceof Vies) {
            try (Statement stmt = con.createStatement()) {
                stmt.executeQuery("INSERT INTO vies (tipus_via, nom, llargada, grau_dificultat, orientacio, estat, escola, sector_id, ancoratges, tipus_roca, creador) VALUES(" + ((Escoles) o).getNom()
                        + "," + ((Escoles) o).getLloc() + ","
                        + ((Escoles) o).getAproximacio() + "," + ((Escoles) o).getVies() + ","
                        + ((Escoles) o).getPopularitat() + "," + ((Escoles) o).getRestriccions() +")");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void llistarID(Connection con,String nom) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("SELECT * FROM escoles WHERE nom = " + nom);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void llistarTot(Connection con) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("SELECT * FROM escoles");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
