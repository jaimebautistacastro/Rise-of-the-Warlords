package rpg.gui.ui;

import rpg.gui.internalFrames.InternalStatusBar;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;

/**
 * Clase personalizada para la interfaz de usuario de un marco interno transparente.
 */
public class TransparentFrameUI extends BasicInternalFrameUI {

    private Dimension dimension;

    /**
     * Constructor de la clase.
     *
     * @param frame El marco interno al que se aplica la interfaz personalizada.
     * @param dimension Las dimensiones del marco.
     */
    public TransparentFrameUI(JInternalFrame frame, Dimension dimension) {
        super(frame);
        this.dimension = dimension;
    }

    /**
     * Metodo que obtiene el tamaño preferido del marco.
     *
     * @param x Componente sobre el que se calcula el tamaño.
     * @return El tamaño preferido del marco.
     */
    @Override
    public Dimension getPreferredSize(JComponent x) {
        return dimension;
    }

    /**
     * Metodo que obtiene el tamaño minimo del marco.
     *
     * @param x Componente sobre el que se calcula el tamaño.
     * @return El tamaño minimo del marco.
     */
    @Override
    public Dimension getMinimumSize(JComponent x) {
        return getPreferredSize(x);
    }

    /**
     * Metodo que obtiene el tamaño maximo del marco.
     *
     * @param x Componente sobre el que se calcula el tamaño.
     * @return El tamaño maximo del marco.
     */
    @Override
    public Dimension getMaximumSize(JComponent x) {
        return getPreferredSize(x);
    }

    /**
     * Metodo encargado de instalar los valores predeterminados del marco.
     */
    @Override
    protected void installDefaults() {
        super.installDefaults();
        frame.setOpaque(false);
        frame.setBorder(null);
    }

    /**
     * Metodo encargado de crear el panel superior del marco, en este caso una barra de estado interna.
     *
     * @param w El marco interno al que se le agrega el panel superior.
     * @return El componente que representa la barra de estado interna.
     */
    @Override
    protected JComponent createNorthPane(JInternalFrame w) {
        InternalStatusBar internalStatusBar =
                new InternalStatusBar("Status", dimension, w);
        internalStatusBar.setVisible(true);
        return internalStatusBar;
    }
}