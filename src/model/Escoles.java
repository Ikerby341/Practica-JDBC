package model;

public class Escoles {
    private final String nom;
    private final String lloc;
    private final String aproximacio;
    private final int num_vies;
    private final String popularitat;
    private final String restriccions;

    public Escoles(String nom, String lloc, String aproximacio, int num_vies, String popularitat, String restriccions) {
        this.nom = nom;
        this.lloc = lloc;
        this.aproximacio = aproximacio;
        this.num_vies = num_vies;
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

    public String getLloc() {
        return lloc;
    }

    public String getAproximacio() {
        return aproximacio;
    }

    public int getVies() {
        return num_vies;
    }

    public String getPopularitat() {
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
