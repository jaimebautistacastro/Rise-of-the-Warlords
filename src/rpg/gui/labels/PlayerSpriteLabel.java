package rpg.gui.labels;

import rpg.Utils.cache.ImageCache;

import java.awt.*;

/**
 * Clase personalizada para mostrar la imagen del sprite del jugador.
 * Extiende la clase PortraitLabel y establece una imagen de sprite para el jugador.
 */
public class PlayerSpriteLabel extends PortraitLabel {

    /**
     * Constructor de la clase PlayerSpriteLabel.
     * Inicializa la etiqueta del sprite del jugador con la imagen predeterminada.
     */
    public PlayerSpriteLabel() {
        super(null); // Llama al constructor de PortraitLabel con un valor inicial nulo.
    }

    /**
     * Inicializa los componentes visuales de la etiqueta.
     * Carga la imagen del sprite del jugador desde el caché de imágenes y la establece como el ícono de la etiqueta.
     * También ajusta el tamaño de la etiqueta según las dimensiones de la imagen del sprite.
     */
    @Override
    public void initComponents() {
        // Carga la imagen del sprite del jugador desde el caché de imágenes.
        ImageCache.addImage("playerSprite", "player/player.png");
        icon = ImageCache.getImageIcon("playerSprite");

        // Ajusta el tamaño de la etiqueta para que coincida con el tamaño de la imagen.
        setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));

        // Establece la imagen como ícono de la etiqueta.
        setIcon(icon);
    }
}