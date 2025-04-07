package dao.sqlite;
import java.sql.*;
import controller.EscolesController;
import dao.DBConnection;
import dao.interfaces.DAO;

public class SQLiteEscolesDAO implements DAO {
    public void crear(Object o) {
        if (o instanceof EscolesController) {
            Connection con = DBConnection.getConnexio();
            try (Statement stmt = con.createStatement()) {
                stmt.executeQuery("INSERT INTO escoles VALUES(" + ((EscolesController) o).getNom()
                        + "," + ((EscolesController) o).getLloc() + ","
                        + ((EscolesController) o).getAproximacio() + "," + ((EscolesController) o).getVies() + ","
                        + ((EscolesController) o).getPopularitat() + "," + ((EscolesController) o).getRestriccions() +")");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            DBConnection.desconectar(con);
        }
    }

    public void llistarID(String nom) {
        Connection con = DBConnection.getConnexio();
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("SELECT * FROM escoles WHERE nom = " + nom);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBConnection.desconectar(con);
    }

    @Override
    public void llistarTot() {
        Connection con = DBConnection.getConnexio();
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("SELECT * FROM escoles");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBConnection.desconectar(con);
    }

    @Override
    public void actualitzar(String Nom, String quequiero, String comoquiero) {
        Connection con = DBConnection.getConnexio();
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("UPDATE escoles SET " + quequiero + " = " + comoquiero + " WHERE nom = " + Nom);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBConnection.desconectar(con);
    }

    @Override
    public void esborrar(String Nom) {
        Connection con = DBConnection.getConnexio();
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("DELETE FROM escoles WHERE nom = " + Nom);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBConnection.desconectar(con);


    }
}
