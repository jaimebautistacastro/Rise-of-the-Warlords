package rpg.gui.buttons;

import rpg.gui.windows.MainWindow;

/**
 * Clase que representa un boton para huir en la interfaz del juego.
 * Este boton permite que el jugador intente huir de una batalla.
 */
public class FleeButton extends UserButton {

    /**
     * Constructor del boton de huir.
     * Establece el texto del boton como "Huir" y agrega un escuchador de eventos
     * para intentar que el jugador huya de la batalla cuando el boton es presionado.
     *
     * @param game La ventana principal del juego donde se ejecuta la accion de huir.
     */
    public FleeButton(MainWindow game) {
        super("Huir");  // Establece el texto del boton como "Huir"
        // Agrega un ActionListener que ejecuta la accion de huir en el juego
        addActionListener(e -> game.tryToFlee());
    }
}