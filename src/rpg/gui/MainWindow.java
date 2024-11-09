package rpg.gui;

import rpg.enums.BarType;
import rpg.gui.buttons.*;
import rpg.gui.labels.BarLabel;
import rpg.gui.labels.PortraitLabel;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private static final Dimension WINDOW_SIZE = new Dimension(1024,768);
    private JPanel mainPanel;
    private JPanel TopPanel;
    private JPanel MiddlePanel;
    private JPanel BottomPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private SaveGame saveGame;
    private Exit exit;
    private Inventory inventory;
    private Statistics statistics;
    private JDesktopPane desktopPane;
    private PortraitLabel portraitLabel;
    private BarLabel lifeLabel;
    private BarLabel magicLabel;
    private BarLabel explabel;

    public MainWindow (){
        setTitle("Rise of the Warlords");
        setSize(WINDOW_SIZE);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setVisible(true);
    }

    private void initComponents(){
        desktopPane = new JDesktopPane();
        desktopPane.setPreferredSize(mainPanel != null ? mainPanel.getPreferredSize() : null);
        mainPanel.setBounds(0,0,mainPanel.getPreferredSize().width, mainPanel.getPreferredSize().height);
        desktopPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
        setContentPane(desktopPane);
        setTitle("Rise of the Warlords");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    public static void main (String[] args){
        new MainWindow();
    }

    private void createUIComponents(){
        TopPanel = new TopPanel();
        MiddlePanel = new MiddlePanel();
        BottomPanel = new BottomPanel();
        button1 = new SaveGame();
        button2 = new Statistics();
        button3 = new Inventory();
        button4 = new Exit();
        portraitLabel = new PortraitLabel();
        TopPanel.add(portraitLabel);
        lifeLabel = new BarLabel(100, 100, BarType.LIFE);
        magicLabel = new BarLabel(30, 100, BarType.MAGIC);
        explabel = new BarLabel(0, 350, BarType.EXPERIENCE);
    }
}