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
        String tipusPopularitatInput = scan.nextLine();
        Sectors.TipusPopularitat tipusPopularitat = Sectors.TipusPopularitat.valueOf(tipusPopularitatInput);
        String restriccions = scan.nextLine();

        return new Sectors(nom, latitud, longitud, aproximacio, numVies, tipusPopularitat, restriccions);
    }
}
