package rpg.items.miscs;

import rpg.items.Item;

import java.io.Serializable;

/**
 * La clase Misc representa un tipo genérico de objeto en el juego que puede ser consumible y/o apilable.
 * Extiende la clase Item e incluye propiedades y métodos para manejar la cantidad de objetos,
 * y las acciones relacionadas con objetos consumibles y apilables.
 */
public abstract class Misc extends Item implements Serializable {

    /**
     * Indica si el objeto es consumible.
     */
    protected boolean consumable;

    /**
     * Indica si el objeto es apilable.
     */
    protected boolean stackable;

    /**
     * La cantidad actual de objetos.
     */
    protected int quantity;

    /**
     * La cantidad máxima que se puede tener de este objeto.
     */
    protected int maxQuantity;

    /**
     * Constructor de la clase Misc. Inicializa la cantidad máxima en 99.
     */
    public Misc() {
        super();
        maxQuantity = 99;
    }

    /**
     * Metodo abstracto para usar el objeto. Debe ser implementado en las clases hijas.
     */
    public abstract void use();

    /**
     * Devuelve si el objeto es consumible.
     *
     * @return true si el objeto es consumible, false en caso contrario.
     */
    public boolean isConsumable() {
        return consumable;
    }

    /**
     * Devuelve si el objeto es apilable.
     *
     * @return true si el objeto es apilable, false en caso contrario.
     */
    public boolean isStackable() {
        return stackable;
    }

    /**
     * Obtiene la cantidad actual del objeto.
     *
     * @return La cantidad del objeto.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Aumenta la cantidad del objeto en la cantidad especificada.
     * Si la cantidad supera la cantidad máxima, se establece en el valor máximo.
     *
     * @param amount La cantidad a aumentar.
     */
    public void increaseQuantity(int amount) {
        quantity += amount;
        if (quantity > maxQuantity) {
            quantity = maxQuantity;
        }
    }

    /**
     * Disminuye la cantidad del objeto en la cantidad especificada.
     * Si la cantidad es menor a 0, se establece en 0.
     *
     * @param amount La cantidad a disminuir.
     */
    public void decreaseQuantity(int amount) {
        quantity -= amount;
        if (quantity < 0) {
            quantity = 0;
        }
    }
}