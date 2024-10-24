package rpg.gui.buttons;

import rpg.Utils.cache.ImageCache;

import javax.swing.*;

public class BaseButton extends JButton {

    public BaseButton(String text) {

        setText(text);
        /*// Agregamos los iconos a la caché de imágenes.
        setIcon(
                new ImageIcon(ImageCache.addImage("shopIdle", "icons/shopIdle.png")));
        setRolloverIcon(
                new ImageIcon(ImageCache.addImage("shopHover", "icons/shopHover.png")));
        // Establecemos el manger de UI.
        setUI(new HoverButtonUI());*/

    }
}