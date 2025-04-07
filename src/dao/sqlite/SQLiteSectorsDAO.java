package dao.sqlite;
import dao.DBConnection;
import dao.interfaces.DAO;
import model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteSectorsDAO implements DAO {

    public static void crear(Connection con,Object o) {
        if (o instanceof Sectors) {
            try (Statement stmt = con.createStatement()) {
                stmt.executeQuery("INSERT INTO escoles (nom,latitud,longitud,aproximacio,num_vies,popularitat,restriccions) VALUES(" + ((Sectors) o).getNom() + "," + ((Sectors) o).getLatitud() + "," + ((Sectors) o).getLongitud() + "," + ((Sectors) o).getAproximacio() + "," + ((Sectors) o).getNumVies() + "," + ((Sectors) o).getPopularitat() + "," + ((Sectors) o).getRestriccions() + ")");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void actualitzar(Connection con,String id, String quequiero, String comoquiero) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("UPDATE escoles SET " + quequiero + " = " + comoquiero + " WHERE sector_id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void llistarID(Connection con,String id) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("SELECT * FROM escoles WHERE sector_id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void llistarTot(Connection con) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("SELECT * FROM sectors");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void esborrar(Connection con,String id) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("DELETE FROM escoles WHERE sector_id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
