package controller;
import model.Trams;
import view.Vista;

import java.util.Scanner;

public class TramsController {
    public static Scanner scan = new Scanner(System.in);

    public static Trams crearTram(String via) {
        Vista.mostrarTitol("CREACIÓ TRAM");

        Vista.mostrarMissatge("Escriu la llargada del tram:");
        int llargada = scan.nextInt();
        scan.nextLine();
        Vista.mostrarMissatge("Escriu el grau de dificultat:");
        String grau_dificultat = scan.nextLine();

        return new Trams(via , llargada, grau_dificultat);
    }
}
