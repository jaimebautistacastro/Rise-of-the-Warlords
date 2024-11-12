package rpg.gui.internalFrames;

import rpg.gui.ui.TransparentFrameUI;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatusFrame extends JInternalFrame {

    private JPanel mainPanel;
    private JButton button1;
    private InternalStatusBar internalStatusBar;
    private Dimension dimension;

    public StatusFrame() {
        setContentPane(mainPanel);
        dimension = new Dimension(650, 600);
        setUI(new TransparentFrameUI(this, dimension));
        setSize(getPreferredSize());
    }

    private void createUIComponents() {
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageCache.addImage("internalFrame", "panels/internalFrame.png");
                g.drawImage(ImageCache.getImage("internalFrame"),
                        0, 0, getWidth(), getHeight(), null);
            }
        };
        mainPanel.setBorder(new EmptyBorder(0, 15, 15, 15));
    }
}
