package rpg.gui.buttons;

import rpg.gui.buttons.events.NewFileEvent;
import rpg.gui.windows.NewFileWindow;

/**
 * Clase que representa un boton para crear un nuevo archivo de juego.
 */
public class CreateButton extends UserButton {

    /**
     * Constructor del boton de creacion de archivo.
     *
     * @param slot El slot en el que se guardara el nuevo archivo.
     * @param window La ventana en la que se creara el nuevo archivo.
     */
    public CreateButton(int slot, NewFileWindow window) {
        super("¡A la aventura!");  // Establece el texto del boton
        addActionListener(new NewFileEvent(slot, window));  // Agrega el escuchador de eventos
    }
}