import view.Vista;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    private static int opcio = 0;
    private static boolean cont = true;

    public static void main(String[] args) {
        while(cont) {
            mostrarMenuPrincipal();
            try {
                scanOpcio(4);
                switchPrincipal();
            } catch (Exception e) {
                Vista.mostrarMissatge(e.getMessage());
            }
        }
    }

    /* Comprovació */

    private static void scanOpcio(int op) {
        opcio = scan.nextInt();
        scan.nextLine();
        comprovarOpcio(op);
    }

    private static void comprovarOpcio(int op) {
        while (opcio < 0 || opcio > op) {
            Vista.mostrarMissatge("Opció incorrecta, torna a escollir!");
            Vista.mostrarMissatge("Selecciona una opció (0-" + op + "): ");
            opcio = scan.nextInt();
            scan.nextLine();
        }
    }

    /* Menu principal */

    private static void switchPrincipal() {
        switch (opcio) {
            case 1:
                mostrarSubmenuEscoles();
                scanOpcio(5);
                break;
            case 2:
                mostrarSubmenuSectors();
                scanOpcio(5);
                break;
            case 3:
                mostrarSubmenuVies();
                scanOpcio(5);
                break;
            case 4:
                mostrarSubmenuEscaladors();
                scanOpcio(5);
                break;
            default:
                Vista.mostrarMissatge("Has finalitzat el programa.");
                cont = false;
                break;
        }
    }

    private static void mostrarMenuPrincipal() {
        Vista.mostrartTitol("INICI");
        Vista.mostrarMissatge("1) Gestionar escoles");
        Vista.mostrarMissatge("2) Gestionar sectors");
        Vista.mostrarMissatge("3) Gestionar vies");
        Vista.mostrarMissatge("4) Gestionar escaladors");
        Vista.mostrarMissatge("0) Finalitzar");
        Vista.mostrarMissatge("Selecciona una opció (0-4): ");
    }

    /* SubMenus */

    private static void mostrarSubmenuEscoles() {
        Vista.mostrartTitol("GESTIÓ ESCOLES");
        Vista.mostrarMissatge("1) Crear escola");
        Vista.mostrarMissatge("2) Modificar escola");
        Vista.mostrarMissatge("3) Cercar escola");
        Vista.mostrarMissatge("4) Mostrar totes les escoles");
        Vista.mostrarMissatge("5) Eliminar escoles");
        Vista.mostrarMissatge("0) Tornar");
        Vista.mostrarMissatge("Selecciona una opció (0-5): ");
    }

    private static void mostrarSubmenuSectors() {
        Vista.mostrartTitol("GESTIÓ SECTORS");
        Vista.mostrarMissatge("1) Crear sector");
        Vista.mostrarMissatge("2) Modificar sector");
        Vista.mostrarMissatge("3) Cercar sector");
        Vista.mostrarMissatge("4) Mostrar tots els sectors");
        Vista.mostrarMissatge("5) Eliminar sector");
        Vista.mostrarMissatge("0) Tornar");
        Vista.mostrarMissatge("Selecciona una opció (0-5): ");
    }

    private static void mostrarSubmenuVies() {
        Vista.mostrartTitol("GESTIÓ VIES");
        Vista.mostrarMissatge("1) Crear via");
        Vista.mostrarMissatge("2) Modificar via");
        Vista.mostrarMissatge("3) Cercar via");
        Vista.mostrarMissatge("4) Mostrar totes les vies");
        Vista.mostrarMissatge("5) Eliminar via");
        Vista.mostrarMissatge("0) Tornar");
        Vista.mostrarMissatge("Selecciona una opció (0-5): ");
    }

    private static void mostrarSubmenuEscaladors() {
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