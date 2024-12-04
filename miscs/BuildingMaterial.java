package rpg.items.miscs;

import rpg.enums.ItemType;
import rpg.items.Item;

// Clase para objetos de tipo Material de Construcción
public class BuildingMaterial extends Item {

    private String materialType;
    private int quantity;

    public BuildingMaterial(String name, String description, int price, String materialType, int quantity, ItemType itemType) {
        super(name, description, price, itemType);
        this.materialType = materialType;
        this.quantity = quantity;
    }

    public String getMaterialType() {
        return materialType;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return super.toString() + " - Material Type: " + materialType + ", Quantity: " + quantity;
    }
}
