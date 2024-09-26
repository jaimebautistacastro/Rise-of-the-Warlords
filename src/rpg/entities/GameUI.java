package rpg.entities;

import rpg.Game;
import rpg.entities.enemy.Enemy;
import rpg.entities.enemy.Goblin.Goblin;
import rpg.entities.enemy.Orc.Orc;
import rpg.entities.enemy.Dragon.Dragon;
import rpg.entities.enemy.Troll.Troll;
import rpg.entities.enemy.Skeleton.Skeleton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameUI extends JFrame {
    private JTextArea gameLog;
    private JButton attackButton;
    private Player player;
    private Enemy enemy;
    private Game game;

    public GameUI(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;

        /**
         * Configuración de la ventana
         */
        setTitle("Rise of the Warlords");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Crear área de texto para mostrar el registro del juego
         */
        gameLog = new JTextArea();
        gameLog.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(gameLog);

        /**
         * Crear botón de Ataque
         */
        attackButton = new JButton("Atacar");
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Cuando el jugador ataca
                 */
                playerAttack();
            }
        });

        /**
         * Añadir el área de texto y el botón al marco
         */
        add(scrollPane, "Center");
        add(attackButton, "South");

        /**
         * Iniciar el juego
         */
        game = new Game(player, enemy, this);
    }

    /**
     * Función para controlar el ataque del jugador
     */
    private void playerAttack() {
        int playerDamage = player.attack(enemy);
        appendToLog(player.getName() + " Ataca " + enemy.getName() + " generando " + playerDamage + " puntos de daño ");

        if (enemy.isDead()) {
            appendToLog(enemy.getName() + " Está derrotado ");
            /**
             * Deshabilitar el botón si el enemigo está muerto
             */
            attackButton.setEnabled(false);
        } else {
            /**
             * Retrasar contraataque del enemigo
             */
            Timer enemyAttackTimer = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    enemyAttack();
                }
            });

            /**
             * Solo ejecuta una vez
             */
            enemyAttackTimer.setRepeats(false);
            enemyAttackTimer.start();
        }
    }

    /**
     * Función para controlar contraataque del enemigo
     */
    private void enemyAttack() {
        int enemyDamage = enemy.attack(player);
        appendToLog(enemy.getName() + " Ataca " + player.getName() + " generando " + enemyDamage + " puntos de daño ");

        if (player.isDead()) {
            appendToLog(player.getName() + " Esta derrotado! El juego ha terminado.");
            /**
             * Deshabilitar el botón si el jugador está muerto
             */
            attackButton.setEnabled(false);
        }
    }

    /**
     * Función para comenzar el juego y mostrar su ventana
     */
    public void starGame() {
        setVisible(true);
        appendToLog("El juego comienza entre " + player.getName() + " y " + enemy.getName() + " ");
    }

    /**
     * Función para agregar texto al log del juego
     */
    public void appendToLog(String text) {
        gameLog.append(text + "\n");
    }

    /**
     * Método para mostrar un mensaje específico en el área de texto
     */
    public void displayMessage(String message) {
        /**
         * Reutilizar appenToLog para mostrar el mensaje
         */
        appendToLog(message);
    }

    /**
     * Método para crear un enemigo aleatorio
     */
    private static Enemy createRandomEnemy() {
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
                return null;
        }
    }

    /**
     * Función principal
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Player player = new Player("Zelda");
            /**
             * Crear un enemigo aleatorio
             */
            Enemy enemy = createRandomEnemy();
            GameUI gameUI = new GameUI(player, enemy);
            /**
             * Iniciar el juego
             */
            gameUI.starGame();
        });
    }
}