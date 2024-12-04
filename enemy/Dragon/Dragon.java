package rpg.entities.enemy.Dragon;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;

public class Dragon extends Enemy {

    /**
     * Agregar constructor para Dragon
     */

    public Dragon (String name){
        /**
         * Escribir el tipo de enemigo
         */
        super(name, "Dragon");
        this.stats.put(Stats.HP, 300);
        this.stats.put(Stats.ATTACK, 20);
        this.stats.put(Stats.DEFENSE, 10);
    }
}
