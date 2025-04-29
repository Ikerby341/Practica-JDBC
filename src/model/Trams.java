package model;

import dao.DBConnection;
import dao.sqlite.SQLiteViesDAO;

import java.util.InputMismatchException;

public class Trams {
    private String via;
    private int llargada;
    private String grauDificultat;

    public Trams(String via, int llargada, String grauDificultat, String grauDificultatVia) {
        this.via = via;
        this.llargada = llargada;
        String diffBase = "000,4,4+,5,5+,6a,6a+,6b,6b+,6c,6c+,7a,7a+,7b,7b+,7c,7c+,8a,8a+,8b,8b+,8c,8c+,9a,9a+,9b,9b+,9c,9c+";
        String[] difficultats = diffBase.split(",");

        int grauTrobat = 0;
        int grauTrobatVia = 0;

        for (int i = 0; i < difficultats.length; i++) {
            if (difficultats[i].equals(grauDificultat)) grauTrobat = i;
            if (difficultats[i].equals(grauDificultatVia)) grauTrobatVia = i;
        }

        if (grauTrobatVia < grauTrobat || grauTrobat == 0) {
            SQLiteViesDAO.esborrar(DBConnection.getConnexio(),via);
            throw new InputMismatchException("El grau(s) introduït(s) no es correcte");
        } else {
            this.grauDificultat = grauDificultat;
        }
    }

    public String getVia() {
        return via;
    }

    public int getLlargada() {
        return llargada;
    }

    public String getGrauDificultat() {
        return grauDificultat;
    }
}
