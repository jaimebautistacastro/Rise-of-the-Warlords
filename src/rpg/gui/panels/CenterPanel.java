package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;

/**
 * Clase que extiende {@link BackgroundPanel} y representa un panel con
 * una imagen de fondo específica para la sección central.
 * La imagen se inicializa en el metodo {@link #init()}.
 */
public class CenterPanel extends BackgroundPanel {

    /**
     * Inicializa el panel cargando la imagen de fondo específica
     * para el panel central y estableciendo las dimensiones del panel.
     */
    @Override
    protected void init() {
        // Cargamos la imagen de fondo desde el directorio correspondiente
        backgroundImage = new ImageIcon(ImageCache.addImage("centerPanel",
                "panels/topCenter.png"));

        // Establecemos las dimensiones del panel según las constantes definidas
        setDimension(UIConstants.CENTER_DIMENSION);
    }
}