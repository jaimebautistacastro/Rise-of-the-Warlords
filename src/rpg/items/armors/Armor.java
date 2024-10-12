package rpg.items.armors;

import rpg.enums.ItemType;
import rpg.items.Equipment;

public abstract class Armor extends Equipment {
    protected ItemType armorType;

    public Armor(String name, String description, int price, ItemType armorType) {
        super(name, description, price, ItemType.ARMOR);
        this.armorType = armorType;
    }

    public ItemType getArmorType() {
        return armorType;
    }
}