package rpg.gui.buttons;

import rpg.Utils.cache.ImageCache;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Clase que representa un botón de inventario con iconos personalizados
 * para los estados de reposo y de paso del cursor (hover).
 * Este botón se utiliza para interactuar con el inventario del jugador.
 */
public class InventoryButton extends BaseButton {

    /**
     * Constructor que crea un botón de inventario con el texto "Inventario".
     * Se encargará de inicializar los iconos del botón para los estados
     * de reposo y de paso del cursor.
     */
    public InventoryButton() {
        super("Inventario");
    }

    /**
     * Inicializa los iconos del botón en los estados de reposo y hover.
     * Los iconos se cargan desde archivos de imagen y se asignan al botón.
     */
    @Override
    protected void initIcons() {
        // Carga de imagen para el estado de reposo (idle)
        BufferedImage inventoryIdle = ImageCache.addImage(
                "inventoryIdle", "icons/inventoryIdle.png");

        // Carga de imagen para el estado de hover (cuando el cursor pasa sobre el botón)
        BufferedImage inventoryHover = ImageCache.addImage(
                "inventoryHover", "icons/inventoryHover.png");

        // Establece los iconos del botón
        setIcon(new ImageIcon(inventoryIdle));
        setRolloverIcon(new ImageIcon(inventoryHover));
    }
}