package rpg.entities.enemy.Orc;
import rpg.entities.enemy.Enemy;
import rpg.enums.Stats;

public class Orc extends Enemy {

    /**
     * Agregar constructor para Orc
     */

    public Orc (String name){
        /**
         * Escribir el tipo de enemigo
         */
        super(name, "Orc");
        this.stats.put(Stats.HP, 150);
        this.stats.put(Stats.ATTACK, 12);
        this.stats.put(Stats.DEFENSE, 6);
    }
}
