package rpg.entities;

import rpg.enums.Stats;
import java.util.HashMap;

public class GameCharacter {

    protected String name;
    protected HashMap<Stats, Integer> stats;
    /**
     * Anexar atributo para el tipo de personaje o enemigo
     */
    protected String enemyType;

    /**
     * Agregar constructor
     * @param name
     */
    public GameCharacter(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        /**
         * Tipo por defecto si no se especifica
         */
        this.enemyType = "Unknown";
        initializeStats();
    }

    /**
     * Agregar constructor adicional el cual incluye el tipo de enemigo/personaje
     * @param name
     * @param enemyType
     */
    public GameCharacter(String name, String enemyType) {
        this.name = name;
        this.enemyType = enemyType;
        this.stats = new HashMap<>();
        initializeStats();
    }

    /**
     * Anexar la inicialización de los valores por defecto
     */
    private void initializeStats() {
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
    }

    /**
     * Verificar si el personaje esta vivo
     * @return
     */
    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    /**
     * Verificar si el personaje está muerto
     * @return
     */
    public boolean isDead() {
        return stats.get(Stats.HP) <= 0;
    }

    /**
     * Agregar función para recibir daño
     * @param damage
     */
    public void receiveDamage(int damage) {
        int currentHP = this.stats.get(Stats.HP);
        /**
         * El HP no puede ser negativo
         */
        int newHP = Math.max(currentHP - damage, 0);
        this.stats.put(Stats.HP, newHP);
        System.out.println(this.name + " receives " + damage + " damage! Remaining HP: " + newHP);
    }

    /**
     * Método de ataque a otro GameCharacter
     * @param enemy
     */
    public void attack(GameCharacter enemy) {
        String enemyName = enemy.getName();
        int attackPower = this.stats.get(Stats.ATTACK);
        int defensePower = enemy.getStats().get(Stats.DEFENSE);

        /**
         * Realizar cálculo del daño generado, el daño no puede ser negativo
         */
        int damage = Math.max(attackPower - defensePower, 0);
        if (damage > 0) {
            enemy.receiveDamage(damage);
            System.out.printf("%s attacks %s for %d damage! %s has %d HP left.%n", this.name, enemyName, damage, enemyName, enemy.getStats().get(Stats.HP));
        } else {
            System.out.printf("%s attacks %s but does no damage! %s has %d HP left.%n", this.name, enemyName, enemyName, enemy.getStats().get(Stats.HP));
        }
    }

    /**
     * Obtener el nombre del personaje
     * @return
     */
    public String getName() {
        return String.format("%s el Intrépido", name);
    }

    /**
     * Obtener el tipo de enemigo/peronaje
     * @return
     */
    public String getEnemyType() {
        return this.enemyType;
    }

    /**
     * Establecer el tipo de enemigo/personaje
     * @param enemyType
     */
    public void setEnemyType(String enemyType) {
        this.enemyType = enemyType;
    }

    /**
     * Obteber los Stats del personaje
     * @return
     */
    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}