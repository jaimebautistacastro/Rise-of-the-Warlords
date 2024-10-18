package rpg.entities;

import rpg.Game;
import rpg.entities.enemy.Enemy;
import rpg.entities.enemy.Goblin.Goblin;
import rpg.entities.enemy.Orc.Orc;
import rpg.entities.enemy.Dragon.Dragon;
import rpg.entities.enemy.Troll.Troll;
import rpg.entities.enemy.Skeleton.Skeleton;
import rpg.enums.ItemType;
import rpg.enums.Stats;
import rpg.enums.WeaponType;
import rpg.inventory.Inventory;
import rpg.items.armors.Armor;
import rpg.items.armors.IronArmor;
import rpg.items.armors.WoodArmor;
import rpg.items.miscs.Misc;
import rpg.items.weapons.Weapon;

import javax.swing.*;
import java.awt.*;
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
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Crear área de texto para mostrar el registro del juego
         */

        gameLog = new JTextArea();
        gameLog.setEditable(false);
        gameLog.setFont(new Font("Serif", Font.PLAIN, 16)); // Configurar la fuente del JTextArea
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
     * Función para mostrar el mensaje de bienvenida
     */
    private void showWelcomeMessage() {
        appendToLog("¡Bienvenido a Rise of the Warlords!");
        appendToLog("Tu aventura comienza entre " + player.getName() + " y " + enemy.getName() + ".");
        appendToLog(player.getName() + " empieza con " + player.getLife() + " puntos de vida.");
        appendToLog(enemy.getName() + " empieza con " + enemy.stats.get(Stats.HP) + " puntos de vida.");
    }

    /**
     * Función para controlar el ataque del jugador
     */
    private void playerAttack() {

        /**
         * Verificar si el jugador o el enemigo están muertos antes de atacar
         */
        if (player.isDead()) {
            displayGameOverMessage(player.getName() + " está derrotado! El juego ha terminado.");
            attackButton.setEnabled(false);
            return;
        }

        /**
         * Ataque del jugador
         */
        int playerDamage = player.attack(enemy, 10);
        enemy.takeDamage(playerDamage); // Aplicar daño al enemigo
        appendToLog(player.getName() + " ataca a " + enemy.getName() + " generando " + playerDamage + " puntos de daño. " +
                enemy.getName() + " tiene " + enemy.stats.get(Stats.HP) + " puntos de vida restantes.");

        /**
         * Verificar si el enemigo está muerto
         */

        if (enemy.isDead()) {
            appendToLog(enemy.getName() + " está derrotado.");
            attackButton.setEnabled(false); // Desactivar el botón
            displayGameOverMessage(player.getName() + " ha ganado el juego!");
        } else {

            /**
             * Retrasar el contraataque del enemigo
             */

            Timer enemyAttackTimer = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    enemyAttack();
                }
            });
            enemyAttackTimer.setRepeats(false);
            enemyAttackTimer.start();
        }
    }

    /**
     * Función para controlar el contraataque del enemigo
     */

    private void enemyAttack() {

        /**
         * Verificar si el jugador está muerto antes de atacar
         */

        if (enemy.isDead()) {
            displayGameOverMessage("El juego ha terminado.");
            attackButton.setEnabled(false);
            return;
        }

        /**
         * Ataque del enemigo
         */

        int enemyDamage = enemy.attack(player);
        player.takeDamage(enemyDamage);
        appendToLog(enemy.getName() + " ataca a " + player.getName() + " generando " + enemyDamage + " puntos de daño. " +
                player.getName() + " tiene " + player.getLife() + " puntos de vida restantes.");

        /**
         * Verificar si el jugador está muerto
         */

        if (player.isDead()) {
            appendToLog(player.getName() + " está derrotado! El juego ha terminado.");
            attackButton.setEnabled(false); // Desactivar el botón
            displayGameOverMessage(enemy.getName() + " ha ganado el juego!");
        }
    }

    /**
     * Función para mostrar el mensaje de fin del juego
     * @param message
     */

    private void displayGameOverMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Función para comenzar el juego y mostrar su ventana
     */

    public void startGame() {
        setVisible(true);
        showWelcomeMessage();
    }

    public void displayMessage(String message) {
        appendToLog(message);
    }

    /**
     * Función para agregar texto al log del juego
     * @param text
     */

    public void appendToLog(String text) {
        gameLog.append(text + "\n");
    }

    /**
     *  Función para crear un enemigo aleatorio
     * @return
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
                return new Dragon("Dragón Imponente");
            case 3:
                return new Troll("Troll Feroz");
            case 4:
                return new Skeleton("Esqueleto Oscuro");
            default:
                return null;
        }
    }

    /**
     * Función principal
     * @param args
     */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Enemy enemy = createRandomEnemy();

            Inventory inventory = new Inventory(10);
            Armor armor = new IronArmor("Bronce", "Armadura básica", 450, 34, 32, "Defensa");
            inventory.addItem(armor);

            Weapon weapon = new Weapon("Pistola", "Arma de distancia", 555, WeaponType.CROSSBOW);
            inventory.addItem(weapon);

            Misc misc = new Misc("Poción", "Curación", 455, "Curación rápida", 10, 1, ItemType.MISC);
            inventory.addItem(misc);

            /**
             * Creación del personaje
             */

            Player player = new Player("Zelda");
            player.usePotion(misc.getPotency());
            player.equipWeapon(20);
            player.equipArmor(3);

            /**
             * Creación del juego
             */

            GameUI gameUI = new GameUI(player, enemy);

            /**
             * Iniciar el juego
             */

            gameUI.startGame();
        });
    }
}