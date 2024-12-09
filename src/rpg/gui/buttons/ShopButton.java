package rpg.gui.buttons;

import rpg.Utils.cache.ImageCache;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Clase que representa un botón de la tienda en la interfaz gráfica.
 * Este botón se utiliza para acceder a la tienda dentro del juego.
 */
public class ShopButton extends BaseButton {

    /**
     * Constructor que crea un botón para acceder a la tienda.
     * Inicializa el texto del botón como "Tienda" y configura los íconos
     * para el estado normal y el estado al pasar el cursor por encima.
     */
    public ShopButton() {
        // Llama al constructor de la clase base con el texto "Tienda".
        super("Tienda");
    }

    /**
     * Metodo que inicializa los íconos que se usarán para el botón.
     * Asigna las imágenes para el estado normal y el estado cuando el
     * cursor pasa por encima del botón.
     */
    @Override
    protected void initIcons() {
        // Carga las imágenes para el estado normal y el estado hover (al pasar el cursor).
        BufferedImage shopIdle = ImageCache.addImage(
                "shopIdle", "icons/shopIdle.png");
        BufferedImage shopHover = ImageCache.addImage(
                "shopHover", "icons/shopHover.png");

        // Establece los íconos del botón para cada estado.
        setIcon(new ImageIcon(shopIdle));
        setRolloverIcon(new ImageIcon(shopHover));
    }
}