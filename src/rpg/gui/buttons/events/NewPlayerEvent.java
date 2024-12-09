package rpg.gui.buttons.events;

import rpg.gui.windows.NewFileWindow;
import rpg.gui.windows.StartWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Evento que maneja la acción de crear un nuevo jugador.
 * Implementa la interfaz ActionListener para reaccionar a los eventos de acción en los botones.
 */
public class NewPlayerEvent implements ActionListener {

    /**
     * El slot donde se guardará la nueva partida.
     */
    private int slot;

    /**
     * Ventana principal del inicio del juego.
     */
    private StartWindow startWindow;

    /**
     * Constructor del evento de creación de un nuevo jugador.
     *
     * @param slot el número de slot donde se guardará la nueva partida.
     * @param startWindow la ventana principal del inicio del juego.
     */
    public NewPlayerEvent(int slot, StartWindow startWindow) {
        this.slot = slot;
        this.startWindow = startWindow;
    }

    /**
     * Metodo que se ejecuta cuando se realiza un evento de acción (clic en el boton de crear nuevo jugador).
     * Cierra la ventana de inicio y abre la ventana para crear un nuevo jugador.
     *
     * @param e el evento de acción (clic en el boton).
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Cierra la ventana de inicio
        startWindow.dispose();

        // Abre la ventana para crear un nuevo jugador
        new NewFileWindow(slot);
    }
}