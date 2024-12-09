package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;

/**
 * Clase que extiende {@link BackgroundPanel} y representa un panel con
 * una imagen de fondo ubicada en la esquina superior izquierda. Se utiliza
 * en el diseño de la interfaz de usuario para mostrar el área en la esquina
 * superior izquierda con una imagen de fondo específica.
 */
public class LeftCornerPanel extends BackgroundPanel {

    /**
     * Inicializa el panel cargando la imagen de fondo correspondiente
     * a la esquina superior izquierda y establece las dimensiones
     * definidas en {@link UIConstants#CORNER_DIMENSION}.
     */
    @Override
    protected void init() {
        // Cargamos la imagen de fondo desde el directorio correspondiente
        backgroundImage = new ImageIcon(ImageCache.addImage("leftCornerPanel",
                "panels/topLeftCorner.png"));

        // Establecemos las dimensiones del panel con las dimensiones predefinidas
        setDimension(UIConstants.CORNER_DIMENSION);
    }
}