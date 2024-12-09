package rpg.gui.panels;

import rpg.Utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que extiende {@link BackgroundPanel} y representa un panel con
 * una imagen de fondo específica. Se utiliza en escenarios internos donde
 * se define el tamaño del panel mediante parámetros personalizados de ancho
 * y alto.
 */
public class InternPanel extends BackgroundPanel {

    private int width;
    private int height;

    /**
     * Constructor de la clase que inicializa el panel con dimensiones personalizadas.
     *
     * @param width Ancho del panel.
     * @param height Alto del panel.
     */
    public InternPanel(int width, int height) {
        this.width = width;
        this.height = height;
        init();
    }

    /**
     * Inicializa el panel cargando la imagen de fondo desde el directorio
     * correspondiente y establece las dimensiones personalizadas.
     */
    @Override
    protected void init() {
        // Cargamos la imagen de fondo desde el directorio correspondiente
        backgroundImage = new ImageIcon(ImageCache.addImage("borderPanel",
                "panels/borderPanel.png"));

        // Establecemos las dimensiones del panel según los parámetros proporcionados
        setDimension(new Dimension(width, height));
    }
}