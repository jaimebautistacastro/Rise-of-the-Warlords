package rpg.gui.labels;

import javax.swing.*;
import rpg.enums.BarType;

public class BarLabel extends JLabel {
    private int value;
    private int maxValue;
    private BarType type;

    public BarLabel(int value, int maxValue, BarType type) {
        this.value = value;
        this.maxValue = maxValue;
        this.type = type;
        setText(type.toString() + ": " + value + "/" + maxValue);
    }

    // Métodos adicionales si es necesario, como actualizaciones del valor, etc.
}
