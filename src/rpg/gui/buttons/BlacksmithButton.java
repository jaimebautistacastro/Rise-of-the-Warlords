package rpg.gui.buttons;

import rpg.Utils.cache.ImageCache;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Clase que representa un boton para la interfaz grafica relacionado con el herrero.
 * Extiende {@link BaseButton} y configura los iconos para los estados de inactividad y hover.
 */
public class BlacksmithButton extends BaseButton {

    /**
     * Constructor del boton de herrero.
     * Llama al constructor de {@link BaseButton} con el texto "Herrero".
     */
    public BlacksmithButton() {
        super("Herrero");
    }

    /**
     * Inicializa los iconos del boton.
     * Configura el icono de inactividad y el icono de hover utilizando las imagenes
     * almacenadas en el cache de imagenes.
     */
    @Override
    protected void initIcons() {
        // Carga la imagen para el icono de inactividad y la agrega al cache
        BufferedImage blacksmithIdle = ImageCache.addImage(
                "blacksmithIdle", "icons/blacksmithIdle.png");

        // Carga la imagen para el icono de hover y la agrega al cache
        BufferedImage blacksmithHover = ImageCache.addImage(
                "blacksmithHover", "icons/blacksmithHover.png");

        // Establece el icono de inactividad
        setIcon(new ImageIcon(blacksmithIdle));

        // Establece el icono para el estado de hover
        setRolloverIcon(new ImageIcon(blacksmithHover));
    }
}