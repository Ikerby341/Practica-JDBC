package model;

public class Escoles {
    private final String nom;
    private final String lloc;
    private final String aproximacio;
    private final int num_vies;
    private final TipusPopularitat popularitat;
    private final String restriccions;

    public Escoles(String nom, String lloc, String aproximacio, int num_vies, TipusPopularitat popularitat, String restriccions) {
        this.nom = nom;
        this.lloc = lloc;
        this.aproximacio = aproximacio;
        this.num_vies = num_vies;
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

    public String getLloc() {
        return lloc;
    }

    public String getAproximacio() {
        return aproximacio;
    }

    public int getVies() {
        return num_vies;
    }

    public TipusPopularitat getPopularitat() {
        return popularitat;
    }

    public String getRestriccions() {
        return restriccions;
    }

    @Override
    public String toString() {
        return "Escoles{" +
                "nom='" + nom + '\'' +
                ", lloc='" + lloc + '\'' +
                ", aproximacio='" + aproximacio + '\'' +
                ", num_vies=" + num_vies +
                ", popularitat=" + popularitat +
                ", restriccions='" + restriccions + '\'' +
                '}';
    }
}
