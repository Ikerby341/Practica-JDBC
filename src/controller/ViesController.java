package controller;

import view.Vista;

public class ViesController {
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
}
