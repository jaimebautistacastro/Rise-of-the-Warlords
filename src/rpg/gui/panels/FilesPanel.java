package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;

/**
 * Clase que extiende {@link BackgroundPanel} y representa un panel con
 * una imagen de fondo específica para el panel de archivos.
 * La imagen de fondo se carga e inicializa en el metodo {@link #init()}.
 */
public class FilesPanel extends BackgroundPanel {

    /**
     * Inicializa el panel cargando la imagen de fondo específica
     * para el panel de archivos y estableciendo sus dimensiones.
     */
    @Override
    protected void init() {
        // Cargamos la imagen de fondo desde el directorio correspondiente
        backgroundImage = new ImageIcon(ImageCache.addImage("borderPanel",
                "panels/borderPanel.png"));

        // Establecemos las dimensiones del panel según las constantes definidas
        setDimension(UIConstants.FILES_PANEL_DIMENSION);
    }
}