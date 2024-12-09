package rpg.gui.buttons;

import rpg.gui.buttons.events.NewPlayerEvent;
import rpg.gui.windows.StartWindow;

/**
 * Clase que representa un botón para iniciar una nueva partida.
 * Este botón permite al jugador crear un nuevo archivo de partida en el
 * slot seleccionado y acceder a la ventana correspondiente.
 */
public class NewFileButton extends UserButton {

    private int slot;
    private StartWindow startWindow;

    /**
     * Constructor que crea un botón para iniciar una nueva partida en un slot específico.
     * El texto del botón se establece como "Nueva Partida" y se asocia un evento
     * que maneja la creación de una nueva partida al hacer clic en el botón.
     *
     * @param slot El número de slot donde se almacenará la nueva partida.
     * @param startWindow La ventana de inicio desde donde se invoca la creación de la partida.
     */
    public NewFileButton(int slot, StartWindow startWindow) {

        // Llama al constructor de la clase base con el texto "Nueva Partida".
        super("Nueva Partida");

        // Asigna el slot y la ventana de inicio para su uso posterior.
        this.slot = slot;
        this.startWindow = startWindow;

        // Asocia un ActionListener que manejará la creación de la nueva partida
        addActionListener(new NewPlayerEvent(slot, startWindow));
    }
}