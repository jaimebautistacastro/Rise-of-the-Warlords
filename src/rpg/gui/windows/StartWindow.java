package rpg.gui.windows;

import rpg.entities.Player;
import rpg.enums.Stats;
import rpg.gui.UIConstants;
import rpg.gui.buttons.LoadFileButton;
import rpg.gui.buttons.NewFileButton;
import rpg.gui.labels.NameLabel;
import rpg.gui.panels.FilesPanel;
import rpg.gui.ui.NameLabelUI;
import rpg.Utils.FileManager;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * La clase StartWindow representa la ventana principal del juego donde el jugador puede cargar o crear una nueva partida.
 * Muestra una lista de 5 ranuras de guardado, con opciones para cargar o crear un archivo en cada ranura.
 */
public class StartWindow extends JFrame {

    // Componentes de la ventana
    private JPanel mainPanel;
    private JButton newFile1;
    private JButton loadFile1;
    private JLabel titleLabel;
    private JLabel file1Name;
    private JLabel file2Name;
    private JLabel file3Name;
    private JLabel file4Name;
    private JLabel file5Name;
    private JButton newFile2;
    private JButton newFile3;
    private JButton newFile4;
    private JButton newFile5;
    private JButton loadFile2;
    private JButton loadFile3;
    private JButton loadFile4;
    private JButton loadFile5;

    /**
     * Metodo principal para lanzar la ventana de inicio del juego.
     * Crea una instancia de la ventana y la muestra al usuario.
     *
     * @param args Los argumentos de la línea de comandos (no se usan aquí).
     */
    public static void main(String[] args) {
        new StartWindow();
    }

    /**
     * Constructor de la clase StartWindow. Inicializa la ventana y sus componentes.
     */
    public StartWindow() {
        // Configura el panel principal de la ventana
        this.setContentPane(mainPanel);
        // Establece el título de la ventana
        this.setTitle("Java RPG");
        // Ajusta el tamaño de la ventana según las constantes definidas en UIConstants
        this.setSize(UIConstants.START_WINDOW_DIMENSION);
        // Define la acción de cierre de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Centra la ventana en la pantalla
        this.setLocationRelativeTo(null);
        // Desactiva la opción de redimensionar la ventana
        this.setResizable(false);
        // Hace visible la ventana
        this.setVisible(true);
        // Actualiza la información de los archivos de juego
        update();
    }

    /**
     * Actualiza la información de las ranuras de guardado, mostrando si están vacías o cargando los datos del jugador.
     * Si el archivo de la ranura está vacío, muestra un mensaje indicando que está vacío.
     * Si hay datos, muestra el nombre del jugador y su nivel.
     */
    public void update() {
        // Recorre las ranuras de guardado (1 a 5)
        for (int i = 1; i <= 5; i++) {
            // Variables para manejar la ranura
            JLabel slotLabel = null;
            String slotName;
            Player player;
            JButton newFileButton;
            JButton loadFileButton;
            try {
                // Accede a los componentes de la interfaz correspondientes a la ranura
                slotLabel = (JLabel) getClass()
                        .getDeclaredField("file" + i + "Name").get(this);
                newFileButton = (JButton) getClass()
                        .getDeclaredField("newFile" + i).get(this);
                loadFileButton = (JButton) getClass()
                        .getDeclaredField("loadFile" + i).get(this);

                // Verifica si el archivo de la ranura está vacío
                if (isFileEmpty(i)) {
                    slotLabel.setText("-- Vació --");
                    slotLabel.setUI(new NameLabelUI());
                    newFileButton.setVisible(true);
                    loadFileButton.setVisible(false);
                    continue;
                } else {
                    newFileButton.setVisible(false);
                    loadFileButton.setVisible(true);
                    player = Player.load(i);
                }

                // Si se carga el jugador, muestra su nombre y nivel
                if (player != null) {
                    slotName = String.format("%s - NIVEL: %d",
                            player.getName().toUpperCase(),
                            player.getStats().get(Stats.LEVEL));
                    slotLabel.setText(slotName);
                    slotLabel.setUI(new NameLabelUI());
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                // Muestra un mensaje de error si no se puede acceder a los archivos o campos
                JOptionPane.showMessageDialog(null, "Error al cargar la partida " + i,
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                // Si ocurre algún error inesperado, marca la ranura como vacía
                slotLabel.setText("-- Vació --");
                slotLabel.setUI(new NameLabelUI());
                try {
                    loadFileButton = (JButton) getClass()
                            .getDeclaredField("loadFile" + i).get(this);
                    loadFileButton.setVisible(false);
                } catch (IllegalAccessException | NoSuchFieldException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Metodo para crear los componentes de la interfaz gráfica, como los botones, etiquetas y paneles.
     */
    private void createUIComponents() {
        // Panel principal con el diseño de las ranuras de archivos
        mainPanel = new FilesPanel();
        // Etiqueta del título
        titleLabel = new JLabel("Java RPG");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));

        // Inicialización de las etiquetas y botones para las ranuras de guardado
        file1Name = new NameLabel("");
        newFile1 = new NewFileButton(1, this);
        loadFile1 = new LoadFileButton(1, this);
        file2Name = new NameLabel("");
        newFile2 = new NewFileButton(2, this);
        loadFile2 = new LoadFileButton(2, this);
        file3Name = new NameLabel("");
        newFile3 = new NewFileButton(3, this);
        loadFile3 = new LoadFileButton(3, this);
        file4Name = new NameLabel("");
        newFile4 = new NewFileButton(4, this);
        loadFile4 = new LoadFileButton(4, this);
        file5Name = new NameLabel("");
        newFile5 = new NewFileButton(5, this);
        loadFile5 = new LoadFileButton(5, this);
    }

    /**
     * Verifica si el archivo de la ranura está vacío.
     *
     * @param slot El número de la ranura que se desea verificar.
     * @return true si el archivo está vacío, false si existe y contiene datos.
     */
    private boolean isFileEmpty(int slot) {
        // Verifica si el archivo de guardado existe para la ranura especificada
        return !new File("files/save" + slot + ".dat").exists();
    }
}