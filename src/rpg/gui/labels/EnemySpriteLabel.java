package rpg.gui.labels;

import rpg.entities.enemies.Enemy;
import rpg.gui.ui.EnemyLabelUI;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa una etiqueta personalizada que muestra el sprite de un enemigo.
 * Se utiliza para mostrar la imagen del enemigo en la interfaz gráfica de usuario (GUI),
 * y se actualiza cuando el sprite del enemigo cambia.
 */
public class EnemySpriteLabel extends JLabel {

    private ImageIcon icon; // Icono que representa al enemigo.
    private Enemy enemy; // El enemigo cuyo sprite se va a mostrar.

    /**
     * Constructor de la clase EnemySpriteLabel.
     * Inicializa el componente con el sprite del enemigo.
     *
     * @param enemy El enemigo cuyo sprite se debe mostrar.
     */
    public EnemySpriteLabel(Enemy enemy) {
        this.enemy = enemy;
        initComponents(); // Inicializa los componentes (carga el sprite).
        setUI(new EnemyLabelUI(icon)); // Establece la apariencia personalizada.
    }

    /**
     * Inicializa los componentes de la etiqueta.
     * Establece el icono del enemigo y ajusta el tamaño de la etiqueta.
     */
    public void initComponents() {
        icon = enemy.getSprite(); // Obtiene el sprite del enemigo.
        setPreferredSize(getMinDimension()); // Establece las dimensiones mínimas de la etiqueta.
        setSize(getMinDimension()); // Establece el tamaño de la etiqueta.
        setIcon(icon); // Establece el icono de la etiqueta.
    }

    /**
     * Calcula las dimensiones mínimas necesarias para mostrar el sprite del enemigo.
     * Si el sprite es demasiado grande, lo ajusta para que no supere ciertas dimensiones.
     *
     * @return Las dimensiones mínimas necesarias para mostrar el sprite.
     */
    private Dimension getMinDimension() {
        // Si el sprite es demasiado grande, se ajusta al tamaño máximo permitido.
        if (icon.getIconWidth() > 350 || icon.getIconHeight() > 350) {
            icon = new ImageIcon(icon.getImage().getScaledInstance(450, 250, Image.SCALE_SMOOTH));
        }
        return new Dimension(icon.getIconWidth(), icon.getIconHeight()); // Devuelve el tamaño del icono.
    }

    /**
     * Actualiza el sprite del enemigo y vuelve a ajustar la apariencia de la etiqueta.
     * Llama a revalidate() y repaint() para actualizar la interfaz de usuario.
     */
    public void updateSprite() {
        icon = enemy.getSprite(); // Obtiene el nuevo sprite del enemigo.
        setUI(new EnemyLabelUI(icon)); // Actualiza la apariencia de la etiqueta.
        setPreferredSize(getMinDimension()); // Ajusta el tamaño de la etiqueta.
        setSize(getMinDimension()); // Ajusta el tamaño de la etiqueta.
        setIcon(icon); // Establece el nuevo icono.
        revalidate(); // Revalida la interfaz para aplicar los cambios.
        repaint(); // Repinta la interfaz para reflejar los cambios visuales.
    }

    /**
     * Establece un nuevo enemigo y actualiza el sprite mostrado.
     *
     * @param enemy El nuevo enemigo cuyo sprite se debe mostrar.
     */
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy; // Establece el nuevo enemigo.
        updateSprite(); // Actualiza el sprite mostrado.
    }
}