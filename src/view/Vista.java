package view;

public class Vista {
    public static void mostrarMissatge(String msg) {
        System.out.println(msg);
    }

    public static void mostrarTitol(String name) {
        String barras = "";
        for (int i = 0; i < (name.length() + 8); i++) barras += "-";

        Vista.mostrarMissatge(barras);
        Vista.mostrarMissatge("--- " + name + " ---");
        Vista.mostrarMissatge(barras);
    }

    /* Menu principal */
    public static void mostrarMenuPrincipal() {
        Vista.mostrarTitol("INICI");
        Vista.mostrarMissatge("1) Gestionar escoles");
        Vista.mostrarMissatge("2) Gestionar sectors");
        Vista.mostrarMissatge("3) Gestionar vies");
        Vista.mostrarMissatge("4) Gestionar escaladors");
        Vista.mostrarMissatge("0) Finalitzar");
        Vista.mostrarMissatge("Selecciona una opció (0-4): ");
    }

    /* Submenus */
    public static void mostrarSubmenuEscaladors() {
        Vista.mostrarTitol("GESTIÓ ESCALADORS");
        Vista.mostrarMissatge("1) Crear escalador");
        Vista.mostrarMissatge("2) Modificar escalador");
        Vista.mostrarMissatge("3) Cercar escalador");
        Vista.mostrarMissatge("4) Mostrar tots els escaladors");
        Vista.mostrarMissatge("5) Eliminar escalador");
        Vista.mostrarMissatge("6) Mostrar escaladors amb el mateix nivell màxim assolit");
        Vista.mostrarMissatge("0) Tornar");
        Vista.mostrarMissatge("Selecciona una opció (0-5): ");
    }

    public static void mostrarSubmenuEscoles() {
        Vista.mostrarTitol("GESTIÓ ESCOLES");
        Vista.mostrarMissatge("1) Crear escola");
        Vista.mostrarMissatge("2) Modificar escola");
        Vista.mostrarMissatge("3) Cercar escola");
        Vista.mostrarMissatge("4) Mostrar totes les escoles");
        Vista.mostrarMissatge("5) Eliminar escoles");
        Vista.mostrarMissatge("6) Consultar escoles amb restriccions actives actualment");
        Vista.mostrarMissatge("7) Actualitzar número de vies automàticament");
        Vista.mostrarMissatge("0) Tornar");
        Vista.mostrarMissatge("Selecciona una opció (0-5): ");
    }

    public static void mostrarSubmenuSectors() {
        Vista.mostrarTitol("GESTIÓ SECTORS");
        Vista.mostrarMissatge("1) Crear sector");
        Vista.mostrarMissatge("2) Modificar sector");
        Vista.mostrarMissatge("3) Cercar sector");
        Vista.mostrarMissatge("4) Mostrar tots els sectors");
        Vista.mostrarMissatge("5) Eliminar sector");
        Vista.mostrarMissatge("6) Mostrar sectors amb més de X vies disponibles");
        Vista.mostrarMissatge("0) Tornar");
        Vista.mostrarMissatge("Selecciona una opció (0-5): ");
    }

    public static void mostrarSubmenuVies() {
        Vista.mostrarTitol("GESTIÓ VIES");
        Vista.mostrarMissatge("1) Crear via");
        Vista.mostrarMissatge("2) Modificar via");
        Vista.mostrarMissatge("3) Cercar via");
        Vista.mostrarMissatge("4) Mostrar totes les vies");
        Vista.mostrarMissatge("5) Eliminar via");
        Vista.mostrarMissatge("6) Mostrar vies disponibles en una escola");
        Vista.mostrarMissatge("7) Cercar vies per dificultat en un rang (via, grau, sector, escola)");
        Vista.mostrarMissatge("8) Cercar vies segons estat (Apte, Construcció, Tancada)");
        Vista.mostrarMissatge("9) Mostrar les vies més llargues d’una escola determinada");
        Vista.mostrarMissatge("0) Tornar");
        Vista.mostrarMissatge("Selecciona una opció (0-5): ");
    }

}