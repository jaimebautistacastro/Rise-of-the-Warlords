package rpg.gui.ui;

import rpg.Utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

/**
 * Clase personalizada para el comportamiento visual de un boton con efecto hover para el usuario.
 */
public class UserHoverUI extends HoverButtonUI {

    private final int staticWidth = 180;

    /**
     * Metodo que instala los valores predeterminados para el boton.
     *
     * @param b El boton sobre el que se aplican los valores predeterminados.
     */
    @Override
    protected void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        // Establecemos el borde del boton.
        b.setForeground(Color.WHITE);
    }

    /**
     * Metodo que obtiene el tamaño preferido del componente.
     *
     * @param c El componente sobre el que se calcula el tamaño.
     * @return El tamaño preferido del componente.
     */
    @Override
    public Dimension getPreferredSize(JComponent c) {
        return new Dimension(staticWidth, 48);
    }

    /**
     * Metodo que inicializa las partes del boton en sus estados normal y hover.
     */
    @Override
    protected void initParts() {
        // Inicializamos los arreglos de imagenes.
        parts = new ImageIcon[3];
        partsHover = new ImageIcon[3];
        // Agregamos las imagenes a la cache.
        ImageCache.addImage("actionLeftSide", "buttons/idle/ui/leftSide.png");
        ImageCache.addImage("actionCenterSide", "buttons/idle/ui/centerSide.png");
        ImageCache.addImage("actionRightSide", "buttons/idle/ui/rightSide.png");
        ImageCache.addImage("actionHoverLeftSide", "buttons/hover/ui/leftSide.png");
        ImageCache.addImage("actionHoverCenterSide", "buttons/hover/ui/centerSide.png");
        ImageCache.addImage("actionHoverRightSide", "buttons/hover/ui/rightSide.png");
        // Obtenemos las imagenes de la cache y las almacenamos en los arreglos correspondientes.
        parts[0] = ImageCache.getImageIcon("actionLeftSide");
        parts[1] = ImageCache.getImageIcon("actionCenterSide");
        parts[2] = ImageCache.getImageIcon("actionRightSide");
        partsHover[0] = ImageCache.getImageIcon("actionHoverLeftSide");
        partsHover[1] = ImageCache.getImageIcon("actionHoverCenterSide");
        partsHover[2] = ImageCache.getImageIcon("actionHoverRightSide");
    }

    /**
     * Metodo que dibuja las partes del boton, ya sea en estado normal o hover.
     *
     * @param g2d El objeto Graphics2D usado para dibujar las imagenes.
     * @param parts El arreglo de imagenes que representan las partes del boton.
     */
    @Override
    protected void drawButtonParts(Graphics2D g2d, ImageIcon[] parts) {
        g2d.drawImage(parts[0].getImage(), 0, 0, null);
        g2d.translate(27, 0);
        g2d.drawImage(parts[1].getImage(), 0, 0,
                staticWidth - 54, height, null);
        g2d.translate(staticWidth - 54, 0);
        g2d.drawImage(parts[2].getImage(), 0, 0, null);
        g2d.translate(-staticWidth + width + 54, 0);
    }
}