package rpg.items.weapons;

import rpg.enums.ItemType;
import rpg.enums.WeaponType;
import rpg.items.Equipment;

import java.util.HashMap;

public class Weapon extends Equipment {
    protected WeaponType weaponType;

    public Weapon(String name, String description, int price, WeaponType weaponType) {
        super(name, description, price, ItemType.WEAPON);
        this.weaponType = weaponType;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }
    public class IronSword extends Weapon {
        public IronSword() {
            super("Iron Sword", "A sharp iron sword", 30, WeaponType.SWORD);
        }
    }

    public class Longbow extends Weapon {
        public Longbow() {
            super("Longbow", "A bow with long range", 25, WeaponType.AXE);
        }
    }

    public class Dagger extends Weapon {
        public Dagger() {
            super("Dagger", "A small but fast weapon", 10, WeaponType.BOW);
        }
    }

    public class BattleAxe extends Weapon {
        public BattleAxe() {
            super("Battle Axe", "A heavy axe with high damage", 40, WeaponType.STAFF);
        }
    }

    public class MagicStaff extends Weapon {
        public MagicStaff() {
            super("Magic Staff", "A staff imbued with magical power", 35, WeaponType.CROSSBOW);
        }
    }
}