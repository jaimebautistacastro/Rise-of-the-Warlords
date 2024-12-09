package rpg.Utils;

import rpg.entities.Player;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * La clase FileManager proporciona métodos para cargar y guardar el estado del juego en archivos.
 * Utiliza la serialización para guardar y cargar los objetos del jugador. El estado del jugador se guarda
 * en archivos con un formato binario.
 */
public class FileManager {

    /**
     * La ruta base donde se almacenan los archivos de guardado.
     */
    private static final String BASE_PATH = "files/";

    /**
     * Carga el estado del jugador desde un archivo de guardado específico.
     * El archivo es identificado por el número de ranura (slot), que se utiliza para nombrar el archivo.
     *
     * @param slot El número de ranura que representa el archivo de guardado (por ejemplo, ranura 1, ranura 2, etc.).
     * @return El objeto Player que representa al jugador cargado desde el archivo.
     * @throws FileNotFoundException Si no se encuentra el archivo de guardado en la ranura especificada.
     */
    public static Player loadGame(int slot) throws FileNotFoundException {

        Player player;
        String fileName = BASE_PATH + "player_" + slot + ".dat";
        try {
            player = (Player) new ObjectInputStream(
                    new FileInputStream(fileName)).readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new FileNotFoundException("No se encontró el archivo");
        }
        return player;
    }

    /**
     * Guarda el estado del jugador en un archivo de guardado específico.
     * El archivo es identificado por el número de ranura (slot), que se utiliza para nombrar el archivo.
     *
     * @param player El objeto Player que representa al jugador a guardar.
     * @param slot El número de ranura donde se guardará el archivo (por ejemplo, ranura 1, ranura 2, etc.).
     */
    public static void saveGame(Player player, int slot) {

        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(
                    new FileOutputStream(BASE_PATH + "player_" + slot + ".dat"));
            oos.writeObject(player);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}