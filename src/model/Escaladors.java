package model;

public class Escaladors {
    private final String nom;
    private final String alies;
    private final int edat;
    private final String nivell;
    private final int id_via;
    private final String estil_pref;
    private final String historial;
    private final String fita;

    public Escaladors(String nom, String alies, int edat, String nivell, int id_via, String estil_pref, String historial, String fita) {
        this.nom = nom;
        this.alies = alies;
        this.edat = edat;
        this.nivell = nivell;
        this.id_via = id_via;
        if(estil_pref.toLowerCase().equals("esportiva") || estil_pref.toLowerCase().equals("classica") ||   estil_pref.toLowerCase().equals("gel")) {
            this.estil_pref = estil_pref.toLowerCase();
        } else {
            throw new IllegalArgumentException("L'estil preferit ha de ser esportiva, classica o gel");
        }
        this.historial = historial;
        this.fita = fita;
    }



    public String getNom() {
        return nom;
    }

    public String getAlies() {
        return alies;
    }

    public int getEdat() {
        return edat;
    }

    public String getNivell() {
        return nivell;
    }

    public int getId_via() {
        return id_via;
    }

    public String getEstil_pref() {
        return estil_pref;
    }

    public String getHistorial() {
        return historial;
    }

    public String getFita() {
        return fita;
    }
}
