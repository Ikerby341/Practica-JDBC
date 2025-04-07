package dao.sqlite;

import dao.DBConnection;
import dao.interfaces.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SQLiteSectorsDAO implements DAO {
    @Override
    public void crear(Object o) {

    }

    @Override
    public void actualitzar(String id, String quequiero, String comoquiero) {

    }

    @Override
    public void llistarID(String id) {

    }

    @Override
    public void llistarTot() {
        Connection con = DBConnection.getConnexio();
        try (Statement stmt = con.createStatement()) {
            stmt.executeQuery("SELECT * FROM sectors");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBConnection.desconectar(con);
    }

    @Override
    public void esborrar(String id) {

    }

}
