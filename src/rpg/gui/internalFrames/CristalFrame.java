package rpg.gui.internalFrames;

import javax.swing.*;

/**
 * Clase que representa una ventana interna personalizada dentro de un contenedor JDesktopPane.
 * Extiende JInternalFrame y proporciona una ventana con características básicas como
 * título, cierre, maximización, minimización y redimensionado.
 */
public class CristalFrame extends JInternalFrame {

    /**
     * Constructor de la clase CristalFrame.
     * Inicializa la ventana interna con un título, y habilita las funcionalidades de
     * cierre, maximización, minimización y redimensionado. Además, establece el tamaño
     * y la visibilidad de la ventana.
     */
    public CristalFrame() {
        // Llama al constructor de JInternalFrame con parámetros para habilitar características básicas.
        super("Cristal Frame", true, true, true, true);

        // Establece el tamaño de la ventana interna a 200x200 píxeles.
        setSize(200, 200);

        // Hace visible la ventana interna.
        setVisible(true);
    }
}