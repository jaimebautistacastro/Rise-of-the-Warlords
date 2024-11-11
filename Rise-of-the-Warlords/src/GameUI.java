import rpg.entities.Enemy;
import rpg.entities.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameUI extends JFrame {
    private JTextArea gameLog;
    private JButton attackButton;
    private Player player;
    private Enemy enemy;
    private Game game;

    public GameUI (Player player, Enemy enemy){
        this.player = player;
        this.enemy = enemy;

        /**
         * Configuración de la ventana
         */

        setTitle(" Rise-of-the-Warlords ");
        setSize(400,200);
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

        attackButton = new JButton(" Atacar ");
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

        add (scrollPane, "Center");
        add (attackButton, "South");

        /**
         * Iniciar el juego
         */

        game = new Game(player, enemy, this);
    }

    /**
     * Función para controlar el ataque del jugador
     */

    private void playerAttack(){
        int playerDamage = player.attack(enemy);
        appendToLog (player.getName() + " Ataca " + enemy.getName() + " generando " + playerDamage + " puntos de daño ");

        if (enemy.isDead()){
            appendToLog (enemy.getName() + " Está derrotado ");
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

    private void enemyAttack(){
        int enemyDamage = enemy.attack (player);
        appendToLog(enemy.getName() + " Ataca " + player.getName() + " generando " + enemyDamage + " puntos de daño ");

        if (player.isDead()){
            appendToLog(player.getName() + "Esta derrotado! El juego ha terminado.");
            /**
             * Deshabilitar el botón si el jugador está muerto
             */
            attackButton.setEnabled(false);
        }
    }

    /**
     * Función para comenzar el juego y mostrar su ventana
     */

    public void starGame (){
        setVisible(true);
        appendToLog(" El juego comienza entre " + player.getName() + " y " + enemy.getName() + " ");
    }

    /**
     * Función para agregar texto al log del juego
     */

    public void appendToLog (String text){
        gameLog.append(text + "\n");
    }

    /**
     * Función principal
     */

    public static void main (String[] args){
        SwingUtilities.invokeLater(() -> {
            Player player = new Player( " Zelda ");
            Enemy enemy = new Enemy (" Bayonetta ");
            GameUI gameUI = new GameUI(player,enemy);
            /**
             * Iniciar el juego
             */
            gameUI.starGame();
        });
    }

}
