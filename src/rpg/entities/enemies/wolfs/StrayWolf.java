package rpg.entities.enemies.wolfs;

import rpg.entities.GameCharacter;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.utils.Randomize;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;

/**
 * Representa al Lobo Solitario, un enemigo basico del juego.
 */
public class StrayWolf extends Enemy {

    /**
     * Crea una nueva instancia de Lobo Solitario.
     */
    public StrayWolf() {
        super("Stray Wolf");
        ImageCache.addImage("stray_wolf", "enemies/wolfs/aloneWolf.png");
    }

    /**
     * Obtiene el botin dejado por el Lobo Solitario.
     */
    @Override
    public void getLoot() {
        System.out.println("El Lobo Solitario deja una valiosa piel de lobo.");
    }

    /**
     * Inicializa las estadisticas del personaje.
     */
    @Override
    protected void initCharacter() {
        this.type = EnemyType.BASIC;
        this.stats.put(Stats.MAX_HP, 30);
        this.stats.put(Stats.HP, 30);
        this.stats.put(Stats.ATTACK, 6);
        this.stats.put(Stats.DEFENSE, 2);
        this.stats.put(Stats.EXPERIENCE, 20);
        this.stats.put(Stats.GOLD, 10);
    }

    /**
     * Realiza el ataque "Morder".
     *
     * @param enemy el enemigo objetivo
     * @return mensaje que describe el ataque
     */
    protected String bite(GameCharacter enemy) {
        int damage = 4;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        return String.format("""
                        ¡%s muerde a %s por %d de dano!
                        %s tiene %d HP restantes.
                        """, this.name, enemy.getName(), damage,
                enemy.getName(), enemy.getStats().get(Stats.HP));
    }

    /**
     * Realiza el ataque "Arañar".
     *
     * @param enemy el enemigo objetivo
     * @return mensaje que describe el ataque
     */
    protected String claw(GameCharacter enemy) {
        int damage = 3;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        return String.format("""
                        ¡%s clava sus garras en %s por %d de dano!
                        %s tiene %d HP restantes.
                        """, this.name, enemy.getName(), damage,
                enemy.getName(), enemy.getStats().get(Stats.HP));
    }

    /**
     * Realiza el ataque "Zarpazo".
     *
     * @param enemy el enemigo objetivo
     * @return mensaje que describe el ataque
     */
    protected String slash(GameCharacter enemy) {
        int damage = 5;
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        return String.format("""
                        ¡%s lanzo un zarpazo a %s por %d de dano!
                        %s tiene %d HP restantes.
                        """, this.name, enemy.getName(), damage,
                enemy.getName(), enemy.getStats().get(Stats.HP));
    }

    /**
     * Realiza un ataque aleatorio al enemigo.
     *
     * @param enemy el enemigo objetivo
     * @return mensaje que describe el ataque realizado
     */
    @Override
    public String attack(GameCharacter enemy) {
        String message = "";
        int attack = Randomize.getRandomInt(1, 3);
        message = switch (attack) {
            case 1 -> bite(enemy);
            case 2 -> claw(enemy);
            default -> slash(enemy);
        };
        return message;
    }

    /**
     * Devuelve el sprite asociado al Lobo Solitario.
     *
     * @return ImageIcon que representa al Lobo Solitario
     */
    @Override
    public ImageIcon getSprite() {
        return ImageCache.getImageIcon("stray_wolf");
    }
}