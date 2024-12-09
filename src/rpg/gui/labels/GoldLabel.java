package rpg.gui.labels;

import rpg.gui.UIConstants;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

/**
 * Clase personalizada para mostrar una etiqueta con la cantidad de oro (Gold) en la interfaz de usuario.
 * La etiqueta tiene un icono asociado y muestra la cantidad de oro disponible.
 */
public class GoldLabel extends PortraitLabel {

    private int gold; // Cantidad de oro que se va a mostrar en la etiqueta.

    /**
     * Constructor de la clase GoldLabel.
     * Inicializa la etiqueta con la cantidad de oro proporcionada.
     *
     * @param gold La cantidad de oro que se debe mostrar en la etiqueta.
     */
    public GoldLabel(int gold) {
        super(null); // Llama al constructor de la clase base con un icono nulo inicialmente.
        this.gold = gold; // Asigna la cantidad de oro.
        setFont(UIConstants.LABEL_FONT.deriveFont(Font.BOLD, 20f)); // Establece la fuente de la etiqueta.
        setForeground(Color.BLACK); // Establece el color del texto a negro.
        setVerticalAlignment(JLabel.CENTER); // Centra el texto verticalmente.
        setHorizontalAlignment(JLabel.CENTER); // Centra el texto horizontalmente.
        setVerticalTextPosition(JLabel.CENTER); // Establece la posición vertical del texto.
        setHorizontalTextPosition(JLabel.CENTER); // Establece la posición horizontal del texto.
    }

    /**
     * Inicializa los componentes de la etiqueta.
     * Establece el icono de la etiqueta y el texto que muestra la cantidad de oro.
     */
    @Override
    public void initComponents() {
        ImageCache.addImage("gold", "labels/goldLabel.png"); // Carga el icono de oro desde la caché de imágenes.
        icon = ImageCache.getImageIcon("gold"); // Obtiene el icono de oro desde la caché.
        setPreferredSize(new Dimension(
                icon.getIconWidth(), icon.getIconHeight())); // Establece el tamaño preferido de la etiqueta basado en el icono.
        setIcon(icon); // Establece el icono de la etiqueta.
        setText(gold + "G"); // Establece el texto que muestra la cantidad de oro seguida de "G".
    }
}