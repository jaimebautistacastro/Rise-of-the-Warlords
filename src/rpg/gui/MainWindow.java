package rpg.gui;

import rpg.entities.GameUI;
import rpg.entities.Player;
import rpg.entities.enemy.Enemy;
import rpg.enums.BarType;
import rpg.gui.buttons.*;
import rpg.gui.labels.BarLabel;
import rpg.gui.labels.PortraitLabel;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private static final Dimension WINDOW_SIZE = new Dimension(1024, 768);
    private JPanel mainPanel;
    private JPanel TopPanel;  // Usar TopPanel con mayúsculas
    private JPanel MiddlePanel;
    private JPanel BottomPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private PortraitLabel portraitLabel;
    private BarLabel lifeLabel;
    private BarLabel magicLabel;
    private BarLabel explabel;
    private JTextArea gameLog;

    public MainWindow() {
        setTitle("Rise of the Warlords");
        setSize(WINDOW_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Llamar a crear la interfaz de usuario
        createUIComponents();

        // Establecer el panel principal
        setContentPane(mainPanel);
        setVisible(true);
    }

    private void createUIComponents() {
        // Crear el panel principal y configurar layout
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());  // Usamos BorderLayout para un control más preciso

        // Agregar el fondo
        addBackgroundImage();

        // Crear botones
        button1 = new JButton("Iniciar Juego");
        button2 = new JButton("Statistics");
        button3 = new JButton("Inventory");
        button4 = new JButton("Exit");

        // Crear paneles principales
        TopPanel = new JPanel();  // Asegurarnos de inicializar TopPanel con mayúsculas
        MiddlePanel = new JPanel();
        BottomPanel = new JPanel();

        // Crear las imágenes de los personajes
        ImageIcon playerIcon = new ImageIcon("./imagenes/Zelda.png");
        Image playerImage = playerIcon.getImage();
        Image resizedPlayerImage = playerImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensionar
        JLabel playerImageLabel = new JLabel(new ImageIcon(resizedPlayerImage));

        ImageIcon enemyIcon = new ImageIcon("./imagenes/Dragon.png");
        Image enemyImage = enemyIcon.getImage();
        Image resizedEnemyImage = enemyImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensionar
        JLabel enemyImageLabel = new JLabel(new ImageIcon(resizedEnemyImage));

        // Crear las barras de vida para cada personaje
        lifeLabel = new BarLabel(100, 100, BarType.LIFE);
        magicLabel = new BarLabel(30, 100, BarType.MAGIC);
        explabel = new BarLabel(0, 350, BarType.EXPERIENCE);

        //TODO: Crear área de texto para el registro del juego
        gameLog = new JTextArea();
        gameLog.setEditable(false);
        gameLog.setFont(new Font("Serif", Font.PLAIN, 16)); // Configurar la fuente
        JScrollPane scrollPane = new JScrollPane(gameLog);

        // Crear el panel para las imágenes (personaje y enemigo)
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0)); // Ajusta el espaciado horizontal
        imagePanel.add(playerImageLabel);
        imagePanel.add(enemyImageLabel);

        // Crear el panel para las barras de vida
        JPanel healthPanel = new JPanel();
        healthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10)); // Espaciado vertical de 10 píxeles
        healthPanel.add(lifeLabel);
        healthPanel.add(magicLabel);
        healthPanel.add(explabel);

        // Crear un panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);

        // Agregar los componentes al panel principal
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(imagePanel, BorderLayout.NORTH); // Mostrar las imágenes en la parte superior
        mainPanel.add(healthPanel, BorderLayout.SOUTH); // Mostrar las barras de vida en la parte inferior
        mainPanel.add(buttonPanel, BorderLayout.EAST);  // Puedes agregar un panel para los botones

        // Acción del botón Iniciar Juego
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
    }

    private void addBackgroundImage() {
        // Crear el fondo
        ImageIcon backgroundIcon = new ImageIcon("../../imagenes/Fondodepelea.png"); // Ruta de tu imagen de fondo
        Image backgroundImage = backgroundIcon.getImage();
        Image resizedBackgroundImage = backgroundImage.getScaledInstance(WINDOW_SIZE.width, WINDOW_SIZE.height, Image.SCALE_SMOOTH); // Redimensiona la imagen al tamaño de la ventana
        JLabel backgroundLabel = new JLabel(new ImageIcon(resizedBackgroundImage));

        // Establecer el fondo en el panel
        mainPanel.add(backgroundLabel, BorderLayout.CENTER);
        mainPanel.setLayout(new BorderLayout());
    }

    private void startGame() {
        // Crear el jugador y enemigo
        Player player = new Player("Zelda");
        Enemy enemy = new Enemy("Bayonetta");

        // Mostrar un mensaje en el área de texto (game log)
        gameLog.append("Juego iniciado: " + player.getName() + " vs " + enemy.getName() + "\n");

        // Crear y mostrar la interfaz del juego
        GameUI gameUI = new GameUI(player, enemy);
        gameUI.startGame();  // Método para iniciar el juego
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
