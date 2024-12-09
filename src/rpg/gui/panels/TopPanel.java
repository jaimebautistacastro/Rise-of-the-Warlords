package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;

/**
 * Clase que extiende {@link BackgroundPanel} y representa un panel con
 * una imagen de fondo que se utiliza en la parte superior de la interfaz de usuario.
 * Este panel tiene una imagen de fondo que se carga desde un directorio de recursos
 * y ajusta su tamaño a las dimensiones definidas para el panel superior.
 */
public class TopPanel extends BackgroundPanel {

    /**
     * Inicializa el panel cargando la imagen de fondo y estableciendo las
     * dimensiones predefinidas para el panel superior, utilizando la constante
     * {@link UIConstants#TOP_DIMENSION}.
     */
    @Override
    protected void init() {
        // Cargamos la imagen de fondo desde el directorio correspondiente
        backgroundImage = new ImageIcon(ImageCache.addImage("topPanel",
                "panels/statusPanel.png"));

        // Establecemos las dimensiones del panel con las dimensiones predefinidas
        setDimension(UIConstants.TOP_DIMENSION);

        // Establecemos el borde vacío para el panel
        setBorder(UIConstants.EMPTY_BORDER);
    }
}