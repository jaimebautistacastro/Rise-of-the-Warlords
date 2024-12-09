package rpg.gui.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;

/**
 * Clase personalizada para la interfaz de usuario de la barra de estado.
 */
public class StatusBarUI extends BasicPanelUI {

    private Dimension dimension;

    /**
     * Constructor de la clase.
     *
     * @param dimension Dimensiones de la barra de estado.
     */
    public StatusBarUI(Dimension dimension) {
        this.dimension = dimension;
    }

    /**
     * Metodo encargado de instalar los valores predeterminados para el panel de la barra de estado.
     *
     * @param p Panel sobre el que se aplican los valores predeterminados.
     */
    @Override
    protected void installDefaults(JPanel p) {
        p.setBounds(0, 0, dimension.width, 77);
        p.getInsets(new Insets(0, 0, 0, 0));
        p.setOpaque(false);
    }

    /**
     * Metodo encargado de obtener el tamaño preferido de la barra de estado.
     *
     * @param c Componente sobre el que se calcula el tamaño.
     * @return El tamaño preferido de la barra de estado.
     */
    @Override
    public Dimension getPreferredSize(JComponent c) {
        return new Dimension(dimension.width, 77);
    }
}