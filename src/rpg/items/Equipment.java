package rpg.items;

import rpg.entities.Player;
import rpg.enums.Stats;
import rpg.enums.WearType;
import rpg.interfaces.Equipable;

import java.io.Serializable;
import java.util.HashMap;

/**
 * La clase Equipment representa un objeto de equipo en el juego, como armas o armaduras.
 * Hereda de la clase Item y la interfaz Equipable, lo que le permite ser equipado o
 * desequipado por un jugador.
 *
 * Los objetos de esta clase tienen un conjunto de estadísticas (stats) que afectan al jugador
 * cuando son equipados. Además, se especifica el tipo de uso o "wear type" de la pieza de equipo.
 */
public abstract class Equipment extends Item implements Equipable, Serializable {

    /**
     * El conjunto de estadísticas que este equipo aporta al jugador.
     */
    protected HashMap<Stats, Integer> stats;

    /**
     * El tipo de uso de la pieza de equipo (por ejemplo, si es un casco, armadura, etc.).
     */
    protected WearType wearType;

    /**
     * Metodo que permite equipar este objeto a un jugador.
     * Este metodo debe ser implementado en clases concretas.
     *
     * @param player El jugador que va a equipar el objeto.
     */
    @Override
    public void equip(Player player) {
        // Lógica para equipar el equipo al jugador (debe ser implementada en clases concretas)
    }

    /**
     * Metodo que permite desequipar este objeto de un jugador.
     * Este metodo debe ser implementado en clases concretas.
     *
     * @param player El jugador que va a desequipar el objeto.
     */
    @Override
    public void unequip(Player player) {
        // Lógica para desequipar el equipo del jugador (debe ser implementada en clases concretas)
    }

    /**
     * Obtiene las estadísticas que este equipo aporta al jugador.
     *
     * @return Un HashMap que contiene las estadísticas del equipo, con la clave como el tipo
     *         de estadística (Stats) y el valor como el número asociado a esa estadística.
     */
    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}