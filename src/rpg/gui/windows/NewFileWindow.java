package rpg.gui.windows;

import rpg.gui.buttons.CreateButton;
import rpg.gui.buttons.ExitButton;
import rpg.gui.labels.PortraitLabel;
import rpg.gui.panels.NewPlayerPanel;

import javax.swing.*;
import java.awt.*;

/**
 * La clase NewFileWindow representa una ventana de creación de un nuevo archivo de juego.
 * Permite al jugador ingresar el nombre de su personaje y elegir la ranura de guardado.
 * También ofrece opciones para cancelar o crear un nuevo personaje.
 */
public class NewFileWindow extends JFrame {

    // Ranura de guardado seleccionada
    private int slot;

    // Campo de texto para el nombre del jugador
    private JTextField playerName;

    // Botones de cancelar y crear
    private JButton cancelButton;
    private JButton createButton;

    // Panel principal y componentes gráficos
    private JPanel mainPanel;
    private JLabel portraitLabel;
    private JLabel infoLabel;

    /**
     * Constructor de la ventana de creación de nuevo archivo.
     * Inicializa los componentes de la ventana y configura sus propiedades.
     *
     * @param slot La ranura seleccionada para guardar el nuevo archivo.
     */
    public NewFileWindow(int slot) {

        this.slot = slot;
        // Configuración del panel principal de la ventana
        this.setContentPane(mainPanel);
        // Ajusta el tamaño de la ventana automáticamente según los componentes
        pack();
        // Configura el comportamiento de cierre de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Centra la ventana en la pantalla
        this.setLocationRelativeTo(null);
        // Desactiva la opción de redimensionar la ventana
        this.setResizable(false);
        // Hace visible la ventana
        this.setVisible(true);
        // Configura el estilo de la fuente para el campo de texto
        playerName.setFont(new Font("Retron", Font.BOLD, 18));
        playerName.setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
        playerName.setForeground(Color.WHITE); // Color del texto en blanco
    }

    /**
     * Método para crear los componentes de la interfaz gráfica.
     * Se invoca automáticamente para inicializar los componentes personalizados.
     */
    private void createUIComponents() {
        // Panel principal con el diseño de la ventana
        mainPanel = new NewPlayerPanel();
        // Etiqueta para el retrato del personaje
        portraitLabel = new PortraitLabel(null);
        // Etiqueta de información para guiar al jugador
        infoLabel = new JLabel();
        infoLabel.setOpaque(false); // Fondo transparente
        infoLabel.setFont(new Font("Retron", Font.BOLD, 18)); // Fuente personalizada
        infoLabel.setForeground(Color.WHITE); // Color del texto en blanco
        infoLabel.setText("Introduce el nombre de tu personaje:"); // Mensaje informativo
        // Botón para cancelar la creación de personaje
        cancelButton = new ExitButton();
        // Botón para crear el nuevo personaje
        createButton = new CreateButton(slot, this);
    }

    /**
     * Obtiene el nombre del personaje ingresado por el jugador.
     *
     * @return El nombre del jugador como un String.
     */
    public String getName() {
        return playerName.getText();
    }
}