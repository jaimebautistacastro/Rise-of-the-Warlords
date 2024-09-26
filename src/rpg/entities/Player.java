package rpg.entities;

import rpg.entities.enemy.Enemy;
import rpg.enums.Stats;
import java.util.HashMap;

public class Player {
    private String name;
    private HashMap<Stats, Integer> stats;

    public Player(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.ATTACK, 6);
    }

    public String getName() {
        return this.name;
    }

    /**
     * Agregar función para atacar al enemigo y devolver daño infligido
     */
    public int attack(Enemy enemy) {
        int attackPower = this.stats.get(Stats.ATTACK);
        enemy.receiveDamage(attackPower);
        return attackPower;
    }

    /**
     * Función para recibir daño
     */
    public void receiveDamage(int damage) {
        int currentHP = this.stats.get(Stats.HP);
        this.stats.put(Stats.HP, currentHP - damage);
        System.out.println(this.name + " receives " + damage + " damage. Remaining HP: " + this.stats.get(Stats.HP));
    }

    /**
     * Función para corroborar que el jugador está muerto
     */
    public boolean isDead() {
        return this.stats.get(Stats.HP) <= 0;
    }

    /**
     * Función para corroborar que el jugador está vivo
     */
    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;
    }
}