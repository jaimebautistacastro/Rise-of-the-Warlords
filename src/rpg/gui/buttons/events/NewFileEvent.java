package rpg.gui.buttons.events;

import rpg.entities.Player;
import rpg.gui.windows.MainWindow;
import rpg.gui.windows.NewFileWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Evento que maneja la creación de un nuevo archivo de partida.
 * Implementa la interfaz ActionListener para reaccionar a los eventos de acción en los botones.
 */
public class NewFileEvent implements ActionListener {

    /**
     * El slot donde se guarda la nueva partida.
     */
    private int slot;

    /**
     * Ventana de creación de un nuevo archivo de partida.
     */
    private NewFileWindow window;

    /**
     * Constructor del evento de creación de nuevo archivo de partida.
     *
     * @param slot el número de slot donde se guardará la nueva partida.
     * @param window la ventana de creación de nueva partida.
     */
    public NewFileEvent(int slot, NewFileWindow window) {
        this.slot = slot;
        this.window = window;
    }

    /**
     * Metodo que se ejecuta cuando se realiza un evento de acción (clic en el boton de crear nueva partida).
     * Crea un nuevo jugador con el nombre proporcionado en la ventana de creación de nueva partida,
     * guarda la partida en el slot indicado y abre la ventana principal del juego.
     *
     * @param e el evento de acción (clic en el boton).
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Cierra la ventana de creación de nueva partida
        window.dispose();

        // Crea un nuevo jugador con el nombre proporcionado en la ventana
        Player player = new Player(window.getName());

        // Guarda el jugador en el slot correspondiente
        player.save(slot);

        // Abre la ventana principal del juego con el jugador creado y guardado
        new MainWindow(player, slot);
    }
}