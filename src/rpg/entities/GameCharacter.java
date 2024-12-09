package rpg.entities;

import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Clase que representa a un personaje del juego.
 * Define atributos y comportamientos comunes para todos los personajes.
 */
public abstract class GameCharacter implements Serializable {

    /**
     * Nombre del personaje.
     */
    protected String name;

    /**
     * Caracteristicas del personaje, almacenadas en un mapa.
     */
    protected HashMap<Stats, Integer> stats;

    /**
     * Construye un nuevo personaje del juego con un nombre especifico.
     *
     * @param name el nombre del personaje
     */
    public GameCharacter(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        initCharacter();
    }

    /**
     * Metodo abstracto que inicializa las caracteristicas del personaje.
     * Debe ser implementado por las clases hijas.
     * Se utiliza para establecer el nombre y las estadisticas basicas.
     */
    protected abstract void initCharacter();

    /**
     * Verifica si el personaje esta vivo.
     *
     * @return true si el personaje tiene mas de 0 HP, false en caso contrario
     */
    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    /**
     * Simula un ataque del personaje hacia un enemigo.
     * Si el ataque causa daño, se reduce la vida del enemigo.
     * En caso de que el enemigo muera, lanza una excepcion y actualiza sus stats.
     *
     * @param enemy el enemigo al que se ataca
     * @return un mensaje que describe el resultado del ataque
     */
    public String attack(GameCharacter enemy) {
        String message = "";
        String enemyName = enemy.getName();
        int damage = this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE);
        int newHP = enemy.getStats().get(Stats.HP);

        if (damage > 0) {
            try {
                newHP = reduceHP(enemy, damage);
                message += String.format("""
                        ¡%s ataca a %s por %d de dano!
                        %s tiene %d HP restantes.
                        """, this.name, enemyName, damage, enemyName, newHP);
            } catch (EnemyDeathException e) {
                enemy.getStats().put(Stats.HP, 0);
                message += String.format("""
                        ¡%s ataca a %s por %d de dano!
                        %s tiene 0 HP restantes.
                        %s ha muerto.
                        """, this.name, enemyName, damage, enemyName, enemyName);
            }
        } else {
            message += String.format("""
                    ¡%s ataca a %s pero no hace dano!
                    %s tiene %d HP restantes.
                    """, this.name, enemyName, enemyName, newHP);
        }
        return message;
    }

    /**
     * Reduce la vida del enemigo y actualiza sus estadisticas.
     * Si el enemigo muere, lanza una excepcion.
     *
     * @param enemy  el enemigo al que se realiza el ataque
     * @param damage el dano infligido
     * @return la nueva cantidad de HP del enemigo
     * @throws EnemyDeathException si el enemigo muere
     */
    protected final int reduceHP(GameCharacter enemy, int damage) throws EnemyDeathException {
        int newHP = enemy.getStats().get(Stats.HP) - damage;
        enemy.getStats().put(Stats.HP, newHP);
        if (!enemy.isAlive()) {
            throw new EnemyDeathException();
        }
        return newHP;
    }

    /**
     * Devuelve el nombre del personaje.
     *
     * @return el nombre del personaje
     */
    public final String getName() {
        return String.format("%s", name);
    }

    /**
     * Devuelve las estadisticas del personaje.
     *
     * @return un mapa con las estadisticas del personaje
     */
    public final HashMap<Stats, Integer> getStats() {
        return stats;
    }
}