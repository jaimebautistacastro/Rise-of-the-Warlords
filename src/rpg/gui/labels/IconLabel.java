package rpg.gui.labels;

import rpg.gui.ui.GameLabelUI;

import javax.swing.*;
import java.awt.*;

/**
 * Clase personalizada para mostrar una etiqueta con un icono.
 * La etiqueta se configura con un icono específico y tiene un tamaño basado en las dimensiones del icono.
 */
public class IconLabel extends JLabel {

    protected ImageIcon icon; // Icono que se mostrará en la etiqueta.

    /**
     * Constructor de la clase IconLabel.
     * Inicializa la etiqueta con el icono proporcionado y establece sus componentes visuales.
     *
     * @param icon El icono que se mostrará en la etiqueta.
     */
    public IconLabel(ImageIcon icon) {
        this.icon = icon; // Asigna el icono proporcionado a la etiqueta.
        setIcon(icon); // Establece el icono de la etiqueta.
        initComponents(); // Inicializa los componentes adicionales de la etiqueta.
        setUI(new GameLabelUI(getPreferredSize(), icon)); // Establece la interfaz personalizada para la etiqueta.
    }

    /**
     * Inicializa los componentes visuales de la etiqueta.
     * Establece el tamaño preferido de la etiqueta basado en el tamaño del icono.
     */
    public void initComponents() {
        setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight())); // Establece el tamaño preferido de la etiqueta.
    }
}