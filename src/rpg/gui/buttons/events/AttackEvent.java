package rpg.gui.buttons.events;

import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.gui.windows.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Evento que maneja el ataque entre el jugador y el enemigo.
 * Implementa la interfaz ActionListener para reaccionar a los eventos de acción en los botones.
 */
public class AttackEvent implements ActionListener {

    /**
     * Ventana principal del juego, donde se muestra el estado del juego.
     */
    private final MainWindow game;

    /**
     * Constructor del evento de ataque.
     *
     * @param game la ventana principal del juego donde se maneja la logica de batalla.
     */
    public AttackEvent(MainWindow game) {
        this.game = game;
    }

    /**
     * Metodo que se ejecuta cuando se realiza un evento de acción (clic en el boton de ataque).
     * Realiza el ataque entre el jugador y el enemigo. El jugador ataca al enemigo y luego
     * el enemigo puede contraatacar si sigue vivo. Luego se actualiza el estado del juego.
     *
     * @param e el evento de acción (clic en el boton).
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        Enemy enemy = this.game.getEnemy(); // Obtiene el enemigo actual
        Player player = this.game.getPlayer(); // Obtiene el jugador actual
        if (enemy != null) {

            // El jugador ataca al enemigo y se muestra el mensaje
            this.game.appendText(player.attack(enemy));

            // Si el enemigo sigue vivo, contraataca al jugador
            if (enemy.isAlive())
                this.game.appendText(enemy.attack(player));

            // Verifica el estado del juego (si el jugador o el enemigo han muerto)
            this.game.checkGameStatus();
        }
    }
}