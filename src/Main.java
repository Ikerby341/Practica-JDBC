import controller.*;
import dao.DBConnection;
import dao.sqlite.*;
import view.Vista;
import model.*;

import java.security.spec.InvalidParameterSpecException;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    private static int opcio = 0;
    private static boolean cont = true;

    public static void main(String[] args) {
        Connection conexio =  DBConnection.connectar();

        if (conexio == null) {
            Vista.mostrarMissatge("[Error] La base de dades no existeix o no s'ha trobat!");
            return;
        }

        while(cont) {
            Vista.mostrarMenuPrincipal();
            try {
                scanOpcio(4);
                switchPrincipal();
            } catch (Exception e) {
                Vista.mostrarMissatge(e.getMessage());
            }
        }
    }

    /* Comprovació */

    private static void scanOpcio(int op) {
        opcio = scan.nextInt();
        scan.nextLine();
        comprovarOpcio(op);
    }

    private static void comprovarOpcio(int op) {
        while (opcio < 0 || opcio > op) {
            Vista.mostrarMissatge("Opció incorrecta, torna a escollir!");
            Vista.mostrarMissatge("Selecciona una opció (0-" + op + "): ");
            opcio = scan.nextInt();
            scan.nextLine();
        }
    }

    /* Menu principal */

    private static void switchPrincipal() {
        switch (opcio) {
            case 1:
                Vista.mostrarSubmenuEscoles();
                scanOpcio(7);
                switchEscola();
                break;
            case 2:
                Vista.mostrarSubmenuSectors();
                scanOpcio(6);
                switchSectors();
                break;
            case 3:
                Vista.mostrarSubmenuVies();
                scanOpcio(9);
                switchVies();
                break;
            case 4:
                Vista.mostrarSubmenuEscaladors();
                scanOpcio(6);
                switchEscaladors();
                break;
            default:
                Vista.mostrarMissatge("Has finalitzat el programa.");
                cont = false;
                break;
        }
    }


    /* SubMenu Gestio Escola */

    private static void switchEscola() {
        Connection conexio = DBConnection.getConnexio();
        switch (opcio) {
            case 1:
                try{
                    Escoles escola = EscolesController.crearEscola();
                    SQLiteEscolesDAO.crear(conexio,escola);
                }catch (Exception e){
                    Vista.mostrarMissatge("Error al crear l'escola: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 2:
                try {
                    Vista.mostrarMissatge("Digues el nom de la escola que vols actualitzar");
                    String id = scan.nextLine();
                    Vista.mostrarMissatge("Digues el que vols canviar (nom,lloc,num_vies...)");
                    String quequiero = scan.nextLine();
                    Vista.mostrarMissatge("Digues el que vols posar");
                    String comoquiero = scan.nextLine();
                    SQLiteEscolesDAO.actualitzar(conexio, id, quequiero, comoquiero);
                } catch (Exception e) {
                    Vista.mostrarMissatge("Error al actualitzar l'escola: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 3:
                try {
                    Vista.mostrarMissatge("Digues el nom de la escola que vols cercar");
                    String nom = scan.nextLine();
                    Vista.mostrarMissatge(SQLiteEscolesDAO.llistarID(conexio,nom));
                } catch (Exception e) {
                    Vista.mostrarMissatge("Error al cercar l'escola: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 4:
                try {
                    Vista.mostrarMissatge(SQLiteEscolesDAO.llistarTot(conexio));
                } catch (Exception e){
                    Vista.mostrarMissatge("Error al llistar les escoles: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 5:
                try {
                    Vista.mostrarMissatge("Digues el nom de la escola que vols eliminar");
                    String nomE = scan.nextLine();
                    SQLiteEscolesDAO.esborrar(conexio, nomE);
                } catch (Exception e) {
                    Vista.mostrarMissatge("Error al eliminar l'escola: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 6:
                try{
                    Vista.mostrarMissatge(SQLiteEscolesDAO.llistarAmbRest(conexio));
                } catch (Exception e){
                    Vista.mostrarMissatge("Error al llistar les escoles: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 7:
                try{
                    Vista.mostrarMissatge("Digues el nom de l'escola que vols actualitzar");
                    String escola = scan.nextLine();
                    SQLiteEscolesDAO.actualitzarVies(conexio, escola);
                } catch (Exception e){
                    Vista.mostrarMissatge("Error al actualitzar les escoles: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            default:
                break;
        }
    }

    /* SubMenu Gestio Escaladors */

    private static void switchEscaladors() {
        Connection conexio = DBConnection.getConnexio();
        switch (opcio) {
            case 1:
                try{
                    Escaladors escalador = EscaladorsController.crearEscalador();
                    SQLiteEscaladorsDAO.crear(conexio,escalador);
                }catch (Exception e){
                    Vista.mostrarMissatge("Error al crear l'escalador: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 2:
                try {
                    Vista.mostrarMissatge("Digues la id del escalador que vols actualitzar");
                    String id = scan.nextLine();
                    Vista.mostrarMissatge("Digues el que vols canviar (nom,alies,num_vies...)");
                    String quequiero = scan.nextLine();
                    Vista.mostrarMissatge("Digues el que vols posar");
                    String comoquiero = scan.nextLine();
                    SQLiteEscaladorsDAO.actualitzar(conexio, id, quequiero, comoquiero);
                } catch (Exception e) {
                    Vista.mostrarMissatge("Error al actualitzar l'escalador: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 3:
                try {
                    Vista.mostrarMissatge("Digues el nom del escalador que vols cercar");
                    String nom = scan.nextLine();
                    Vista.mostrarMissatge(SQLiteEscaladorsDAO.llistarID(conexio,nom));
                } catch (Exception e) {
                    Vista.mostrarMissatge("Error al cercar l'escalador: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 4:
                try {
                    Vista.mostrarMissatge(SQLiteEscaladorsDAO.llistarTot(conexio));
                } catch (Exception e){
                    Vista.mostrarMissatge("Error al llistar els escaladors: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 5:
                try {
                    Vista.mostrarMissatge("Digues la id del escalador que vols eliminar");
                    String idE = scan.nextLine();
                    SQLiteEscaladorsDAO.esborrar(conexio, idE);
                } catch (Exception e) {
                    Vista.mostrarMissatge("Error al eliminar l'escalador: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 6:
                try {
                    Vista.mostrarMissatge("Introdueix el nivell màxim assolit:");
                    String nivellMaxim = scan.nextLine();
                    Vista.mostrarMissatge(SQLiteEscaladorsDAO.llistarNivellMaxEscaladors(conexio, nivellMaxim));
                } catch (Exception e){
                    Vista.mostrarMissatge("Error al llistar els escaladors: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            default:
                break;
        }
    }

    /* SubMenu Gestio Sectors */

    private static void switchSectors() {
        Connection conexio = DBConnection.getConnexio();
        switch (opcio) {
            case 1:
                try{
                    Sectors sector = SectorsController.crearSectors();
                    SQLiteSectorsDAO.crear(conexio,sector);
                }catch (Exception e){
                    Vista.mostrarMissatge("Error al crear el sector: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 2:
                try {
                    Vista.mostrarMissatge("Digues la id del sector que vols actualitzar");
                    String id = scan.nextLine();
                    Vista.mostrarMissatge("Digues el que vols canviar (nom,latitud,num_vies...)");
                    String quequiero = scan.nextLine();
                    Vista.mostrarMissatge("Digues el que vols posar");
                    String comoquiero = scan.nextLine();
                    SQLiteSectorsDAO.actualitzar(conexio, id, quequiero, comoquiero);
                } catch (Exception e) {
                    Vista.mostrarMissatge("Error al actualitzar el sector: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 3:
                try {
                    Vista.mostrarMissatge("Digues el nom del sector que vols cercar");
                    String nom = scan.nextLine();
                    Vista.mostrarMissatge(SQLiteSectorsDAO.llistarID(conexio,nom));
                } catch (Exception e) {
                    Vista.mostrarMissatge("Error al cercar el nom del sector: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 4:
                try {
                    Vista.mostrarMissatge(SQLiteSectorsDAO.llistarTot(conexio));
                } catch (Exception e){
                    Vista.mostrarMissatge("Error al llistar els sectors: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 5:
                try {
                    Vista.mostrarMissatge("Digues la id del sector que vols eliminar");
                    String idS = scan.nextLine();
                    SQLiteSectorsDAO.esborrar(conexio, idS);
                } catch (Exception e) {
                    Vista.mostrarMissatge("Error al eliminar el sector: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 6:
                try {
                    Vista.mostrarMissatge("Digues el num de vies mínim que ha de tenir");
                    int numV = scan.nextInt();
                    scan.nextLine();
                    Vista.mostrarMissatge(SQLiteSectorsDAO.llistarAmbNumVies(conexio,numV));
                } catch (Exception e){
                    Vista.mostrarMissatge("Error al llistar els sectors: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            default:
                break;
        }
    }

    /* SubMenu Gestio Vies */

    private static void switchVies() {
        Connection conexio = DBConnection.getConnexio();
        switch (opcio) {
            case 1:
                try{
                    Vies via = ViesController.crearVia();
                    SQLiteViesDAO.crear(conexio,via);
                }catch (Exception e){
                    Vista.mostrarMissatge("Error al crear la via: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 2:
                try {
                    Vista.mostrarMissatge("Digues la id de la via que vols actualitzar");
                    String id = scan.nextLine();
                    Vista.mostrarMissatge("Digues el que vols canviar (nom,llargada,grau_dificultat...)");
                    String quequiero = scan.nextLine();
                    Vista.mostrarMissatge("Digues el que vols posar");
                    String comoquiero = scan.nextLine();
                    SQLiteViesDAO.actualitzar(conexio, id, quequiero, comoquiero);
                } catch (Exception e) {
                    Vista.mostrarMissatge("Error al actualitzar la via: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 3:
                try {
                    Vista.mostrarMissatge("Digues el nom de la via que vols cercar");
                    String nom = scan.nextLine();
                    Vista.mostrarMissatge(SQLiteViesDAO.llistarID(conexio,nom));
                } catch (Exception e) {
                    Vista.mostrarMissatge("Error al cercar la via: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 4:
                try {
                    Vista.mostrarMissatge(SQLiteViesDAO.llistarTot(conexio));
                } catch (Exception e){
                    Vista.mostrarMissatge("Error al llistar les vies: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 5:
                try {
                    Vista.mostrarMissatge("Digues la id de la via que vols eliminar");
                    String idS = scan.nextLine();
                    SQLiteViesDAO.esborrar(conexio, idS);
                } catch (Exception e) {
                    Vista.mostrarMissatge("Error al eliminar la via: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 6:
                try{
                    Vista.mostrarMissatge("Digues el nom de l'escola per la qual vols filtrar");
                    String escola = scan.nextLine();
                    Vista.mostrarMissatge(SQLiteViesDAO.llistarTotPerEscola(conexio,escola));
                } catch (Exception e){
                    Vista.mostrarMissatge("Error al llistar les vies: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 7:
                try{
                    Vista.mostrarMissatge("Cercar vies per dificultat en un rang (via, grau, sector, escola)");
                    Vista.mostrarMissatge("Introdueix el rang inicial:");
                    String difficultat1 = scan.nextLine();
                    Vista.mostrarMissatge("Introdueix el rang final:");
                    String difficultat2 = scan.nextLine();
                    Vista.mostrarMissatge(SQLiteViesDAO.llistarPerRang(conexio,difficultat1,difficultat2));
                } catch (Exception e){
                    Vista.mostrarMissatge("Error al llistar les vies per rang: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 8:
                try{
                    Vista.mostrarMissatge("Digues l'estat pel qual vols filtrar (Apte, Construcció, Tancada)");
                    String estat = scan.nextLine();
                    if (estat.equals("Apte") || estat.equals("Contstruccio") || estat.equals("Tancada")){
                        Vista.mostrarMissatge(SQLiteViesDAO.llistarPerEstat(conexio,estat));
                    } else {
                        throw new InvalidParameterSpecException("L'estat ha de ser Apte, Construcció o Tancada");
                    }
                } catch (Exception e){
                    Vista.mostrarMissatge("Error al llistar les vies: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 9:
                try{
                    Vista.mostrarMissatge("Digues el nom de l'escola per la qual vols filtrar");
                    String escola = scan.nextLine();
                    Vista.mostrarMissatge(SQLiteViesDAO.llistarPerEscolaLlargada(conexio,escola));
                } catch (Exception e){
                    Vista.mostrarMissatge("Error al llistar les vies: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            default:
                break;
        }
    }
}