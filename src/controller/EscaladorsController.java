package controller;

import view.Vista;

public class EscaladorsController {
    private String nom;
    private String alies;
    private int edat;
    private String nivell;
    private int id_via;
    private TipusEstilPreferit estil_pref;
    private String historial;
    private String fita;

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
}
