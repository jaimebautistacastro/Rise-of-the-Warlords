package rpg.items.miscs;

import rpg.enums.ItemType;
import rpg.items.Item;

// Clase para objetos de tipo Pergamino
public class Scroll extends Item {

    private String spell;
    private int manaCost;

    public Scroll(String name, String description, int price, String spell, int manaCost, ItemType itemType) {
        super(name, description, price, itemType);
        this.spell = spell;
        this.manaCost = manaCost;
    }

    public String getSpell() {
        return spell;
    }

    public int getManaCost() {
        return manaCost;
    }

    @Override
    public String toString() {
        return super.toString() + " - Spell: " + spell + ", Mana Cost: " + manaCost;
    }
}
