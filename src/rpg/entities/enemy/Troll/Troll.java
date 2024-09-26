package rpg.entities.enemy.Troll;
import rpg.entities.enemy.Enemy;
import rpg.enums.Stats;

public class Troll extends Enemy {

    /**
     * Agregar constructor para Troll
     */

    public Troll (String name){
        /**
         * Escribir el tipo de enemigo
         */
        super(name, "Troll");
        this.stats.put(Stats.HP, 200);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 8);
    }
}
