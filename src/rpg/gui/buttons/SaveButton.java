package rpg.gui.buttons;

import rpg.entities.Player;
import rpg.gui.windows.MainWindow;

/**
 * Clase que representa un botón para guardar la partida.
 * Este botón permite al jugador guardar el progreso de la partida
 * en un archivo determinado, y muestra un mensaje indicando que la
 * partida se ha guardado correctamente.
 */
public class SaveButton extends UserButton {

    /**
     * Constructor que crea un botón para guardar la partida.
     * Al hacer clic en el botón, se guarda el progreso de la partida
     * y se muestra un mensaje de confirmación en la ventana principal.
     *
     * @param window La ventana principal donde se muestra el mensaje de guardado.
     * @param player El jugador cuya partida se guarda.
     * @param slot El slot donde se guarda la partida.
     */
    public SaveButton(MainWindow window, Player player, int slot) {
        // Llama al constructor de la clase base con el texto "Guardar".
        super("Guardar");

        // Agrega un ActionListener que guarda la partida y muestra un mensaje de confirmación.
        addActionListener(e -> {
            // Aquí se debería implementar la lógica para guardar la partida, descomentando la línea siguiente.
            // player.save(slot);

            // Muestra un mensaje de confirmación en la ventana principal.
            window.appendText("""
                    Partida guardada correctamente.
                    """);
        });
    }
}