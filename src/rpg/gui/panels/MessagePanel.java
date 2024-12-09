package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;

/**
 * Clase que extiende {@link BackgroundPanel} y representa un panel con
 * una imagen de fondo utilizada para mostrar mensajes en la interfaz
 * de usuario. Este panel se utiliza en áreas donde se presentan textos
 * o mensajes para el usuario, manteniendo la consistencia visual
 * con otras partes de la interfaz.
 */
public class MessagePanel extends BackgroundPanel {

    /**
     * Inicializa el panel cargando la imagen de fondo y estableciendo las
     * dimensiones predefinidas para el panel de mensajes, utilizando
     * la constante {@link UIConstants#MESSAGE_DIMENSION}.
     */
    @Override
    protected void init() {
        // Cargamos la imagen de fondo desde el directorio correspondiente
        backgroundImage = new ImageIcon(ImageCache.addImage("borderPanel",
                "panels/borderPanel.png"));

        // Establecemos las dimensiones del panel con las dimensiones predefinidas
        setDimension(UIConstants.MESSAGE_DIMENSION);
    }
}
