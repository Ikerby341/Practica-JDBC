package dao;

import view.Vista;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String rutaDB = "BBDD_Escalada.db";

    /**
     * Connectar amb una BD indicada en el paràmetre 'url'.
     * @return Connexió amb la BD o 'null' si no s'ha pogut connectar
     */
    public static Connection connectar() {
        Connection connexio = null;
        File dbFile = new File(rutaDB);

        if (dbFile.exists()) {
            try {
                connexio = DriverManager.getConnection("jdbc:sqlite:" + rutaDB);
                Vista.mostrarMissatge("Connexió establerta amb la base de dades.");
            } catch (SQLException e) {
                Vista.mostrarMissatge(e.getMessage());
            }
        }

        return connexio;
    }

    /**
     * Desconnectar d'una BD.
     * @param connexio Connexió amb la BD
     */
    public static void desconectar(Connection connexio) {
        try {
            if (connexio != null) connexio.close();
        } catch (SQLException e) {
            Vista.mostrarMissatge(e.getMessage());
        }
    }

    public static Connection getConnexio() {
        return connectar();
    }
}
