package dao.sqlite;
import model.*;
import dao.DBConnection;
import dao.interfaces.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteEscaladorsDAO implements DAO {

    public static void crear(Connection con,Object o) {
        if (o instanceof Escaladors) {
            try (Statement stmt = con.createStatement()) {
                stmt.executeQuery("INSERT INTO escoles (nom,alies,edat,nivell,via_id,estil_preferit,historial,fita) VALUES(" + ((Escaladors) o).getNom() + "," + ((Escaladors) o).getAlies() + "," + ((Escaladors) o).getEdat() + "," + ((Escaladors) o).getNivell() + "," + ((Escaladors) o).getId_via() + "," + ((Escaladors) o).getEstil_pref() + "," + ((Escaladors) o).getHistorial() + "," + ((Escaladors) o).getFita() + ")");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void actualitzar(Connection con,String id, String quequiero, String comoquiero) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("UPDATE escaladors SET " + quequiero + " = " + comoquiero + " WHERE escalador_id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void llistarID(Connection con,String id) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("SELECT * FROM escaladors WHERE escalador_id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void llistarTot(Connection con) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("SELECT * FROM escaladors");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void esborrar(Connection con,String id) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("DELETE FROM escaladors WHERE escalador_id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
