import controller.*;
import dao.DBConnection;
import view.Vista;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    private static int opcio = 0;
    private static boolean cont = true;

    public static void main(String[] args) {

        Connection conexio =  DBConnection.connectar();
        if (conexio == null) {
            Vista.mostrarMissatge("[Error] La base de dades no existeix o no s'ha trobat!");
            return;
        }

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
                EscolesController.mostrarSubmenuEscoles();
                scanOpcio(5);
                break;
            case 2:
                SectorsController.mostrarSubmenuSectors();
                scanOpcio(5);
                break;
            case 3:
                ViesController.mostrarSubmenuVies();
                scanOpcio(5);
                break;
            case 4:
                EscaladorsController.mostrarSubmenuEscaladors();
                scanOpcio(5);
                break;
            default:
                Vista.mostrarMissatge("Has finalitzat el programa.");
                cont = false;
                break;
        }
    }

    private static void switchEscola() {
        switch (opcio) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
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


}