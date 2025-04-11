package model;

public class Vies {
    private String tipusVia;
    private String nom;
    private int llargada;
    private String grauDificultat = "";
    private String orientacio;
    private String estat;
    private String escola;
    private int sectorID;
    private String ancoratges;
    private String tipusRoca;
    private String creador;

    public Vies(String tipusVia, String nom, int llargada, String grauDificultat, String orientacio, String estat, String escola, int sectorID, String ancoratges, String tipusRoca, String creador) {
        if(tipusVia.equalsIgnoreCase("esportiva") || tipusVia.equalsIgnoreCase("classica") ||   tipusVia.equalsIgnoreCase("gel")) {
            this.tipusVia = tipusVia.toLowerCase();
        } else {
            throw new IllegalArgumentException("El tipus de via ha de ser esportiva, classica o gel");
        }

        this.nom = nom;
        this.llargada = llargada;
        if (tipusVia.equalsIgnoreCase("esportiva") || tipusVia.equalsIgnoreCase("classica")) {
            if (grauDificultat.equals("4") || grauDificultat.equals("4+") || grauDificultat.equals("5") || grauDificultat.equals("5+") || grauDificultat.equals("6a") || grauDificultat.equals("6a+") || grauDificultat.equals("6b") || grauDificultat.equals("6b+") || grauDificultat.equals("6c") || grauDificultat.equals("6c+") || grauDificultat.equals("7a") || grauDificultat.equals("7a+") || grauDificultat.equals("7b") || grauDificultat.equals("7b+") || grauDificultat.equals("7c") || grauDificultat.equals("7c+") || grauDificultat.equals("8a") || grauDificultat.equals("8a+") || grauDificultat.equals("8b") || grauDificultat.equals("8b+") || grauDificultat.equals("8c") || grauDificultat.equals("8c+") || grauDificultat.equals("9a") || grauDificultat.equals("9a+") || grauDificultat.equals("9b") || grauDificultat.equals("9b+") || grauDificultat.equals("9c") || grauDificultat.equals("9c+")) {
                this.grauDificultat = grauDificultat;
            } else {
                throw new IllegalArgumentException("El grau de dificultat en vies esportives i classiques ha de ser 4, 4+, 5, 5+, 6a, 6a+, 6b, 6b+, 6c, 6c+, 7a, 7a+, 7b, 7b+, 7c, 7c+, 8a, 8a+, 8b, 8b+, 8c, 8c+, 9a, 9a+, 9b, 9b+, 9c o 9c+");
            }
        } else if (tipusVia.equalsIgnoreCase("gel")){
            if (grauDificultat.equals("4") || grauDificultat.equals("4+") || grauDificultat.equals("5") || grauDificultat.equals("5+") || grauDificultat.equals("6a") || grauDificultat.equals("6a+") || grauDificultat.equals("6b") || grauDificultat.equals("6b+") || grauDificultat.equals("6c") || grauDificultat.equals("6c+") || grauDificultat.equals("7a") || grauDificultat.equals("7a+") || grauDificultat.equals("7b") || grauDificultat.equals("7b+") || grauDificultat.equals("7c") || grauDificultat.equals("7c+") || grauDificultat.equals("8a") || grauDificultat.equals("8a+") || grauDificultat.equals("8b")) {
                this.grauDificultat = grauDificultat;
            } else {
                throw new IllegalArgumentException("El grau de dificultat en vies de gel ha de ser 4, 4+, 5, 5+, 6a, 6a+, 6b, 6b+, 6c, 6c+, 7a, 7a+, 7b, 7b+, 7c, 7c+, 8a, 8a+, 8b");
            }
        }
        if (orientacio.equalsIgnoreCase("N") || orientacio.equalsIgnoreCase("NE") || orientacio.equalsIgnoreCase("NO") || orientacio.equalsIgnoreCase("SE") || orientacio.equalsIgnoreCase("SO") || orientacio.equalsIgnoreCase("E") || orientacio.equalsIgnoreCase("O") || orientacio.equalsIgnoreCase("S")) {
            this.orientacio = orientacio.toUpperCase();
        } else {
            throw new IllegalArgumentException("L'orientació ha de ser N, NE, NO, SE, SO, E, O o S");
        }
        if (estat.equalsIgnoreCase("apte") || estat.equalsIgnoreCase("construccio") || estat.equalsIgnoreCase("tancada")) {
            this.estat = estat;
        } else {
            throw new IllegalArgumentException("L'estat ha de ser apte, construcció o tancada");
        }

        this.escola = escola;
        this.sectorID = sectorID;

        if (tipusVia.equalsIgnoreCase("esportiva")) {
            if(ancoratges.equalsIgnoreCase("spits") || ancoratges.equalsIgnoreCase("parabolts") || ancoratges.equalsIgnoreCase("quimics")) {
                this.ancoratges = ancoratges.toLowerCase();
            } else {
                throw new IllegalArgumentException("El tipus d'ancoratge per vies esportives ha de ser (spits, parabolts o quimics)");
            }
        } else if (tipusVia.equalsIgnoreCase("classica")) {
            if(ancoratges.equalsIgnoreCase("friends") || ancoratges.equalsIgnoreCase("tascons") || ancoratges.equalsIgnoreCase("bagues") || ancoratges.equalsIgnoreCase("pitons") || ancoratges.equalsIgnoreCase("tricams") || ancoratges.equalsIgnoreCase("bigbros") || ancoratges.equalsIgnoreCase("spits") || ancoratges.equalsIgnoreCase("parabolts") || ancoratges.equalsIgnoreCase("quimics")) {
                this.ancoratges = ancoratges.toLowerCase();
            } else {
                throw new IllegalArgumentException("El tipus d'ancoratges per vies classiques ha de ser (friends, tascons, bagues, pitons, tricams, bigbros, spits, parabolts, quimics)");
            }
        } else if (tipusVia.equalsIgnoreCase("gel")) {
            if (ancoratges.equalsIgnoreCase("friends") || ancoratges.equalsIgnoreCase("tascons") || ancoratges.equalsIgnoreCase("bagues") || ancoratges.equalsIgnoreCase("pitons") || ancoratges.equalsIgnoreCase("bigbros")) {
                this.ancoratges = ancoratges.toLowerCase();
            } else {
                throw new IllegalArgumentException("El tipus d'ancoratges per vies de gel ha de ser (friends, tascons, bagues, pitons, tricams, BigBros, spits, parabolts, quimics)");
            }
        }

        if(tipusRoca.equalsIgnoreCase("conglomerat") || tipusRoca.equalsIgnoreCase("granit") || tipusRoca.equalsIgnoreCase("calcaria") || tipusRoca.equalsIgnoreCase("arenisca") || tipusRoca.equalsIgnoreCase("altres")) {
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
