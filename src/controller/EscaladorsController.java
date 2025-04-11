package controller;

import model.Escaladors;
import view.Vista;

import java.util.Scanner;

public class EscaladorsController {
    public static Scanner scan = new Scanner(System.in);

    public static Escaladors crearEscalador() {
        Vista.mostrarTitol("CREACIÓ ESCALADOR");
        Vista.mostrarMissatge("Escriu el nom de l'escalador:");
        String nom = scan.nextLine();
        Vista.mostrarMissatge("Escriu l'alias de l'escalador:");
        String alies = scan.nextLine();
        Vista.mostrarMissatge("Escriu l'edat de l'escalador:");
        int edat = scan.nextInt();
        scan.nextLine();
        Vista.mostrarMissatge("Escriu el nivell de l'escalador:");
        String nivell = scan.nextLine();
        Vista.mostrarMissatge("Escriu l'id de la via favorita:");
        int id_via = scan.nextInt();
        scan.nextLine();
        Vista.mostrarMissatge("Escriu l'estil preferit (esportiva, classica o gel):");
        String estil_pref = scan.nextLine();
        Vista.mostrarMissatge("Escriu el historial d'escalades:");
        String historial = scan.nextLine();
        Vista.mostrarMissatge("Escriu la fita més important:");
        String fita = scan.nextLine();

        return new Escaladors(nom, alies, edat, nivell, id_via, estil_pref, historial, fita);
    }
}
