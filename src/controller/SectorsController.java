package controller;

import view.Vista;

public class SectorsController {
    private final String nom;
    private final String latitud;
    private final long longitud;
    private final String aproximacio;
    private final int numVies;
    private final TipusPopularitat popularitat;

    public SectorsController(String nom, String latitud, long longitud, String aproximacio, int numVies, TipusPopularitat popularitat) {
        this.nom = nom;
        this.latitud = latitud;
        this.longitud = longitud;
        this.aproximacio = aproximacio;
        this.numVies = numVies;
        this.popularitat = popularitat;
    }

    public static void mostrarSubmenuSectors() {
        Vista.mostrartTitol("GESTIÓ SECTORS");
        Vista.mostrarMissatge("1) Crear sector");
        Vista.mostrarMissatge("2) Modificar sector");
        Vista.mostrarMissatge("3) Cercar sector");
        Vista.mostrarMissatge("4) Mostrar tots els sectors");
        Vista.mostrarMissatge("5) Eliminar sector");
        Vista.mostrarMissatge("0) Tornar");
        Vista.mostrarMissatge("Selecciona una opció (0-5): ");
    }

    private enum TipusPopularitat {
        BAIXA,
        MITJANA,
        ALTA
    }

    public String getNom() {
        return nom;
    }

    public String getLatitud() {
        return latitud;
    }

    public long getLongitud() {
        return longitud;
    }

    public String getAproximacio() {
        return aproximacio;
    }

    public int getNumVies() {
        return numVies;
    }

    public TipusPopularitat getPopularitat() {
        return popularitat;
    }
}
