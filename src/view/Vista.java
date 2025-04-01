package view;

public class Vista {
    public static void mostrarMissatge(String msg) {
        System.out.println(msg);
    }

    public static void mostrartTitol(String name) {
        String barras = "";
        for (int i = 0; i < (name.length() + 8); i++) barras += "-";

        Vista.mostrarMissatge(barras);
        Vista.mostrarMissatge("--- " + name + " ---");
        Vista.mostrarMissatge(barras);
    }
}