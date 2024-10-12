package rpg.items;

import rpg.enums.ItemType;

public abstract class Equipment extends Item {
    public Equipment(String name, String description, int price, ItemType itemType) {
        super(name, description, price, itemType);
    }
}
