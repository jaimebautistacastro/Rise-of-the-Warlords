package rpg.gui.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

/**
 * Clase personalizada que define la interfaz de usuario para las etiquetas en el juego.
 * Permite mostrar un icono y texto en una etiqueta.
 */
public class GameLabelUI extends BasicLabelUI {

    /**
     * Tamaño de la etiqueta.
     */
    protected final Dimension size;

    /**
     * Icono que se muestra en la etiqueta.
     */
    protected final ImageIcon icon;

    /**
     * Rectangulo que define donde se pintara el icono.
     */
    protected Rectangle paintIconR = new Rectangle();

    /**
     * Rectangulo que define donde se pintara el texto.
     */
    protected Rectangle paintTextR = new Rectangle();

    /**
     * Constructor que inicializa la etiqueta con el tamaño y el icono.
     *
     * @param size Tamaño de la etiqueta.
     * @param icon Icono que se asigna a la etiqueta.
     */
    public GameLabelUI(Dimension size, ImageIcon icon) {
        this.size = size;
        this.icon = icon;
    }

    /**
     * Metodo para establecer los valores predeterminados del componente JLabel.
     * Configura la visibilidad y el borde de la etiqueta.
     *
     * @param c JLabel que representa la etiqueta del juego.
     */
    @Override
    protected void installDefaults(JLabel c) {
        c.setOpaque(false);
        c.setBorder(null);
    }

    /**
     * Metodo encargado de dibujar el icono y el texto en la etiqueta.
     *
     * @param g Graficos utilizados para dibujar la etiqueta.
     * @param c Componente JLabel que representa la etiqueta.
     */
    @Override
    public void paint(Graphics g, JComponent c) {
        JLabel label = (JLabel) c;
        FontMetrics fm = g.getFontMetrics();
        String clippedText = layout(label, fm, c.getWidth(), c.getHeight());
        int textX = 40 + ((paintIconR.width - 40 - (fm.stringWidth(label.getText()))) / 2);
        int textY = paintTextR.y + fm.getAscent();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(icon.getImage(), 0, 0, size.width, size.height, c);
        super.paintEnabledText(label, g, clippedText, textX, textY);
    }

    /**
     * Metodo encargado de organizar el texto y el icono dentro de la etiqueta.
     *
     * @param label Etiqueta a la que se le organiza el texto y el icono.
     * @param fm Metricas de la fuente utilizadas para calcular el espacio necesario.
     * @param width Ancho disponible para pintar el contenido.
     * @param height Alto disponible para pintar el contenido.
     * @return Texto que se muestra en la etiqueta.
     */
    protected String layout(JLabel label, FontMetrics fm,
                            int width, int height) {
        Insets insets = label.getInsets(null);
        String text = label.getText();
        Icon icon = (label.isEnabled()) ? label.getIcon() :
                label.getDisabledIcon();
        Rectangle paintViewR = new Rectangle();
        paintViewR.x = insets.left;
        paintViewR.y = insets.top;
        paintViewR.width = width - (insets.left + insets.right);
        paintViewR.height = height - (insets.top + insets.bottom);
        paintIconR.x = paintIconR.y = paintIconR.width = paintIconR.height = 0;
        paintTextR.x = paintTextR.y = paintTextR.width = paintTextR.height = 0;
        return layoutCL(label, fm, text, icon, paintViewR, paintIconR,
                paintTextR);
    }
}