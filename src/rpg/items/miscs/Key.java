package rpg.items.miscs;

import rpg.enums.ItemType;
import rpg.items.Item;

// Clase para objetos de tipo Llave
public class Key extends Item {

    private String doorId;

    public Key(String name, String description, int price, String doorId, ItemType itemType) {
        super(name, description, price, itemType);
        this.doorId = doorId;
    }

    public String getDoorId() {
        return doorId;
    }

    @Override
    public String toString() {
        return super.toString() + " - Unlocks Door ID: " + doorId;
    }
}
