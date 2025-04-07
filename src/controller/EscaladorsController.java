package controller;

import model.Escaladors;
import view.Vista;

import java.util.Scanner;

public class EscaladorsController {
    public static Scanner scan = new Scanner(System.in);

    public static Escaladors crearEscalador() {
        Vista.mostrarTitol("CREACIÓ ESCALADOR");
        String nom = scan.nextLine();
        String alies = scan.nextLine();
        int edat = scan.nextInt();
        scan.nextLine();
        String nivell = scan.nextLine();
        int id_via = scan.nextInt();
        scan.nextLine();
        String estil_pref = scan.nextLine();
        Escaladors.TipusEstilPreferit tipusEstilPreferit = Escaladors.TipusEstilPreferit.valueOf(estil_pref);
        String historial = scan.nextLine();
        String fita = scan.nextLine();

        return new Escaladors(nom, alies, edat, nivell, id_via, tipusEstilPreferit, historial, fita);
    }
}
