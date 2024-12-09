package rpg.entities.enemies;

import rpg.entities.GameCharacter;
import rpg.enums.EnemyType;
import rpg.enums.Stats;

import javax.swing.*;

/**
 * Representa a un enemigo en el juego.
 * Es una clase abstracta que define las caracteristicas generales
 * y los comportamientos basicos de cualquier enemigo.
 */
public abstract class Enemy extends GameCharacter {

    /**
     * Tipo de enemigo, definido por un enumerado.
     */
    protected EnemyType type;

    /**
     * Construye un nuevo enemigo con un nombre especifico.
     *
     * @param name el nombre del enemigo
     */
    public Enemy(String name) {
        super(name);
    }

    /**
     * Define el comportamiento para obtener el botin dejado por el enemigo.
     * Este metodo debe ser implementado por las subclases.
     */
    public abstract void getLoot();

    /**
     * Realiza un ataque a un personaje del juego.
     *
     * @param enemy el personaje objetivo
     * @return un mensaje que describe el ataque
     */
    public abstract String attack(GameCharacter enemy);

    /**
     * Devuelve el tipo de enemigo.
     *
     * @return el tipo de enemigo como un valor de EnemyType
     */
    public EnemyType getType() {
        return type;
    }

    /**
     * Establece un nuevo nombre para el enemigo.
     *
     * @param name el nuevo nombre del enemigo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve el sprite asociado al enemigo.
     * Este metodo debe ser implementado por las subclases.
     *
     * @return un objeto ImageIcon que representa al enemigo
     */
    public abstract ImageIcon getSprite();
}