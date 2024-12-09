package rpg.gui.buttons;

/**
 * Clase que representa un boton de salida en la interfaz.
 * Este boton cierra la aplicacion cuando es presionado.
 */
public class ExitButton extends UserButton {

    /**
     * Constructor del boton de salida.
     * Establece el texto del boton como "Salir" y agrega un escuchador de eventos
     * para cerrar la aplicacion cuando el boton es presionado.
     */
    public ExitButton() {
        super("Salir");  // Establece el texto del boton como "Salir"
        // Agrega un ActionListener para cerrar la aplicacion
        addActionListener(e -> System.exit(0));  // Cierra la aplicacion cuando se hace clic
    }
}
