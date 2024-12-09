package rpg.gui.panels;

import rpg.gui.UIConstants;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;

/**
 * Panel personalizado que representa la sección inferior de la interfaz de usuario,
 * utilizado en el contexto de una batalla o similar. Extiende la clase BackgroundPanel
 * para proporcionar un fondo de imagen en la interfaz.
 */
public class BottomPanel extends BackgroundPanel {

    /**
     * Inicializa los componentes del panel, configurando la imagen de fondo
     * y ajustando sus dimensiones y bordes.
     */
    @Override
    protected void init() {
        // Buscamos la imagen para el fondo del panel directamente en el caché de imágenes.
        backgroundImage = new ImageIcon(ImageCache.addImage("bottomPanel",
                "panels/battlePanel.png"));

        // Establece las dimensiones del panel utilizando un valor predefinido en UIConstants.
        setDimension(UIConstants.MIDDLE_DIMENSION);

        // Establece el borde del panel a uno vacío utilizando la constante EMPTY_BORDER.
        setBorder(UIConstants.EMPTY_BORDER);
    }
}
