package rpg.gui.internalFrames;

import rpg.gui.UIConstants;
import rpg.gui.ui.StatusBarUI;
import rpg.gui.panels.CenterPanel;
import rpg.gui.panels.LeftCornerPanel;
import rpg.gui.panels.RightCornerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa una barra de estado personalizada dentro de una ventana interna.
 * Se utiliza para mostrar información o acciones rápidas en la parte superior de la ventana interna.
 * La barra de estado tiene un título, un botón para ocultar la ventana, y paneles en las esquinas.
 */
public class InternalStatusBar extends JPanel {

    private JPanel leftCornerPanel; // Panel en la esquina izquierda.
    private JPanel rightCornerPanel; // Panel en la esquina derecha.
    private JPanel centerCornerPanel; // Panel central de la barra de estado.
    private JPanel mainPanel; // Panel principal que contiene los otros componentes.
    private JButton button1; // Botón para realizar alguna acción, como ocultar la ventana.
    private JLabel internalTitle; // Título de la barra de estado.

    /**
     * Constructor de la clase InternalStatusBar.
     * Configura el título de la barra de estado, la fuente y el estilo, y asigna la acción al botón de cierre.
     *
     * @param title El título que se mostrará en la barra de estado.
     * @param dimension Las dimensiones de la barra de estado.
     * @param internalFrame La ventana interna a la que pertenece esta barra de estado.
     */
    public InternalStatusBar(String title, Dimension dimension,
                             JInternalFrame internalFrame) {
        add(mainPanel); // Agrega el panel principal al contenedor de la barra de estado.
        internalTitle.setText(title); // Establece el título de la barra de estado.
        internalTitle.setFont(UIConstants.FONT.deriveFont(Font.BOLD, 25f)); // Configura la fuente del título.
        setUI(new StatusBarUI(dimension)); // Configura la interfaz de la barra de estado.
        updateWidth(dimension.width); // Actualiza el ancho de los paneles internos.

        // Acción del botón de cierre, oculta la ventana interna al hacer clic.
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internalFrame.setVisible(false); // Oculta la ventana interna.
            }
        });
    }

    /**
     * Actualiza el ancho de la barra de estado y sus componentes internos.
     *
     * @param width El nuevo ancho de la barra de estado.
     */
    public void updateWidth(int width) {
        mainPanel.setSize(width, 77); // Actualiza el tamaño del panel principal.
        setSize(width, 77); // Actualiza el tamaño de la barra de estado.
        ((CenterPanel) centerCornerPanel).setDimension(new Dimension(width - 100, 77)); // Actualiza el tamaño del panel central.
    }

    /**
     * Metodo utilizado para crear los componentes de la interfaz de usuario, como los paneles.
     * Se llama automáticamente durante la inicialización de la barra de estado.
     */
    private void createUIComponents() {
        leftCornerPanel = new LeftCornerPanel(); // Panel en la esquina izquierda.
        rightCornerPanel = new RightCornerPanel(); // Panel en la esquina derecha.
        centerCornerPanel = new CenterPanel(); // Panel central.
    }
}