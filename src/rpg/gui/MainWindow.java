package rpg.gui;

import javax.swing.*;

import java.awt.*;

import static rpg.gui.WindowConstants.WINDOW_SIZE;

public class MainWindow  extends JFrame {
    private JPanel mainPanel;

    public MainWindow (){

        /**
         * Crear panel principal
         */
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        /**
         * Crear la barra de estado
         */

        JPanel statusBar = new JPanel();
        statusBar.setBackground(Color.LIGHT_GRAY);
        statusBar.add(new JLabel("Vida: 100% | Nivel: 1" ));
        statusBar.setPreferredSize(new Dimension(WINDOW_SIZE.width,150));

        /**
         * Crear el panel del juego
         */

        JPanel gamePanel = new JPanel();
        gamePanel.setBackground(Color.WHITE);
        /**
         * Se utiliza un GridLayout para determinar la zona de juego
         */
        gamePanel.setLayout(new GridLayout(1,1));
        gamePanel.add(new JLabel("Area de Juego"));
        gamePanel.setPreferredSize(new Dimension(WINDOW_SIZE.width,730));

        /**
         * Crear la barra de acción
         */

        JPanel actionBar = new JPanel();
        actionBar.setBackground(Color.CYAN);
        actionBar.setLayout(new BorderLayout());
        actionBar.setPreferredSize(new Dimension(WINDOW_SIZE.width,340));

        /**
         * Anexar botones de acción a la barra de acción
         */

        JPanel actionButtons = new JPanel();
        actionButtons.setLayout(new FlowLayout());
        actionButtons.add(new JButton("Atacar"));
        actionButtons.add(new JButton("Defender"));
        actionButtons.add(new JButton("Usar Artículo"));

        /**
         * Mostrar mensaje al jugador en la barra de acción
         */

        JTextArea messageArea = new JTextArea(3,30);
        messageArea.setEditable(false);
        messageArea.setText("¡Buena Suerte!");

        /**
         * Añadir los botones y mensaje a la barra de acción
         */

        actionBar.add(actionButtons, BorderLayout.NORTH);
        actionBar.add(new JScrollPane(messageArea), BorderLayout.SOUTH);

        /**
         * Añadir los paneles al panel principal
         */

        mainPanel.add(statusBar,BorderLayout.NORTH);
        mainPanel.add(gamePanel, BorderLayout.CENTER);
        mainPanel.add(actionBar, BorderLayout.SOUTH);

        /**
         * Establecer el panel principal como contenido de la ventana
         */

        this.setContentPane(mainPanel);

        this.setTitle(" Rise of the Warlords ");
        this.setSize(WINDOW_SIZE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public static void main (String [] args){
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow();
            window.setVisible(true);

        });
    }
}
