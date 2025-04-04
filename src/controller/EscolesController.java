package controller;

import view.Vista;

public class EscolesController {
    String nom;
    String lloc;
    String aproximacio;
    int num_vies;
    TipusPopularitat popularitat;
    String restriccions;



    public static void mostrarSubmenuEscoles() {
        Vista.mostrartTitol("GESTIÓ ESCOLES");
        Vista.mostrarMissatge("1) Crear escola");
        Vista.mostrarMissatge("2) Modificar escola");
        Vista.mostrarMissatge("3) Cercar escola");
        Vista.mostrarMissatge("4) Mostrar totes les escoles");
        Vista.mostrarMissatge("5) Eliminar escoles");
        Vista.mostrarMissatge("0) Tornar");
        Vista.mostrarMissatge("Selecciona una opció (0-5): ");
    }

    private enum TipusPopularitat {
        BAIXA,
        MITJANA,
        ALTA
    }

}
