package rpg.gui.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;

public class StatusBarUI extends BasicPanelUI {

    private Dimension dimension;

    public StatusBarUI(Dimension dimension) {
        this.dimension = dimension;
    }

    @Override
    protected void installDefaults(JPanel p) {
        p.setBounds(0, 0, dimension.width, 77);
        p.getInsets(new Insets(0, 0, 0, 0));
        p.setOpaque(false);
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        return new Dimension(dimension.width, 77);
    }
}
