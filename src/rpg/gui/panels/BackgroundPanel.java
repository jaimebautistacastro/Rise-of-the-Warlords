package rpg.gui.panels;

import rpg.Utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

/**
 * Clase abstracta que define un panel con una imagen de fondo.
 * Las clases que la extienden deben proporcionar la lógica de inicialización
 * específica en el metodo {@link #init()}.
 */
public abstract class BackgroundPanel extends JPanel {

    /**
     * Imagen de fondo del panel.
     */
    protected ImageIcon backgroundImage;

    /**
     * Dimensiones del panel.
     */
    protected Dimension dimension;

    /**
     * Constructor de la clase. Inicializa el panel llamando al metodo {@link #init()}.
     */
    public BackgroundPanel() {
        init();
    }

    /**
     * Metodo abstracto que debe ser implementado por las clases hijas
     * para inicializar los componentes específicos del panel.
     */
    protected abstract void init();

    /**
     * Establece las dimensiones del panel.
     *
     * @param dimension Dimensiones del panel que se establecerán.
     */
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
    }

    /**
     * Sobrescribe el metodo {@link JPanel#paintComponent(Graphics)} para pintar
     * la imagen de fondo estirada a lo largo de todo el panel.
     *
     * @param g Gráficos utilizados para pintar el componente.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Gestor 2D para gestionar mejor las transformaciones y la renderización
        Graphics2D g2d = (Graphics2D) g;

        // Activamos el antialiasing para mejorar la calidad de las imágenes y texto
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Activamos la interpolación bicúbica para mejorar la calidad de las imágenes estiradas
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        // Dibujamos la imagen de fondo estirada a lo largo de todo el panel
        g2d.drawImage(backgroundImage.getImage(), 0, 0,
                dimension.width, dimension.height, null);
    }
}