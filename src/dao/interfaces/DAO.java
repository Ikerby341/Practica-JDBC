package dao.interfaces;

import java.util.List;

public interface DAO<T,K> {
    void crear(T t);
    T llistarID(K id);
    List<T> llistarTot();
    void actualitzar(T t);
    boolean esborrar(K id);
}