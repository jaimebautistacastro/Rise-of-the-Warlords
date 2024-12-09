package rpg.gui.buttons;

import rpg.gui.ui.HoverButtonUI;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;

/**
 * Clase base para botones personalizados en la interfaz grafica.
 * Extiende {@link JButton} y establece una apariencia personalizada con iconos y eventos de hover.
 */
public abstract class BaseButton extends JButton {

    /**
     * Constructor del boton base.
     * Inicializa el boton con el texto proporcionado, establece los iconos y aplica el estilo personalizado.
     *
     * @param text el texto que se muestra en el boton.
     */
    public BaseButton(String text) {
        // Establece el texto del boton
        setText(text);

        // Inicializa los iconos del boton (metodo abstracto)
        initIcons();

        // Aplica el estilo personalizado para los eventos de hover
        setUI(new HoverButtonUI());
    }

    /**
     * Metodo abstracto para inicializar los iconos del boton.
     * Debe ser implementado por las clases hijas para configurar los iconos especificos.
     */
    protected abstract void initIcons();
}