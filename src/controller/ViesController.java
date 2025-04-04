package controller;

import view.Vista;

public class ViesController {

    private TipusVia tipusVia;
    private String nom;
    private int llargada;
    private String grauDificultat;
    private String orientacio;
    private String estat;
    private String escola;
    private int sectorID;
    private TipusAncoratges ancoratges;
    private TipusRoca tipusRoca;
    private String creador;

    public ViesController(TipusVia tipusVia, String nom, int llargada, String grauDificultat, String orientacio, String estat, String escola, int sectorID, TipusAncoratges ancoratges, TipusRoca tipusRoca, String creador) {
        this.tipusVia = tipusVia;
        this.nom = nom;
        this.llargada = llargada;
        this.grauDificultat = grauDificultat;
        this.orientacio = orientacio;
        this.estat = estat;
        this.escola = escola;
        this.sectorID = sectorID;
        this.ancoratges = ancoratges;
        this.tipusRoca = tipusRoca;
        this.creador = creador;
    }

    public static void mostrarSubmenuVies() {
        Vista.mostrartTitol("GESTIÓ VIES");
        Vista.mostrarMissatge("1) Crear via");
        Vista.mostrarMissatge("2) Modificar via");
        Vista.mostrarMissatge("3) Cercar via");
        Vista.mostrarMissatge("4) Mostrar totes les vies");
        Vista.mostrarMissatge("5) Eliminar via");
        Vista.mostrarMissatge("0) Tornar");
        Vista.mostrarMissatge("Selecciona una opció (0-5): ");
    }

    private enum TipusVia {
        ESPORTIVA,
        CLASSICA,
        GEL;
    }

    private enum TipusAncoratges {
        FRIENDS,
        TASCONS,
        BAGUES,
        PITONS,
        TRICAMS,
        BIGBROS,
        SPITS,
        PARABOLTS,
        QUIMICS
    }

    private enum TipusRoca {
        CONGLOMERAT,
        GRANIT,
        CALCARIA,
        ARENISCA,
        ALTRES
    }
}
