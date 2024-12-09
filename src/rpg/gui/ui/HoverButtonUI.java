package rpg.gui.ui;

import rpg.gui.UIConstants;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

/**
 * Clase personalizada para la interfaz de usuario de botones con efecto hover.
 * Permite cambiar el aspecto del boton cuando el cursor se posiciona sobre él.
 */
public class HoverButtonUI extends BasicButtonUI {

    /**
     * Ancho del boton.
     */
    protected int width;

    /**
     * Alto del boton.
     */
    protected int height;

    /**
     * Arreglos de imagenes para el boton en su estado normal y hover.
     */
    protected ImageIcon[] parts;
    protected ImageIcon[] partsHover;

    /**
     * Metodo encargado de instalar los valores predeterminados para el boton.
     *
     * @param b Boton sobre el cual se aplican los valores predeterminados.
     */
    @Override
    protected void installDefaults(AbstractButton b) {

        initParts();
        b.setFont(UIConstants.FONT.deriveFont(Font.PLAIN, 24));
        b.setForeground(Color.BLACK);
        b.setDoubleBuffered(true);
        b.setOpaque(false);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setContentAreaFilled(false);
        b.setIconTextGap(5);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        String text = b.getText();
        this.width = b.getFontMetrics(b.getFont()).stringWidth(text) + (5);
        this.height = 48;
    }

    /**
     * Metodo que devuelve el tamaño preferido para el boton.
     *
     * @param c Componente JLabel que representa el boton.
     * @return Dimension con el tamaño preferido del boton.
     */
    @Override
    public Dimension getPreferredSize(JComponent c) {
        return new Dimension(Math.max(width + 54, 84), 48);
    }

    /**
     * Metodo que devuelve el tamaño maximo del boton.
     *
     * @param c Componente JLabel que representa el boton.
     * @return Dimension con el tamaño maximo del boton.
     */
    @Override
    public Dimension getMaximumSize(JComponent c) {
        return getPreferredSize(c);
    }

    /**
     * Metodo que devuelve el tamaño minimo del boton.
     *
     * @param c Componente JLabel que representa el boton.
     * @return Dimension con el tamaño minimo del boton.
     */
    @Override
    public Dimension getMinimumSize(JComponent c) {
        return getPreferredSize(c);
    }

    /**
     * Metodo que inicializa las partes del boton en sus estados normal y hover.
     */
    protected void initParts() {
        //Inicializamos los arreglos de imagenes.
        parts = new ImageIcon[3];
        partsHover = new ImageIcon[3];
        // Agregamos las imagenes a la cache.
        ImageCache.addImage("userLeftSide", "buttons/idle/user/leftSide.png");
        ImageCache.addImage("userCenterSide", "buttons/idle/user/centerSide.png");
        ImageCache.addImage("userRightSide", "buttons/idle/user/rightSide.png");
        ImageCache.addImage("userHoverLeftSide", "buttons/hover/user/leftSide.png");
        ImageCache.addImage("userHoverCenterSide", "buttons/hover/user/centerSide.png");
        ImageCache.addImage("userHoverRightSide", "buttons/hover/user/rightSide.png");
        // Obtenemos las imagenes de la cache y las almacenamos en los arreglos correspondientes.
        parts[0] = ImageCache.getImageIcon("userLeftSide");
        parts[1] = ImageCache.getImageIcon("userCenterSide");
        parts[2] = ImageCache.getImageIcon("userRightSide");
        partsHover[0] = ImageCache.getImageIcon("userHoverLeftSide");
        partsHover[1] = ImageCache.getImageIcon("userHoverCenterSide");
        partsHover[2] = ImageCache.getImageIcon("userHoverRightSide");
    }

    /**
     * Metodo encargado de pintar el boton en pantalla, ya sea en su estado normal o hover.
     *
     * @param g Graficos utilizados para pintar el boton.
     * @param c Componente JLabel que representa el boton.
     */
    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        Graphics2D g2d = (Graphics2D) g;
        AbstractButton button = (AbstractButton) c;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        ImageIcon[] images = button.getModel().isRollover() ? partsHover : parts;
        drawButtonParts(g2d, images);
        g2d.translate(-width - 27, 0);
        g2d.setColor(Color.WHITE);
        super.paint(g2d, c);
    }

    /**
     * Metodo que dibuja las diferentes partes del boton.
     *
     * @param g2d Objeto Graphics2D utilizado para pintar las partes del boton.
     * @param parts Arreglo de imagenes que representan las partes del boton.
     */
    protected void drawButtonParts(Graphics2D g2d, ImageIcon[] parts) {
        g2d.drawImage(parts[0].getImage(), 0, 0, null);
        g2d.translate(27, 0);
        g2d.drawImage(parts[1].getImage(), 0, 0,
                width, height, null);
        g2d.translate(width, 0);
        g2d.drawImage(parts[2].getImage(), 0, 0, null);
    }
}