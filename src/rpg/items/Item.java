package rpg.items;

import rpg.enums.ItemType;

public abstract class Item {
    protected String name;
    protected String description;
    protected int price;
    protected ItemType itemType;

    public Item(String name, String description, int price, ItemType itemType) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public ItemType getItemType() {
        return itemType;
    }
}