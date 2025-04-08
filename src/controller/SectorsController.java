package controller;

import model.Sectors;
import view.Vista;

import java.util.Scanner;

public class SectorsController {
    public static Scanner scan = new Scanner(System.in);

    public static Sectors crearSectors() {
        Vista.mostrarTitol("CREACIÓ SECTOR");
        String nom = scan.nextLine();
        String latitud = scan.nextLine();
        long longitud = scan.nextLong();
        scan.nextLine();
        String aproximacio = scan.nextLine();
        int numVies = scan.nextInt();
        scan.nextLine();
        String tipusPopularitat = scan.nextLine();
        String restriccions = scan.nextLine();

        return new Sectors(nom, latitud, longitud, aproximacio, numVies, tipusPopularitat, restriccions);
    }
}
