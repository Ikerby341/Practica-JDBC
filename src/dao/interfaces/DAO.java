package dao.interfaces;

import controller.EscolesController;

import java.util.List;

public interface DAO<T,K> {
    void crear(Object o);
    void actualitzar(String id, String quequiero, String comoquiero);
    void llistarID(String id);
    void llistarTot();
    void esborrar(String id);
}