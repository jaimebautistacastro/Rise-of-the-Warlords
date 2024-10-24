package rpg.gui;

import rpg.gui.buttons.BaseButton;
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
    private JButton Tienda;
    private JButton Inventario;
    private JButton Atacar;
    private JButton Skills;
    private JButton Huir;
    private JDesktopPane desktopPane;

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
        button1 = new BaseButton("Button 1");
        Tienda = new BaseButton("Tienda");
        Inventario = new BaseButton("Inventario");
        Atacar = new BaseButton("Atacar");
        Huir = new BaseButton("Huir");
        Skills = new BaseButton("Skils");
    }
}