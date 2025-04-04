package dao.sqlite;

import dao.interfaces.DAO;

import java.util.List;

public class SQLiteViesDAO implements DAO {
    @Override
    public void crear(Object o) {

    }

    @Override
    public Object llistarID(Object id) {
        return null;
    }

    @Override
    public List llistarTot() {
        return List.of();
    }

    @Override
    public void actualitzar(Object o) {

    }

    @Override
    public boolean esborrar(Object id) {
        return false;
    }
}
