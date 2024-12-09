package rpg.items.miscs;

import rpg.enums.ItemType;

import java.io.Serializable;

/**
 * La clase WolfPelt representa un objeto del tipo "Piel de lobo" en el juego.
 * Este objeto es apilable y no consumible, y se utiliza principalmente como un objeto de venta.
 */
public class WolfPelt extends Misc implements Serializable {

    /**
     * Inicializa las propiedades del objeto WolfPelt.
     * Establece el tipo de objeto, el nombre, la descripción, el precio,
     * la capacidad de apilar y si es consumible.
     */
    @Override
    protected void initItem() {
        this.type = ItemType.MISC;
        this.name = "Piel de lobo";
        this.description = "Una piel de lobo. Se puede vender por un buen precio.";
        this.price = 50;
        this.consumable = false;
        this.stackable = true;
        this.quantity = 1;
    }

    /**
     * Metodo utilizado cuando se intenta usar la piel de lobo.
     * En este caso, la piel de lobo no puede ser usada, por lo que se imprime un mensaje en consola.
     */
    @Override
    public void use() {
        System.out.println("No puedes usar una piel de lobo.");
    }
}