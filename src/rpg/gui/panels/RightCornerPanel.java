package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;

/**
 * Clase que extiende {@link BackgroundPanel} y representa un panel con
 * una imagen de fondo que se utiliza en la interfaz de usuario para la esquina
 * superior derecha. Este panel tiene una imagen de fondo que se carga desde
 * un directorio de recursos y ajusta su tamaño a las dimensiones definidas.
 */
public class RightCornerPanel extends BackgroundPanel {

    /**
     * Inicializa el panel cargando la imagen de fondo y estableciendo las
     * dimensiones predefinidas para el panel de la esquina derecha,
     * utilizando la constante {@link UIConstants#CORNER_DIMENSION}.
     */
    @Override
    protected void init() {
        // Cargamos la imagen de fondo desde el directorio correspondiente
        backgroundImage = new ImageIcon(ImageCache.addImage("rightCornerPanel",
                "panels/topRightCorner.png"));

        // Establecemos las dimensiones del panel con las dimensiones predefinidas
        setDimension(UIConstants.CORNER_DIMENSION);
    }
}