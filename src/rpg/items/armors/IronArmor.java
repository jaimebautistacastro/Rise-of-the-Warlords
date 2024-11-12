package rpg.items.armors;

import rpg.enums.ItemType;

public class IronArmor extends Armor {

    private String typeArmor;
    private int defense;
    private int durability;

    public IronArmor(String name, String description, int price, int defense, int durability, String typeArmor) {
        this.name=name;
        this.description=description;
        this.price=price;
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

    @Override
    protected void initItem() {

    }
}
