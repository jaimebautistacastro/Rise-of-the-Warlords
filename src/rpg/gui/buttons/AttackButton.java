package rpg.gui.buttons;

import rpg.gui.windows.MainWindow;
import rpg.gui.buttons.events.AttackEvent;

/**
 * Clase que representa el boton de ataque en la interfaz grafica.
 * Hereda de {@link UserButton} y asocia el evento de ataque al boton.
 */
public class AttackButton extends UserButton {

    /**
     * Constructor del boton de ataque.
     * Crea un boton con la etiqueta "Atacar" y asocia el evento de ataque.
     *
     * @param game la ventana principal del juego.
     */
    public AttackButton(MainWindow game) {
        // Llama al constructor de la clase base para inicializar el boton con el texto "Atacar"
        super("Atacar");

        // Asocia el evento de ataque al boton
        addActionListener(new AttackEvent(game));
    }
}