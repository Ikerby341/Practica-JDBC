package model;

public class Vies {
    private final String tipusVia;
    private final String nom;
    private final int llargada;
    private String grauDificultat = "";
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
        if (tipusVia.toLowerCase().equals("esportiva") || tipusVia.toLowerCase().equals("classica")) {
            if (grauDificultat.equals("4") || grauDificultat.equals("4+") || grauDificultat.equals("5") || grauDificultat.equals("5+") || grauDificultat.equals("6a") || grauDificultat.equals("6a+") || grauDificultat.equals("6b") || grauDificultat.equals("6b+") || grauDificultat.equals("6c") || grauDificultat.equals("6c+") || grauDificultat.equals("7a") || grauDificultat.equals("7a+") || grauDificultat.equals("7b") || grauDificultat.equals("7b+") || grauDificultat.equals("7c") || grauDificultat.equals("7c+") || grauDificultat.equals("8a") || grauDificultat.equals("8a+") || grauDificultat.equals("8b") || grauDificultat.equals("8b+") || grauDificultat.equals("8c") || grauDificultat.equals("8c+") || grauDificultat.equals("9a") || grauDificultat.equals("9a+") || grauDificultat.equals("9b") || grauDificultat.equals("9b+") || grauDificultat.equals("9c") || grauDificultat.equals("9c+")) {
                this.grauDificultat = grauDificultat;
            } else {
                throw new IllegalArgumentException("El grau de dificultat en vies esportives i classiques ha de ser 4, 4+, 5, 5+, 6a, 6a+, 6b, 6b+, 6c, 6c+, 7a, 7a+, 7b, 7b+, 7c, 7c+, 8a, 8a+, 8b, 8b+, 8c, 8c+, 9a, 9a+, 9b, 9b+, 9c o 9c+");
            }
        } else if (tipusVia.toLowerCase().equals("gel")){
            if (grauDificultat.equals("4") || grauDificultat.equals("4+") || grauDificultat.equals("5") || grauDificultat.equals("5+") || grauDificultat.equals("6a") || grauDificultat.equals("6a+") || grauDificultat.equals("6b") || grauDificultat.equals("6b+") || grauDificultat.equals("6c") || grauDificultat.equals("6c+") || grauDificultat.equals("7a") || grauDificultat.equals("7a+") || grauDificultat.equals("7b") || grauDificultat.equals("7b+") || grauDificultat.equals("7c") || grauDificultat.equals("7c+") || grauDificultat.equals("8a") || grauDificultat.equals("8a+") || grauDificultat.equals("8b")) {
                this.grauDificultat = grauDificultat;
            } else {
                throw new IllegalArgumentException("El grau de dificultat en vies de gel ha de ser 4, 4+, 5, 5+, 6a, 6a+, 6b, 6b+, 6c, 6c+, 7a, 7a+, 7b, 7b+, 7c, 7c+, 8a, 8a+, 8b");
            }
        }
        if (orientacio.toUpperCase().equals("N") || orientacio.toUpperCase().equals("NE") || orientacio.toUpperCase().equals("NO") || orientacio.toUpperCase().equals("SE") || orientacio.toUpperCase().equals("SO") || orientacio.toUpperCase().equals("E") || orientacio.toUpperCase().equals("O") || orientacio.toUpperCase().equals("S")) {
            this.orientacio = orientacio.toUpperCase();
        } else {
            throw new IllegalArgumentException("L'orientació ha de ser N, NE, NO, SE, SO, E, O o S");
        }
        if (estat.toLowerCase().equals("apte") || estat.toLowerCase().equals("construccio") || estat.toLowerCase().equals("tancada")) {
            this.estat = estat;
        } else {
            throw new IllegalArgumentException("L'estat ha de ser apte, construcció o tancada");
        }
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
