package rpg.Utils.cache;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontLoader {

    public static Font loadFont(String fontPath) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(Font.PLAIN, 12); // Tamaño por defecto
        } catch (FontFormatException | IOException e) {
            System.err.println("Error loading font from path: " + fontPath);
            e.printStackTrace();
            return null; // Retorna null si hay un error
        }
    }
}