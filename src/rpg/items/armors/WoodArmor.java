package rpg.items.armors;

import rpg.enums.ItemType;
import rpg.items.armors.Armor;

public class WoodArmor extends Armor {

    private String typeArmor;
    private int defense;
    private int durability;

    public WoodArmor(String name, String description, int price, int defense, int durability, String typeArmor) {
        super(name, description, price, ItemType.ARMOR);
        this.typeArmor = typeArmor;
        this.defense = defense;
        this.durability = durability;
    }

    public String getTypeArmor() {
        return typeArmor;
    }

    @Override
    public String toString() {
        return super.toString() + " - Type: " + typeArmor;
    }
}
