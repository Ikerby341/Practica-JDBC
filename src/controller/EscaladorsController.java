package controller;

import view.Vista;

public class EscaladorsController {
    private final String nom;
    private final String alies;
    private final int edat;
    private final String nivell;
    private final int id_via;
    private final TipusEstilPreferit estil_pref;
    private final String historial;
    private final String fita;

    public EscaladorsController(String nom, String alies, int edat, String nivell, int id_via, TipusEstilPreferit estil_pref, String historial, String fita) {
        this.nom = nom;
        this.alies = alies;
        this.edat = edat;
        this.nivell = nivell;
        this.id_via = id_via;
        this.estil_pref = estil_pref;
        this.historial = historial;
        this.fita = fita;
    }

    public static void mostrarSubmenuEscaladors() {
        Vista.mostrartTitol("GESTIÓ ESCALADORS");
        Vista.mostrarMissatge("1) Crear escalador");
        Vista.mostrarMissatge("2) Modificar escalador");
        Vista.mostrarMissatge("3) Cercar escalador");
        Vista.mostrarMissatge("4) Mostrar tots els escaladors");
        Vista.mostrarMissatge("5) Eliminar escalador");
        Vista.mostrarMissatge("0) Tornar");
        Vista.mostrarMissatge("Selecciona una opció (0-5): ");
    }

    private enum TipusEstilPreferit {
        ESPORTIVA,
        CLASSICA,
        GEL
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

    public TipusEstilPreferit getEstil_pref() {
        return estil_pref;
    }

    public String getHistorial() {
        return historial;
    }

    public String getFita() {
        return fita;
    }
}
