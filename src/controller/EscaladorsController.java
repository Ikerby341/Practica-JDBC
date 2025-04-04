package controller;

import view.Vista;

public class EscaladorsController {
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
}
