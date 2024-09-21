package rpg.entities;

import rpg.enums.Stats;

import java.util.HashMap;

public class Enemy {

    private String name;
    private HashMap<Stats,Integer>stats;

    public Enemy (String name){
        this.name = name;
        this.stats = new HashMap<>();
        this.stats.put(Stats.HP,110);
        this.stats.put(Stats.ATTACK,7);
    }

    public String getName(){
        return this.name;
    }

    /**
     * Función para atacar al jugador y devolver el daño infligido
     */

    public int attack (Player player){
        int attackPower = this.stats.get(Stats.ATTACK);
        player.receiveDamage (attackPower);
        return attackPower;
    }

    /**
     * Función para recibir daño
     */

    public void receiveDamage (int damage){
        int currentHP =this.stats.get (Stats.HP);
        this.stats.put (Stats.HP,currentHP-damage);
        System.out.println(this.name + "receives" + damage + "damage.Remaining HP:" + this.stats.get (Stats.HP));
    }

    /**
     * Función para corroborar que el enemigo está muerto
     */

    public boolean isDead (){
        return this.stats.get (Stats.HP) <= 0;
    }
}
