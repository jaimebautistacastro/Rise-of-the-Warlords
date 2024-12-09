package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;

/**
 * Clase que extiende {@link BackgroundPanel} y representa un panel con
 * una imagen de fondo que se utiliza como parte de la interfaz de usuario
 * para el área central de la ventana. Este panel contiene la imagen de fondo
 * principal de la interfaz, configurando el área visual de la parte central
 * de la pantalla.
 */
public class MiddlePanel extends BackgroundPanel {

    /**
     * Inicializa el panel cargando la imagen de fondo y estableciendo las
     * dimensiones predefinidas para el panel central, utilizando
     * la constante {@link UIConstants#MIDDLE_DIMENSION}.
     */
    @Override
    protected void init() {
        // Cargamos la imagen de fondo desde el directorio correspondiente
        backgroundImage = new ImageIcon(ImageCache.addImage("midPanel",
                "panels/mainBackground.png"));

        // Establecemos las dimensiones del panel con las dimensiones predefinidas
        setDimension(UIConstants.MIDDLE_DIMENSION);
    }
}