package model;

public class Sectors {
    private final String nom;
    private final String latitud;
    private final long longitud;
    private final String aproximacio;
    private final int numVies;
    private final TipusPopularitat popularitat;
    private final String restriccions;

    public Sectors(String nom, String latitud, long longitud, String aproximacio, int numVies, TipusPopularitat popularitat, String restriccions) {
        this.nom = nom;
        this.latitud = latitud;
        this.longitud = longitud;
        this.aproximacio = aproximacio;
        this.numVies = numVies;
        this.popularitat = popularitat;
        this.restriccions = restriccions;
    }

    public enum TipusPopularitat {
        BAIXA,
        MITJANA,
        ALTA
    }

    public String getNom() {
        return nom;
    }

    public String getLatitud() {
        return latitud;
    }

    public long getLongitud() {
        return longitud;
    }

    public String getAproximacio() {
        return aproximacio;
    }

    public int getNumVies() {
        return numVies;
    }

    public TipusPopularitat getPopularitat() {
        return popularitat;
    }

    public String getRestriccions() {
        return restriccions;
    }
}
