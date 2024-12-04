package rpg.entities.enemy.Skeleton;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;

public class Skeleton extends Enemy {
    /**
     * Agregar constructor para Skeleton
     */

    public Skeleton (String name){
        /**
         * Agregar tipo de enemigo
         */
        super(name, "Skeleton");
        this.stats.put(Stats.HP, 70);
        this.stats.put(Stats.ATTACK, 8);
        this.stats.put(Stats.DEFENSE,3);
    }
}
