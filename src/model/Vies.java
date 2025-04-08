package model;

public class Vies {
    private final String tipusVia;
    private final String nom;
    private final int llargada;
    private final String grauDificultat;
    private final String orientacio;
    private final String estat;
    private final String escola;
    private final int sectorID;
    private final String ancoratges;
    private final String tipusRoca;
    private final String creador;

    public Vies(String tipusVia, String nom, int llargada, String grauDificultat, String orientacio, String estat, String escola, int sectorID, String ancoratges, String tipusRoca, String creador) {
        if(tipusVia.toLowerCase().equals("esportiva") || tipusVia.toLowerCase().equals("classica") ||   tipusVia.toLowerCase().equals("gel")) {
            this.tipusVia = tipusVia.toLowerCase();
        } else {
            throw new IllegalArgumentException("El tipus de via ha de ser esportiva, classica o gel");
        }
        this.nom = nom;
        this.llargada = llargada;
        this.grauDificultat = grauDificultat;
        this.orientacio = orientacio;
        this.estat = estat;
        this.escola = escola;
        this.sectorID = sectorID;
        if(ancoratges.toLowerCase().equals("friends") || ancoratges.toLowerCase().equals("tascons") || ancoratges.toLowerCase().equals("bagues") || ancoratges.toLowerCase().equals("pitons") || ancoratges.toLowerCase().equals("tricams") || ancoratges.toLowerCase().equals("bigbros") || ancoratges.toLowerCase().equals("spits") || ancoratges.toLowerCase().equals("parabolts") || ancoratges.toLowerCase().equals("quimics")) {
            this.ancoratges = ancoratges.toLowerCase();
        } else {
            throw new IllegalArgumentException("El tipus d'ancoratges ha de ser friends, tascons, bagues, pitons, tricams, bigbros, spits, parabolts o quimics");
        }
        if(tipusRoca.toLowerCase().equals("conglomerat") || tipusRoca.toLowerCase().equals("granit") || tipusRoca.toLowerCase().equals("calcaris") || tipusRoca.toLowerCase().equals("arenisca") || tipusRoca.toLowerCase().equals("altres")) {
            this.tipusRoca = tipusRoca.toLowerCase();
        } else {
            throw new IllegalArgumentException("El tipus de roca ha de ser conglomerat, granit, calcaris, arenisca o altres");
        }
        this.creador = creador;
    }

    public String getTipusVia() {
        return tipusVia;
    }

    public String getNom() {
        return nom;
    }

    public int getLlargada() {
        return llargada;
    }

    public String getGrauDificultat() {
        return grauDificultat;
    }

    public String getOrientacio() {
        return orientacio;
    }

    public String getEstat() {
        return estat;
    }

    public String getEscola() {
        return escola;
    }

    public int getSectorID() {
        return sectorID;
    }

    public String getAncoratges() {
        return ancoratges;
    }

    public String getTipusRoca() {
        return tipusRoca;
    }

    public String getCreador() {
        return creador;
    }
}
