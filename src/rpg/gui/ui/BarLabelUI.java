package rpg.gui.ui;

import rpg.enums.BarType;
import rpg.gui.UIConstants;
import rpg.gui.labels.BarLabel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Clase personalizada que define la interfaz de usuario para las barras de estado
 * en el juego, como barras de vida, magia, etc. Modifica la apariencia de las etiquetas
 * para mostrar barras con iconos, contenedores y valores dinamicos.
 */
public class BarLabelUI extends BasicLabelUI {

    /**
     * Tipo de barra (vida, magia, experiencia, etc.).
     */
    private final BarType type;

    /**
     * Constructor de la clase que define el tipo de barra.
     *
     * @param type Tipo de la barra (ej. vida, magia).
     */
    public BarLabelUI(BarType type) {
        this.type = type;
    }

    /**
     * Metodo para establecer los valores predeterminados del componente JLabel.
     * Configura la visibilidad, el borde, la alineacion y la fuente de la etiqueta.
     *
     * @param c JLabel que representa la barra.
     */
    @Override
    protected void installDefaults(JLabel c) {
        c.setOpaque(false);
        c.setBorder(null);
        c.setForeground(Color.WHITE);
        c.setFont(UIConstants.BAR_LABEL_FONT);
        c.setVerticalAlignment(JLabel.BOTTOM);
        c.setVerticalTextPosition(JLabel.BOTTOM);
        c.setHorizontalAlignment(JLabel.RIGHT);
        c.setHorizontalTextPosition(JLabel.RIGHT);
    }

    /**
     * Obtiene el tamano preferido para la etiqueta.
     *
     * @param c Componente JLabel.
     * @return Dimensiones del tamano preferido.
     */
    @Override
    public Dimension getPreferredSize(JComponent c) {
        return getBarWidth();
    }

    /**
     * Obtiene el tamano minimo para la etiqueta.
     *
     * @param c Componente JLabel.
     * @return Dimensiones del tamano minimo.
     */
    @Override
    public Dimension getMinimumSize(JComponent c) {
        return getBarWidth();
    }

    /**
     * Obtiene el tamano maximo para la etiqueta.
     *
     * @param c Componente JLabel.
     * @return Dimensiones del tamano maximo.
     */
    @Override
    public Dimension getMaximumSize(JComponent c) {
        return getBarWidth();
    }

    /**
     * Dibuja el texto habilitado de la etiqueta. Ajusta la posicion del texto para centrarlo.
     *
     * @param l JLabel que contiene el texto.
     * @param g Graficos utilizados para dibujar el texto.
     * @param s Texto que se va a mostrar.
     * @param textX Posicion X para el texto.
     * @param textY Posicion Y para el texto.
     */
    @Override
    protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {
        int textMiddle = g.getFontMetrics(g.getFont()).stringWidth(s) / 2;
        g.drawString(s, textX - textMiddle - 5, textY + 3);
    }

    /**
     * Metodo encargado de dibujar la barra de estado. Dibuja los iconos, contenedor y barra
     * con su valor correspondiente.
     *
     * @param g Graficos utilizados para dibujar la barra.
     * @param c Componente JLabel que representa la barra.
     */
    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        BarLabel barLabel = (BarLabel) c;
        BufferedImage icon = type.getIcon();
        BufferedImage container = type.getContainer();
        BufferedImage bar = type.getBar();
        int barValue = getBarValue(barLabel);
        int maxValue = getMaxBarValue(barLabel);
        int iconX = 0;
        int iconY = 0;
        int iconWidth = UIConstants.BAR_ICON.width;
        int iconHeight = UIConstants.BAR_ICON.height;
        int displayX = UIConstants.BAR_ICON.width - 2;
        int displayY = iconY + 5;
        int displayWidth = UIConstants.BAR_DISPLAY.width;
        int displayHeight = UIConstants.BAR_DISPLAY.height;
        int barWidth = (int) ((double) barValue / maxValue * 157);
        int barHeight = 17;
        int barX = iconWidth + 9;
        int barY = iconY + 15;

        // Dibuja los elementos de la barra (icono, contenedor y barra)
        g2d.drawImage(icon, iconX, iconY, iconWidth, iconHeight, null);
        g2d.drawImage(container, displayX, displayY, displayWidth, displayHeight, null);
        g2d.drawImage(bar, barX, barY, barWidth, barHeight, null);

        super.paint(g, c);
    }

    /**
     * Obtiene el valor actual de la barra (por ejemplo, la cantidad de vida o magia).
     *
     * @param c Componente JLabel que representa la barra.
     * @return Valor actual de la barra.
     */
    private int getBarValue(JLabel c) {
        return ((BarLabel) c).getBarValue();
    }

    /**
     * Obtiene el valor maximo de la barra (el valor total posible para la barra).
     *
     * @param c Componente JLabel que representa la barra.
     * @return Valor maximo de la barra.
     */
    private int getMaxBarValue(JLabel c) {
        return ((BarLabel) c).getMaxValue();
    }

    /**
     * Calcula el tamano total de la barra, sumando el tamano del icono y del contenedor de la barra.
     *
     * @return Dimensiones de la barra.
     */
    private Dimension getBarWidth() {
        Dimension iconSize = UIConstants.BAR_ICON;
        Dimension displaySize = UIConstants.BAR_DISPLAY;
        int width = iconSize.width + displaySize.width;
        return new Dimension(width, iconSize.height + 5);
    }
}