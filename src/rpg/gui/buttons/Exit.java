package rpg.gui.buttons;

import javax.swing.*;

/**
 * Clase que representa un boton de salida.
 * Este boton cierra la aplicacion cuando es presionado.
 */
public class Exit extends JButton {

    /**
     * Constructor del boton de salida.
     * Establece el texto del boton y agrega un escuchador de eventos
     * para cerrar la aplicacion cuando el boton es presionado.
     */
    public Exit() {
        super("Exit");  // Establece el texto del boton
        // Agrega un ActionListener para cerrar la aplicacion
        addActionListener(e -> System.exit(0));  // Cierra la aplicacion cuando se hace clic
    }
}