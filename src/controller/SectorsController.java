package controller;

import model.Sectors;
import view.Vista;

import java.util.Scanner;

public class SectorsController {
    public static Scanner scan = new Scanner(System.in);

    public static Sectors crearSectors() {
        Vista.mostrarTitol("CREACIÓ SECTOR");
        Vista.mostrarMissatge("Escriu el nom del sector:");
        String nom = scan.nextLine();
        Vista.mostrarMissatge("Escriu la latitud:");
        String latitud = scan.nextLine();
        Vista.mostrarMissatge("Escriu la longitud:");
        long longitud = scan.nextLong();
        scan.nextLine();
        Vista.mostrarMissatge("Escriu una breu descripció de com arribar:");
        String aproximacio = scan.nextLine();
        Vista.mostrarMissatge("Escriu quantes vies té:");
        int numVies = scan.nextInt();
        scan.nextLine();
        Vista.mostrarMissatge("Escull quina popularitat té (BAIXA, MITJANA, ALTA):");
        String tipusPopularitat = scan.nextLine();
        Vista.mostrarMissatge("Quines restriccions té? (Ex: Nidificació d’aus)");
        String restriccions = scan.nextLine();

        return new Sectors(nom, latitud, longitud, aproximacio, numVies, tipusPopularitat, restriccions);
    }
}
