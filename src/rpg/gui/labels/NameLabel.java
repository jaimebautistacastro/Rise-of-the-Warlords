package rpg.gui.labels;

import rpg.gui.ui.NameLabelUI;

import javax.swing.*;

/**
 * Clase personalizada para mostrar una etiqueta de texto con un estilo específico para nombres.
 * La etiqueta utiliza una interfaz de usuario personalizada para su apariencia.
 */
public class NameLabel extends JLabel {

    /**
     * Constructor de la clase NameLabel.
     * Inicializa la etiqueta con el nombre proporcionado y establece la interfaz de usuario personalizada.
     *
     * @param name El nombre que se mostrará en la etiqueta.
     */
    public NameLabel(String name) {
        super(name); // Establece el texto de la etiqueta al nombre proporcionado.
        setUI(new NameLabelUI()); // Aplica la interfaz de usuario personalizada para la etiqueta.
    }

    /**
     * Actualiza el texto de la etiqueta con un nuevo nombre.
     * También actualiza la interfaz de usuario para reflejar el cambio.
     *
     * @param name El nuevo nombre que se mostrará en la etiqueta.
     */
    public void updateLabel(String name) {
        setText(name); // Actualiza el texto de la etiqueta con el nuevo nombre.
        setUI(new NameLabelUI()); // Vuelve a aplicar la interfaz de usuario personalizada para actualizar la apariencia.
        revalidate(); // Recalcula el diseño de la etiqueta.
        repaint(); // Vuelve a dibujar la etiqueta para reflejar los cambios visuales.
    }
}