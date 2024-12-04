package rpg.gui.buttons;

import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class InventoryButton extends BaseButton {

    public InventoryButton() {
        super("Inventario");
    }

    @Override
    protected void initIcons() {

        BufferedImage inventoryIdle = ImageCache.addImage(
                "inventoryIdle", "icons/inventoryIdle.png");
        BufferedImage inventoryHover = ImageCache.addImage(
                "inventoryHover", "icons/inventoryHover.png");
        setIcon(new ImageIcon(inventoryIdle));
        setRolloverIcon(new ImageIcon(inventoryHover));
    }
}
