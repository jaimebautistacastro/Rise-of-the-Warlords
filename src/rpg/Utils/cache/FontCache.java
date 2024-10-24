package rpg.Utils.cache;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FontCache {

    private static final Map<String, Font> cache = new HashMap<>();

    public static Font addFont(String fontName, String fontPath) {
        Font font;
        if (!cache.containsKey(fontName)) {
            font = FontLoader.loadFont(fontPath); // Asegúrate de que esta clase esté bien implementada
            if (font != null) {
                cache.put(fontName, font);
            }
        } else {
            font = cache.get(fontName);
        }
        return font;
    }

    public static Font getFont(String fontName) {
        return getFont(fontName, Font.PLAIN, 12); // Por defecto devuelve una fuente de tamaño 12
    }

    public static Font getFont(String fontName, int size) {
        return getFont(fontName, Font.PLAIN, size);
    }

    public static Font getFont(String fontName, int style, int size) {
        Font baseFont = cache.getOrDefault(fontName, new Font("Serif", Font.PLAIN, 12)); // Fuente por defecto si no se encuentra en el caché
        return baseFont.deriveFont(style, (float) size); // Deriva la fuente con estilo y tamaño
    }
}