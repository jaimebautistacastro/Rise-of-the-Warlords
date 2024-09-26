import rpg.entities.Enemy;
import rpg.entities.Player;

public class Game {

    private Player player;
    private Enemy enemy;
    private GameUI gameUI;

    public Game(Player player, Enemy enemy,GameUI gameUI){
        this.player = player;
        this.enemy =enemy;
        this.gameUI =gameUI;
    }

    public void startGame (){
        /**
         * Termina el proceso aqui, debido que el temporizador en GameUI maneja las acciones
         */
    }
}
