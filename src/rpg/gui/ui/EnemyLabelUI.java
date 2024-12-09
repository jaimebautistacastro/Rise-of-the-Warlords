package rpg.gui.ui;

import javax.swing.plaf.basic.BasicLabelUI;
import javax.swing.*;
import java.awt.*;

/**
 * Clase personalizada que define la interfaz de usuario para las etiquetas de enemigos.
 * Permite mostrar un icono personalizado para los enemigos.
 */
public class EnemyLabelUI extends BasicLabelUI {

    /**
     * Icono que se muestra para el enemigo.
     */
    ImageIcon icon;

    /**
     * Constructor que inicializa la etiqueta con un icono.
     *
     * @param icon Icono que se asigna a la etiqueta.
     */
    public EnemyLabelUI(ImageIcon icon) {
        this.icon = icon;
    }

    /**
     * Metodo para establecer los valores predeterminados del componente JLabel.
     * Configura la visibilidad y el borde de la etiqueta.
     *
     * @param c JLabel que representa el enemigo.
     */
    @Override
    protected void installDefaults(JLabel c) {
        c.setOpaque(false);
        c.setBorder(null);
    }

    /**
     * Metodo encargado de dibujar el icono del enemigo en la etiqueta.
     *
     * @param g Graficos utilizados para dibujar el icono.
     * @param c Componente JLabel que representa al enemigo.
     */
    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.drawImage(icon.getImage(), 0, 0, icon.getIconWidth(),
                icon.getIconHeight(), c);
    }
}