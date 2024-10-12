package rpg.items.miscs;

import rpg.enums.ItemType;
import rpg.items.Item;

// Clase para objetos de tipo Poción
public class Misc extends Item {

    private String effect;
    private int potency;
    private int duration;

    public Misc(String name, String description, int price, String effect, int potency, int duration, ItemType itemType) {
        super(name, description, price, itemType);
        this.effect = effect;
        this.potency = potency;
        this.duration = duration;
    }

    public String getEffect() {
        return effect;
    }

    public int getPotency() {
        return potency;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return super.toString() + " - Effect: " + effect + ", Potency: " + potency + ", Duration: " + duration + "s";
    }
}

