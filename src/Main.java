import controller.*;
import dao.DBConnection;
import dao.sqlite.*;
import view.Vista;
import model.*;
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
                scanOpcio(5);
                switchEscola();
                break;
            case 2:
                Vista.mostrarSubmenuSectors();
                scanOpcio(5);
                break;
            case 3:
                Vista.mostrarSubmenuVies();
                scanOpcio(5);
                break;
            case 4:
                Vista.mostrarSubmenuEscaladors();
                scanOpcio(5);
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
                    Vista.mostrarMissatge("Digues la id del escalador que vols cercar");
                    String id = scan.nextLine();
                    Vista.mostrarMissatge(SQLiteEscaladorsDAO.llistarID(conexio,id));
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
                    Vista.mostrarMissatge("Error al actualitzar l'escalador: " + e.getMessage());
                }
                Vista.mostrarMissatge("Pulsa enter per continuar...");
                scan.nextLine();
                break;
            case 3:
                try {
                    Vista.mostrarMissatge("Digues la id del sector que vols cercar");
                    String id = scan.nextLine();
                    Vista.mostrarMissatge(SQLiteSectorsDAO.llistarID(conexio,id));
                } catch (Exception e) {
                    Vista.mostrarMissatge("Error al cercar el sector: " + e.getMessage());
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
            default:
                break;
        }
    }
}