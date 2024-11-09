package rpg.gui.buttons;

import rpg.Utils.cache.ImageCache;
import rpg.Utils.cache.ImageCache;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class HoverButtonUI extends BasicButtonUI {
    protected int width;
    protected int height;
    protected ImageIcon[] parts;
    protected ImageIcon[] partsHover;

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

    @Override
    public Dimension getPreferredSize(JComponent c) {
        return new Dimension(Math.max(width + 54, 84), 48);
    }

    protected void initParts() {
        parts = new ImageIcon[3];
        partsHover = new ImageIcon[3];
        // Suponiendo que las imágenes están en "buttons/idle/user/" y "buttons/hover/user/"
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

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        AbstractButton button = (AbstractButton) c;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ImageIcon[] images = button.getModel().isRollover() ? partsHover : parts;
        drawButtonParts(g2d, images);
    }

    protected void drawButtonParts(Graphics2D g2d, ImageIcon[] parts) {
        g2d.drawImage(parts[0].getImage(), 0, 0, null);
        g2d.translate(27, 0);
        g2d.drawImage(parts[1].getImage(), 0, 0, width, height, null);
        g2d.translate(width, 0);
        g2d.drawImage(parts[2].getImage(), 0, 0, null);
    }
}