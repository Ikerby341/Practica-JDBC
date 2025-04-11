package controller;
import model.Vies;
import view.Vista;

import java.util.Scanner;

public class ViesController {
    public static Scanner scan = new Scanner(System.in);
    public static Vies crearVia() {
        Vista.mostrarTitol("CREACIÓ VIA");
        Vista.mostrarMissatge("Escriu el tipus de la Via:");
        String tipus = scan.nextLine();
        Vista.mostrarMissatge("Escriu el nom de la Via:");
        String nom = scan.nextLine();
        Vista.mostrarMissatge("Escriu la llargada:");
        int llargada = scan.nextInt();
        scan.nextLine();
        Vista.mostrarMissatge("Escriu el grau de dificultat:");
        String dificultat = scan.nextLine();
        Vista.mostrarMissatge("Escriu l'orientació:");
        String orientacio = scan.nextLine();
        Vista.mostrarMissatge("Escriu l'estat:");
        String estat = scan.nextLine();
        Vista.mostrarMissatge("Escriu el nom de l'escola:");
        String escola = scan.nextLine();
        Vista.mostrarMissatge("Escriu l'id del sector:");
        int sectorID = scan.nextInt();
        scan.nextLine();
        Vista.mostrarMissatge("Escriu el tipus d'ancoratges (friends, tascons, bagues, pitons, tricams, bigbros, spits, parabolts o quimics):");
        String ancoratges = scan.nextLine();
        Vista.mostrarMissatge("Escriu el tipus de roca (conglomerat, granit, calcaris, arenisca o altres):");
        String tipusRoca = scan.nextLine();
        Vista.mostrarMissatge("Escriu el nom del creador:");
        String creador = scan.nextLine();

        return new Vies(tipus, nom, llargada, dificultat, orientacio, estat, escola, sectorID, ancoratges, tipusRoca, creador);
    }
}
