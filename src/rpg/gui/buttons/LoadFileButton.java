package rpg.gui.buttons;

import rpg.gui.buttons.events.LoadFileEvent;
import rpg.gui.windows.StartWindow;

/**
 * Clase que representa un botón de carga de partida.
 * Este botón permite al jugador cargar una partida guardada desde un slot específico.
 * Extiende de la clase {@link NewFileButton} para reutilizar la funcionalidad de
 * creación de nuevas partidas y luego sobrescribirla para permitir la carga de archivos.
 */
public class LoadFileButton extends NewFileButton {

    /**
     * Constructor que crea un botón de carga de partida para un slot específico.
     * Se configura el texto del botón y se reemplaza el listener de acción
     * para cargar la partida correspondiente al slot indicado.
     *
     * @param slot El número de slot en el que se guardó la partida.
     * @param startWindow La ventana de inicio desde la que se invoca la carga de partida.
     */
    public LoadFileButton(int slot, StartWindow startWindow) {
        // Llama al constructor de la clase base con el slot y la ventana de inicio.
        super(slot, startWindow);

        // Cambia el texto del botón a "Cargar Partida"
        setText("Cargar Partida");

        // Elimina el ActionListener anterior para evitar conflictos con el comportamiento base.
        removeActionListener(getActionListeners()[0]);

        // Añade un nuevo ActionListener que manejará la carga de la partida.
        addActionListener(new LoadFileEvent(slot, startWindow));
    }
}