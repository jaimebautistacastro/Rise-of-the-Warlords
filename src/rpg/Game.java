package rpg;

import rpg.entities.GameCharacter;
import rpg.entities.GameUI;
import rpg.entities.enemy.Enemy;
import rpg.entities.Player;
import rpg.entities.enemy.Goblin.Goblin;
import rpg.entities.enemy.Orc.Orc;
import rpg.entities.enemy.Dragon.Dragon;
import rpg.entities.enemy.Troll.Troll;
import rpg.entities.enemy.Skeleton.Skeleton;


import java.util.Random;

public class Game {

    private Player player;
    private Enemy enemy;
    private GameUI gameUI;

    /**
     * Agregar constructor del juego
     * @param player
     * @param enemy
     * @param gameUI
     */
    public Game(Player player, Enemy enemy, GameUI gameUI) {
        this.player = player;
        this.gameUI = gameUI;
        /**
         * Crear un enemigo aleatorio
         */
        this.enemy = createRandomEnemy();
    }

    public void startGame() {
        gameUI.displayMessage("El juego ha comenzado!");
        gameUI.displayMessage("Tu enemigo es: " + enemy.getName());

        /**
         * Agregar lógica de combate
         */
        while (player.isAlive() && enemy.isAlive()) {
            /**
             * El jugador ataca al enemigo
             */
            player.attack(enemy, 34);
            if (enemy.isAlive()) {
                /**
                 * El enemigo contraataca si sigue vivo
                 */
                enemy.attack(player);
            }
        }

        /**
         * Corroborar el resultado del combate
         */
        if (!player.isAlive()) {
            gameUI.displayMessage("Has sido derrotado por " + enemy.getName() + "!");
        } else {
            gameUI.displayMessage("Has derrotado a " + enemy.getName() + "!");
        }
    }

    /**
     * Función para crear un enemigo aleatorio
     */

    private Enemy createRandomEnemy() {
        Random rand = new Random();
        int enemyType = rand.nextInt(5);

        switch (enemyType) {
            case 0:
                return new Goblin("Goblin Guerrero");
            case 1:
                return new Orc("Orc Salvaje");
            case 2:
                return new Dragon("Dragon Imponente");
            case 3:
                return new Troll("Troll Feroz");
            case 4:
                return new Skeleton("Skeleton Oscuro");
            default:
                throw new IllegalStateException("Unexpected value: " + enemyType);
        }
    }
}