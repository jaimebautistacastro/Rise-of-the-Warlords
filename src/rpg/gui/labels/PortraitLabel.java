package rpg.gui.labels;

import rpg.gui.ui.GameLabelUI;
import rpg.gui.windows.MainWindow;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Clase personalizada para mostrar una imagen de retrato (portrait) en una etiqueta.
 * Extiende la clase JLabel y establece una imagen de retrato para el jugador.
 * También permite una interacción con el cursor al mostrar la imagen.
 */
public class PortraitLabel extends JLabel {

    // Icono que contiene la imagen del retrato
    protected ImageIcon icon;

    /**
     * Constructor de la clase PortraitLabel.
     * Inicializa la etiqueta con una imagen de retrato predeterminada y un cursor en forma de mano.
     *
     * @param mainWindow Ventana principal del juego, pasada como parámetro.
     */
    public PortraitLabel(MainWindow mainWindow) {
        initComponents(); // Inicializa los componentes visuales de la etiqueta
        setUI(new GameLabelUI(getPreferredSize(), icon)); // Configura el estilo de la etiqueta
        setCursor(new Cursor(Cursor.HAND_CURSOR)); // Establece el cursor de la mano para la interacción
    }

    /**
     * Inicializa los componentes visuales de la etiqueta.
     * Carga la imagen del retrato desde el caché de imágenes y la establece como el ícono de la etiqueta.
     * También ajusta el tamaño de la etiqueta según las dimensiones de la imagen del retrato.
     */
    public void initComponents() {
        // Carga la imagen del retrato desde el caché de imágenes.
        ImageCache.addImage("portrait", "player/portrait.png");
        icon = ImageCache.getImageIcon("portrait");

        // Ajusta el tamaño de la etiqueta para que coincida con el tamaño de la imagen.
        setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));

        // Establece la imagen como ícono de la etiqueta.
        setIcon(icon);
    }
}