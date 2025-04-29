package model;

public class Trams {
    private String via;
    private int llargada;
    private String grauDificultat;

    public Trams(String via, int llargada, String grauDificultat) {
        this.via = via;
        this.llargada = llargada;
        this.grauDificultat = grauDificultat;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getLlargada() {
        return llargada;
    }

    public void setLlargada(int llargada) {
        this.llargada = llargada;
    }

    public String getGrauDificultat() {
        return grauDificultat;
    }

    public void setGrauDificultat(String grauDificultat) {
        this.grauDificultat = grauDificultat;
    }
}
