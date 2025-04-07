package controller;

import model.Escoles;
import view.Vista;

import java.util.Scanner;

public class EscolesController {
    public static Scanner scan = new Scanner(System.in);

    public static Escoles crearEscola() {
        Vista.mostrarTitol("CREACIÓ ESCOLA");
        Vista.mostrarMissatge("Escriu el nom de l'escola:");
        String nom = scan.nextLine();
        Vista.mostrarMissatge("Escriu l'ubicació:");
        String lloc = scan.nextLine();
        Vista.mostrarMissatge("Escriu una breu descripció de com arribar:");
        String aproximacio = scan.nextLine();
        Vista.mostrarMissatge("Escriu quantes vies té:");
        int vies = scan.nextInt();
        scan.nextLine();
        Vista.mostrarMissatge("Escull quina popularitat té (BAIXA, MITJANA, ALTA):");
        String tipusPopularitatInput = scan.nextLine();
        Escoles.TipusPopularitat tipusPopularitat = Escoles.TipusPopularitat.valueOf(tipusPopularitatInput);
        Vista.mostrarMissatge("Quines prohibicions durant certes èpoques de l’any té? (Ex: Nidificació d’aus)");
        String restriccions = scan.nextLine();

        return new Escoles(nom, lloc, aproximacio, vies, tipusPopularitat, restriccions);
    }
}
