package rpg.items;

import rpg.entities.Player;
import rpg.enums.Stats;
import rpg.interfaces.Equipable;

import java.util.HashMap;

/**
 * The type Equipment.
 */
public abstract class Equipment extends Item implements Equipable {

    /**
     * The Stats.
     */
    protected HashMap<Stats, Integer> stats;

    @Override
    public void equip(Player player) {

    }

    @Override
    public void unequip(Player player) {

    }
}
