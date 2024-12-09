package rpg.gui.panels;

import rpg.enums.Stats;
import rpg.gui.UIConstants;
import rpg.items.Equipment;
import rpg.items.Item;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Panel que muestra la información de un objeto en el juego, incluyendo su icono,
 * nombre y descripción. El panel también está diseñado para mostrar información
 * adicional como el poder de ataque de un equipo, si se trata de un objeto del tipo
 * {@link Equipment}.
 */
public class ItemDisplayPanel extends BackgroundPanel {

    // Componentes visuales del panel
    private JLabel itemIcon;          // Icono del objeto
    private JLabel itemName;          // Nombre del objeto
    private JPanel mainPanel;         // Panel principal que contiene los elementos
    private JLabel itemDescription;   // Descripción del objeto
    private Item item;                // Objeto que se muestra en el panel

    /**
     * Constructor que inicializa el panel con un objeto.
     *
     * @param item El objeto que se mostrará en el panel.
     */
    public ItemDisplayPanel(Item item) {
        super();
        this.item = item;
        mainPanel.setSize(new Dimension(500, 70));
        mainPanel.setPreferredSize(mainPanel.getSize());
        add(mainPanel);
    }

    /**
     * Método que inicializa el panel, establece la imagen de fondo y las dimensiones,
     * así como los bordes.
     */
    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("itemDisplayPanel",
                "labels/equipHolder.png"));
        setDimension(new Dimension(500, 85));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        getInsets().set(0, 0, 0, 0);
    }

    /**
     * Crea los componentes visuales del panel, como el icono, nombre y descripción
     * del objeto. Si el objeto es un {@link Equipment}, también se muestra su
     * poder de ataque.
     */
    private void createUIComponents() {

        if (item != null) {
            // Se establece el icono, nombre y descripción del objeto
            itemIcon = new JLabel(item.getIcon());
            Equipment equipment = (Equipment) item;
            itemName = new JLabel(String.format("%s ATQ(%d)", equipment.getName(),
                    equipment.getStats().get(Stats.ATTACK)));
            itemDescription = new JLabel(item.getDescription());
            // Se ajusta el estilo de las fuentes
            itemName.setFont(UIConstants.FONT.deriveFont(16.5f));
            itemDescription.setFont(UIConstants.FONT.deriveFont(16.5f));
        } else {
            // Si no hay un objeto, se dejan los componentes vacíos
            itemIcon = new JLabel();
            itemName = new JLabel();
            itemDescription = new JLabel();
        }
    }
}