package rpg.gui.panels;

import rpg.Utils.cache.ImageCache;
import rpg.gui.WindowConstants;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class MiddlePanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Cargar la imagen usando ImageCache
        BufferedImage bufferedImage = ImageCache.addImage("middlePanel", "fondomiddlepanel.png");
        if (bufferedImage != null) {
            backgroundImage = new ImageIcon(bufferedImage);
        } else {
            // Mejor manejo del error en caso de que la imagen no se cargue
            JOptionPane.showMessageDialog(this, "Error: No se pudo cargar la imagen.",
                    "Error de imagen", JOptionPane.ERROR_MESSAGE);
        }

        // Configurar dimensiones y borde
        setDimension(WindowConstants.MIDDLE_DIMENSION); // Asegúrate de definir esta constante en WindowConstants
        setBorder(WindowConstants.EMPTY_BORDER);
    }
}