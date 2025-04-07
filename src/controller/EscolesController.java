package controller;

import view.Vista;

import java.util.Scanner;

public class EscolesController {
    private final String nom;
    private final String lloc;
    private final String aproximacio;
    private final int num_vies;
    private final TipusPopularitat popularitat;
    private final String restriccions;

    public static Scanner scan = new Scanner(System.in);

    public EscolesController(String nom, String lloc, String aproximacio, int num_vies, TipusPopularitat popularitat, String restriccions) {
        this.nom = nom;
        this.lloc = lloc;
        this.aproximacio = aproximacio;
        this.num_vies = num_vies;
        this.popularitat = popularitat;
        this.restriccions = restriccions;
    }

    public static void mostrarSubmenuEscoles() {
        Vista.mostrartTitol("GESTIÓ ESCOLES");
        Vista.mostrarMissatge("1) Crear escola");
        Vista.mostrarMissatge("2) Modificar escola");
        Vista.mostrarMissatge("3) Cercar escola");
        Vista.mostrarMissatge("4) Mostrar totes les escoles");
        Vista.mostrarMissatge("5) Eliminar escoles");
        Vista.mostrarMissatge("0) Tornar");
        Vista.mostrarMissatge("Selecciona una opció (0-5): ");
    }

    private enum TipusPopularitat {
        BAIXA,
        MITJANA,
        ALTA
    }

    public static void crearEscola() {
        Vista.mostrartTitol("CREACIÓ ESCOLA");
        Vista.mostrarMissatge("Nom de l'escola?");
        String nom = scan.nextLine();
        Vista.mostrarMissatge("On está ubicat?");
        String lloc = scan.nextLine();
        Vista.mostrarMissatge("Escriu una breu descripció de com arribar:");
        String aproximacio = scan.nextLine();
        Vista.mostrarMissatge("Quantes vies té?");
        int vies = scan.nextInt();
        scan.nextLine();
        Vista.mostrarMissatge("Quina popularitat té? (BAIXA, MITJANA, ALTA)");
        String tipusPopularitatInput = scan.nextLine();
        TipusPopularitat tipusPopularitat = TipusPopularitat.valueOf(tipusPopularitatInput);
        Vista.mostrarMissatge("Quines prohibicions durant certes èpoques de l’any té? (Ex: Nidificació d’aus)");
        scan.nextLine();
    }

    public String getNom() {
        return nom;
    }

    public String getLloc() {
        return lloc;
    }

    public String getAproximacio() {
        return aproximacio;
    }

    public int getVies() {
        return num_vies;
    }

    public TipusPopularitat getPopularitat() {
        return popularitat;
    }

    public String getRestriccions() {
        return restriccions;
    }
}
