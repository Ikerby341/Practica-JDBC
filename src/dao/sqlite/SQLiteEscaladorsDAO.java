package dao.sqlite;
import controller.EscaladorsController;
import dao.DBConnection;
import dao.interfaces.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteEscaladorsDAO implements DAO {
    @Override
    public void crear(Object o) {
        if (o instanceof EscaladorsController) {
            Connection con = DBConnection.getConnexio();
            try (Statement stmt = con.createStatement()) {
                stmt.executeQuery("INSERT INTO escoles VALUES(" + ((EscaladorsController) o).getNom()
                        + "," + ((EscolesController) o).getLloc() + ","
                        + ((EscolesController) o).getAproximacio() + "," + ((EscolesController) o).getVies() + ","
                        + ((EscolesController) o).getPopularitat() + "," + ((EscolesController) o).getRestriccions() +")");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            DBConnection.desconectar(con);
        }
    }

    @Override
    public void actualitzar(String id, String quequiero, String comoquiero) {
        Connection con = DBConnection.getConnexio();
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("UPDATE escaladors SET " + quequiero + " = " + comoquiero + " WHERE escalador_id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBConnection.desconectar(con);
    }

    @Override
    public void llistarID(String id) {
        Connection con = DBConnection.getConnexio();
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("SELECT * FROM escaladors WHERE escalador_id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBConnection.desconectar(con);
    }

    @Override
    public void llistarTot() {
        Connection con = DBConnection.getConnexio();
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("SELECT * FROM escaladors");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBConnection.desconectar(con);
    }

    @Override
    public void esborrar(String id) {
        Connection con = DBConnection.getConnexio();
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("DELETE FROM escaladors WHERE escalador_id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBConnection.desconectar(con);
    }
}
