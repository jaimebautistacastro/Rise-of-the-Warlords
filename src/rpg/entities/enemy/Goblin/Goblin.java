package rpg.entities.enemy.Goblin;

import rpg.entities.enemy.Enemy;
import rpg.enums.Stats;

public class Goblin extends Enemy {

    /**
     * Agregar constructor para Goblin
     */

    public Goblin (String name){
        /**
         * Escribir el tipo de enemigo
         */
        super(name, "Goblin");
        this.stats.put(Stats.HP, 80);
        this.stats.put(Stats.ATTACK,5);
        this.stats.put(Stats.DEFENSE,2);
    }
}
