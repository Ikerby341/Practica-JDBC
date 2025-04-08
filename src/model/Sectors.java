package model;

public class Sectors {
    private final String nom;
    private final String latitud;
    private final long longitud;
    private final String aproximacio;
    private final int numVies;
    private final String popularitat;
    private final String restriccions;

    public Sectors(String nom, String latitud, long longitud, String aproximacio, int numVies, String popularitat, String restriccions) {
        this.nom = nom;
        this.latitud = latitud;
        this.longitud = longitud;
        this.aproximacio = aproximacio;
        this.numVies = numVies;
        if (popularitat.toLowerCase().equals("alta") || popularitat.toLowerCase().equals("mitjana") || popularitat.toLowerCase().equals("baixa")) {
            this.popularitat = popularitat.toLowerCase();
        } else {
            throw new IllegalArgumentException("La popularitat ha de ser alta, mitjana o baixa");
        }
        this.restriccions = restriccions;
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

    public String getPopularitat() {
        return popularitat;
    }

    public String getRestriccions() {
        return restriccions;
    }
}
