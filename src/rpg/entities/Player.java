package rpg.entities;

import rpg.entities.enemy.Enemy;
import rpg.enums.Stats;
import java.util.HashMap;

public class Player {
    private String name;
    private int defenseBonus = 0; // Campo para almacenar el bono de defensa
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

    public int getLife() {
        return this.stats.get(Stats.HP);
    }

    // Usar una poción para aumentar la vida
    public void usePotion(int extraLife) {
        int currentHP = this.stats.get(Stats.HP); // Obtener el valor actual de HP
        this.stats.put(Stats.HP, currentHP + extraLife); // Actualizar el valor de HP en el mapa
        System.out.println(this.name + " usa una poción. Vida adicional: " + extraLife);
    }

    // Equipar un arma que aumenta el ataque
    public void equipWeapon(int extraAttack) {
        int currentAttack = this.stats.get(Stats.ATTACK);
        this.stats.put(Stats.ATTACK, currentAttack + extraAttack);
        System.out.println(this.name + " equipa un arma. Ataque aumentado en: " + extraAttack);
    }

    // Equipar una armadura que otorga defensa adicional
    public void equipArmor(int defense) {
        this.defenseBonus = defense;  // Asigna el bono de defensa de la armadura
        System.out.println(this.name + " equipa una armadura. Defensa adicional: " + defense);
    }

    // Atacar a un enemigo y aplicar daño extra si tiene un arma equipada
    public int attack(Enemy enemy, int weaponDamageBonus) {
        int attackPower = this.stats.get(Stats.ATTACK) + weaponDamageBonus;
        enemy.receiveDamage(attackPower);
        System.out.println(this.name + " ataca al enemigo con " + attackPower + " de daño.");
        return attackPower;
    }

    // Recibir daño, aplicando el bono de defensa
    public void receiveDamage(int damage) {
        int reducedDamage = Math.max(damage - defenseBonus, 0);  // Reducir daño basado en defensa
        int currentHP = this.stats.get(Stats.HP);
        this.stats.put(Stats.HP, Math.max(currentHP - reducedDamage, 0)); // Evitar que HP baje de 0
        System.out.println(this.name + " recibe " + reducedDamage + " de daño tras aplicar la defensa. Vida restante: " + this.stats.get(Stats.HP));
    }

    // Comprobar si el jugador está muerto
    public boolean isDead() {
        return this.stats.get(Stats.HP) <= 0;
    }

    // Comprobar si el jugador está vivo
    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;
    }
}
