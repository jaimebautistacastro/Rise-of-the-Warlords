package rpg.gui.ui;

import rpg.gui.UIConstants;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Clase personalizada para la interfaz de usuario de una etiqueta con nombre.
 * Esta etiqueta se dibuja con imagenes a los lados y el texto en el centro.
 */
public class NameLabelUI extends GameLabelUI {

    /**
     * Arreglo de imagenes que forman parte de la etiqueta con nombre.
     */
    private final BufferedImage[] icons;

    /**
     * Constructor de la clase, inicializa las imagenes para el nombre.
     */
    public NameLabelUI() {
        super(null, null);
        icons = new BufferedImage[3];
        ImageCache.addImage("name_l", "labels/name_label_left.png");
        ImageCache.addImage("name_c", "labels/name_label_center.png");
        ImageCache.addImage("name_r", "labels/name_label_right.png");
        icons[0] = ImageCache.getImage("name_l");
        icons[1] = ImageCache.getImage("name_c");
        icons[2] = ImageCache.getImage("name_r");
    }

    /**
     * Metodo encargado de instalar los valores predeterminados para la etiqueta.
     *
     * @param c Etiqueta sobre la cual se aplican los valores predeterminados.
     */
    @Override
    protected void installDefaults(JLabel c) {

        c.setFont(UIConstants.LABEL_FONT);
        c.setForeground(Color.BLACK);
        c.setVerticalAlignment(JLabel.CENTER);
        c.setHorizontalAlignment(JLabel.CENTER);
        c.setVerticalTextPosition(JLabel.CENTER);
        c.setHorizontalTextPosition(JLabel.CENTER);
        FontMetrics metrics = c.getFontMetrics(c.getFont());
        int textWidth = metrics.stringWidth(c.getText());
        c.setPreferredSize(new Dimension(textWidth + 44, 51));
    }

    /**
     * Metodo encargado de pintar la etiqueta con nombre.
     * Dibuja las imagenes a los lados del texto.
     *
     * @param g Graficos utilizados para pintar la etiqueta.
     * @param c Componente JLabel que representa la etiqueta.
     */
    @Override
    public void paint(Graphics g, JComponent c) {

        JLabel label = (JLabel) c;
        FontMetrics fm = g.getFontMetrics();
        String clippedText = layout(label, fm, c.getWidth(), c.getHeight());
        int stringWidth = fm.stringWidth(label.getText());
        int textY = paintTextR.y;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(icons[0], 0, 0, icons[0].getWidth(), icons[0].getHeight(), c);
        g2d.translate(icons[0].getWidth(), 0);
        g2d.drawImage(icons[1], 0, 0, stringWidth, icons[1].getHeight(), c);
        g2d.translate(stringWidth, 0);
        g2d.drawImage(icons[2], 0, 0, icons[2].getWidth(), icons[2].getHeight(), c);
        g2d.translate(-stringWidth, 0);
        g2d.drawString(clippedText, 0, textY + fm.getAscent());
    }
}