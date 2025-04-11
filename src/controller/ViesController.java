package controller;
import model.Vies;
import view.Vista;

import java.util.Scanner;

public class ViesController {
    public static Scanner scan = new Scanner(System.in);
    public static Vies crearVia() {
        Vista.mostrarTitol("CREACIÓ VIA");
        Vista.mostrarMissatge("Escriu el tipus de la Via (esportiva, classica, gel):");
        String tipus = scan.nextLine();
        Vista.mostrarMissatge("Escriu el nom de la Via:");
        String nom = scan.nextLine();
        Vista.mostrarMissatge("Escriu la llargada:");
        int llargada = scan.nextInt();
        scan.nextLine();
        Vista.mostrarMissatge("Escriu el grau de dificultat (4,4+,5,5+,6a,6a+,6b,6b+,6c,6c+,7a,7a+,7b,7b+,7c,7c+,8a,8a+,8b,8b+,8c,8c+,9a,9a+,9b,9b+,9c,9c+):");
        String dificultat = scan.nextLine();
        Vista.mostrarMissatge("Escriu l'orientació (N,NE,NO,SE,SO,E,O,S):");
        String orientacio = scan.nextLine();
        Vista.mostrarMissatge("Escriu l'estat (apte, construccio, tancada):");
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
