package rpg.gui.labels;

import rpg.enums.BarType;
import rpg.gui.ui.BarLabelUI;

import javax.swing.*;

/**
 * Clase que representa una barra de progreso personalizada en una etiqueta (JLabel).
 * Se utiliza para mostrar valores de barras como vida, magia, experiencia, etc.
 *
 * La barra muestra el valor actual en relación con el valor máximo, y su apariencia
 * se ajusta según el tipo de barra.
 */
public class BarLabel extends JLabel {

    private int barValue; // Valor actual de la barra.
    private int maxValue; // Valor máximo de la barra.
    private final BarType type; // Tipo de la barra (vida, magia, experiencia, etc.).

    /**
     * Constructor de la clase BarLabel.
     * Inicializa el valor de la barra, el valor máximo y el tipo de la barra.
     *
     * @param value El valor actual de la barra.
     * @param maxValue El valor máximo de la barra.
     * @param type El tipo de la barra (por ejemplo, vida, magia, experiencia).
     */
    public BarLabel(int value, int maxValue, BarType type) {
        this.barValue = value;
        this.maxValue = maxValue;
        this.type = type;
        initComponents(); // Inicializa los componentes de la barra.
    }

    /**
     * Actualiza los valores de la barra (valor actual y valor máximo).
     *
     * @param value El nuevo valor actual de la barra.
     * @param maxValue El nuevo valor máximo de la barra.
     */
    public void updateBar(int value, int maxValue) {
        setMaxValue(maxValue);
        setBarValue(value);
        setUI(new BarLabelUI(type)); // Actualiza la apariencia de la barra según su tipo.
        revalidate(); // Revalida el componente para aplicar los cambios.
        repaint(); // Repinta el componente para reflejar los cambios visuales.
    }

    /**
     * Inicializa los componentes de la barra.
     * Establece el valor inicial de la barra y su apariencia.
     */
    public void initComponents() {
        setBarValue(barValue); // Establece el valor de la barra.
        setUI(new BarLabelUI(type)); // Establece la apariencia de la barra según su tipo.
    }

    /**
     * Establece el valor actual de la barra.
     *
     * @param value El valor actual de la barra.
     */
    public void setBarValue(int value) {
        this.barValue = value;
        setText(String.format("%d / %d", value, maxValue)); // Muestra el valor actual y máximo en formato de texto.
    }

    /**
     * Obtiene el valor actual de la barra.
     *
     * @return El valor actual de la barra.
     */
    public int getBarValue() {
        return barValue;
    }

    /**
     * Establece el valor máximo de la barra.
     *
     * @param value El valor máximo de la barra.
     */
    public void setMaxValue(int value) {
        this.maxValue = value;
    }

    /**
     * Obtiene el valor máximo de la barra.
     *
     * @return El valor máximo de la barra.
     */
    public int getMaxValue() {
        return maxValue;
    }

    /**
     * Obtiene el tipo de la barra (por ejemplo, vida, magia, experiencia).
     *
     * @return El tipo de la barra.
     */
    public BarType getType() {
        return type;
    }
}