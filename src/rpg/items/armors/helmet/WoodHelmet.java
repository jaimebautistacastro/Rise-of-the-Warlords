package rpg.items.armors.helmet;

import rpg.enums.ItemType;
import rpg.enums.Stats;
import rpg.items.armors.Armor;

import java.util.HashMap;

/**
 * The type Wood helmet.
 */
public class WoodHelmet extends Armor {

    @Override
    protected void initItem() {
        type = ItemType.ARMOR;
        name = "Casco de madera";
        description = "Un casco de madera. No es muy resistente, pero es mejor que nada.";
        price = 10;
        stats=new HashMap<>();
        stats.put(Stats.DEFENSE, 2);
    }

    /**
     * Protect.
     */
    public void protect(){
        System.out.println("El casco de madera te protege de un golpe y se rompe.");
    }
}
