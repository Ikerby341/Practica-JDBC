package controller;

import view.Vista;

public class SectorsController {
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
}
