package rpg.gui.buttons.events;

import rpg.entities.Player;
import rpg.gui.windows.MainWindow;
import rpg.gui.windows.StartWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Evento que maneja la carga de una partida guardada.
 * Implementa la interfaz ActionListener para reaccionar a los eventos de acción en los botones.
 */
public class LoadFileEvent implements ActionListener {

    /**
     * El slot donde se encuentra la partida guardada.
     */
    private int slot;

    /**
     * Ventana de inicio desde la que se carga la partida.
     */
    private StartWindow startWindow;

    /**
     * Constructor del evento de carga de partida.
     *
     * @param slot el número de slot de la partida guardada.
     * @param startWindow la ventana de inicio donde se activa la carga de la partida.
     */
    public LoadFileEvent(int slot, StartWindow startWindow) {
        this.slot = slot;
        this.startWindow = startWindow;
    }

    /**
     * Metodo que se ejecuta cuando se realiza un evento de acción (clic en el boton de cargar partida).
     * Carga la partida guardada desde el slot especificado, cierra la ventana de inicio
     * y abre la ventana principal del juego con los datos del jugador cargados.
     *
     * @param e el evento de acción (clic en el boton).
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Carga el jugador desde el archivo guardado en el slot indicado
        Player player = Player.load(slot);

        // Cierra la ventana de inicio
        startWindow.dispose();

        // Abre la ventana principal del juego con el jugador cargado
        new MainWindow(player, slot);
    }
}