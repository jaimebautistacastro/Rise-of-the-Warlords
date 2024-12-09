package rpg.gui.internalFrames;

import rpg.enums.Stats;
import rpg.gui.UIConstants;
import rpg.gui.labels.IconLabel;
import rpg.gui.labels.NameLabel;
import rpg.gui.panels.InternPanel;
import rpg.gui.panels.ItemDisplayPanel;
import rpg.gui.ui.TransparentFrameUI;
import rpg.gui.windows.MainWindow;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Clase que representa una ventana interna donde se muestran las estadísticas y equipo de un jugador.
 * Incluye la visualización de las estadísticas como ataque y defensa, así como los íconos para las piezas de equipo del jugador.
 */
public class StatusFrame extends JInternalFrame {

    private JPanel mainPanel; // Panel principal que contiene los componentes.
    private JLabel attackIcon; // Icono para la estadística de ataque.
    private JLabel defenseIcon; // Icono para la estadística de defensa.
    private JLabel headIcon; // Icono para el casco o armadura de cabeza.
    private JLabel chestIcon; // Icono para la armadura de pecho.
    private JLabel legsIcon; // Icono para la armadura de piernas.
    private JLabel feetIcon; // Icono para la armadura de pies.
    private JLabel handIcon; // Icono para la armadura de manos.
    private JLabel weaponIcon; // Icono para el arma del jugador.
    private JPanel headItemDisplay; // Panel para mostrar el equipo de cabeza.
    private JPanel chestItemDisplay; // Panel para mostrar el equipo de pecho.
    private JPanel legsItemDisplay; // Panel para mostrar el equipo de piernas.
    private JPanel feetItemDisplay; // Panel para mostrar el equipo de pies.
    private JPanel handItemDisplay; // Panel para mostrar el equipo de manos.
    private JPanel weaponItemDisplay; // Panel para mostrar el arma del jugador.
    private JLabel attackDisplay; // Etiqueta que muestra el valor de ataque.
    private JLabel defenseDisplay; // Etiqueta que muestra el valor de defensa.
    private InternalStatusBar internalStatusBar; // Barra de estado interna.
    private Dimension dimension; // Dimensiones de la ventana.
    private MainWindow window; // Ventana principal de la aplicación.

    /**
     * Constructor de la clase StatusFrame.
     * Inicializa la ventana interna con un tamaño específico y configura su apariencia.
     *
     * @param window La ventana principal que contiene esta ventana interna.
     */
    public StatusFrame(MainWindow window) {
        this.window = window;
        setContentPane(mainPanel); // Establece el panel principal como contenido de la ventana.
        dimension = new Dimension(UIConstants.STATUS_FRAME_WIDTH, UIConstants.STATUS_FRAME_HEIGHT);
        setUI(new TransparentFrameUI(this, dimension)); // Configura la apariencia del marco.
        setSize(getPreferredSize()); // Establece el tamaño de la ventana.
    }

    /**
     * Método que inicializa los componentes de la interfaz de usuario, como los íconos, etiquetas y paneles.
     * También agrega los íconos de las estadísticas y las piezas de equipo a la caché de imágenes.
     */
    private void createUIComponents() {
        int displayHeight = UIConstants.STATUS_FRAME_HEIGHT -
                UIConstants.INTERNAL_FRAME_HEADER_HEIGHT;
        mainPanel = new InternPanel(UIConstants.STATUS_FRAME_WIDTH, displayHeight); // Inicializa el panel principal.
        mainPanel.setBorder(new EmptyBorder(2, 10, 18, 10)); // Establece un borde para el panel principal.

        // Agrega los íconos a la caché de imágenes.
        ImageCache.addImage("attackIcon", "icons/attackIcon.png");
        ImageCache.addImage("defenseIcon", "icons/defenseIcon.png");
        ImageCache.addImage("headIcon", "icons/headArmorIcon.png");
        ImageCache.addImage("chestIcon", "icons/chestArmorIcon.png");
        ImageCache.addImage("legsIcon", "icons/legArmorIcon.png");
        ImageCache.addImage("feetIcon", "icons/feetArmorIcon.png");
        ImageCache.addImage("handIcon", "icons/handArmorIcon.png");
        ImageCache.addImage("weaponIcon", "icons/weaponIcon.png");

        // Inicializa los íconos y etiquetas de estadísticas y equipo.
        attackIcon = new IconLabel(ImageCache.getImageIcon("attackIcon"));
        attackDisplay = new NameLabel(window.getPlayer().getStats().get(Stats.ATTACK).toString());
        defenseIcon = new IconLabel(ImageCache.getImageIcon("defenseIcon"));
        defenseDisplay = new NameLabel(window.getPlayer().getStats().get(Stats.DEFENSE).toString());
        headIcon = new IconLabel(ImageCache.getImageIcon("headIcon"));
        headItemDisplay = new ItemDisplayPanel(null);
        chestIcon = new IconLabel(ImageCache.getImageIcon("chestIcon"));
        chestItemDisplay = new ItemDisplayPanel(null);
        legsIcon = new IconLabel(ImageCache.getImageIcon("legsIcon"));
        legsItemDisplay = new ItemDisplayPanel(null);
        feetIcon = new IconLabel(ImageCache.getImageIcon("feetIcon"));
        feetItemDisplay = new ItemDisplayPanel(null);
        handIcon = new IconLabel(ImageCache.getImageIcon("handIcon"));
        handItemDisplay = new ItemDisplayPanel(null);
        weaponIcon = new IconLabel(ImageCache.getImageIcon("weaponIcon"));
        weaponItemDisplay = new ItemDisplayPanel(null);
    }
}