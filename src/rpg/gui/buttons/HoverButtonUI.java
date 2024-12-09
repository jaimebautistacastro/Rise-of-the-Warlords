package rpg.gui.buttons;

import rpg.Utils.cache.ImageCache;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

/**
 * Clase que implementa la interfaz de usuario personalizada para un boton con efecto de hover.
 * Esta clase se encarga de dibujar el boton con diferentes imagenes dependiendo de si el boton
 * esta en estado normal o al pasar el cursor sobre el.
 */
public class HoverButtonUI extends BasicButtonUI {

    protected int width;
    protected int height;
    protected ImageIcon[] parts;
    protected ImageIcon[] partsHover;

    /**
     * Instala los valores predeterminados para el boton, como el cursor, los bordes y la opacidad.
     * Ademas inicializa las imagenes que se usaran para el boton.
     *
     * @param b El boton sobre el cual se instalara la configuracion.
     */
    @Override
    protected void installDefaults(AbstractButton b) {
        initParts();
        b.setDoubleBuffered(true);
        b.setOpaque(false);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setContentAreaFilled(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    /**
     * Obtiene el tamaño preferido del boton.
     *
     * @param c El componente (boton) sobre el cual se calcula el tamaño.
     * @return El tamaño preferido del boton.
     */
    @Override
    public Dimension getPreferredSize(JComponent c) {
        return new Dimension(Math.max(width + 54, 84), 48);
    }

    /**
     * Inicializa las imagenes que se usaran para el boton en su estado normal y de hover.
     * Estas imagenes son cargadas desde el cache de imagenes.
     */
    protected void initParts() {
        parts = new ImageIcon[3];
        partsHover = new ImageIcon[3];
        // Carga las imagenes desde el cache de imagenes
        ImageCache.addImage("userLeftSide", "imagenes/idle/user/leftSide/Botton.png");
        ImageCache.addImage("userCenterSide", "imagenes/idle/user/centerSide/Botton.png");
        ImageCache.addImage("userRightSide", "imagenes/idle/user/rightSide/Botton.png");
        ImageCache.addImage("userHoverLeftSide", "imagenes/hover/user/leftSide/Botton.png");
        ImageCache.addImage("userHoverCenterSide", "imagenes/hover/user/centerSide/Botton.png");
        ImageCache.addImage("userHoverRightSide", "imagenes/hover/user/rightSide/Botton.png");
        parts[0] = ImageCache.getImageIcon("userLeftSide");
        parts[1] = ImageCache.getImageIcon("userCenterSide");
        parts[2] = ImageCache.getImageIcon("userRightSide");
        partsHover[0] = ImageCache.getImageIcon("userHoverLeftSide");
        partsHover[1] = ImageCache.getImageIcon("userHoverCenterSide");
        partsHover[2] = ImageCache.getImageIcon("userHoverRightSide");
    }

    /**
     * Dibuja el boton en el componente, utilizando las imagenes correspondientes
     * segun si el boton esta en estado normal o en hover.
     *
     * @param g El objeto Graphics que se utiliza para dibujar el boton.
     * @param c El componente (boton) que sera dibujado.
     */
    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        AbstractButton button = (AbstractButton) c;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ImageIcon[] images = button.getModel().isRollover() ? partsHover : parts;
        drawButtonParts(g2d, images);
    }

    /**
     * Dibuja las diferentes partes del boton utilizando las imagenes proporcionadas.
     *
     * @param g2d El objeto Graphics2D utilizado para dibujar.
     * @param parts Las imagenes que representan las partes del boton.
     */
    protected void drawButtonParts(Graphics2D g2d, ImageIcon[] parts) {
        g2d.drawImage(parts[0].getImage(), 0, 0, null);
        g2d.translate(27, 0);
        g2d.drawImage(parts[1].getImage(), 0, 0, width, height, null);
        g2d.translate(width, 0);
        g2d.drawImage(parts[2].getImage(), 0, 0, null);
    }
}