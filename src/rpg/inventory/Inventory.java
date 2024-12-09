package rpg.inventory;

import rpg.exceptions.InventoryFullException;
import rpg.exceptions.ItemNotFoundException;
import rpg.items.Item;
import rpg.items.armors.Armor;
import rpg.items.miscs.Misc;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * La clase Inventory representa un inventario de objetos en el juego.
 * Un inventario puede contener diferentes tipos de objetos (armaduras, misceláneos, etc.)
 * y proporciona métodos para agregar, eliminar y gestionar dichos objetos.
 */
public class Inventory implements Serializable {

    /**
     * La lista de objetos almacenados en el inventario.
     */
    private final ArrayList<Item> items;

    /**
     * La capacidad máxima del inventario.
     */
    private int capacity;

    /**
     * Crea un nuevo inventario con una capacidad inicial de 15 objetos.
     */
    public Inventory() {
        this.capacity = 15;
        items = new ArrayList<>();
    }

    /**
     * Agrega un objeto al inventario.
     * Si el inventario está lleno, lanza una excepción InventoryFullException.
     *
     * @param item El objeto a agregar al inventario.
     */
    public void addItem(Item item) {

        try {
            if (!isFull()) {
                items.add(item);
            } else {
                throw new InventoryFullException();
            }
        } catch (InventoryFullException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Elimina un objeto del inventario.
     * Si el objeto no se encuentra, se imprime un mensaje de error.
     *
     * @param item El objeto a eliminar del inventario.
     */
    public void removeItem(Item item) {
        try {
            items.remove(item);
        } catch (Exception e) {
            System.out.println("Item no encontrado");
        }
    }

    /**
     * Obtiene un objeto del inventario por su índice.
     *
     * @param index El índice del objeto en el inventario.
     * @return El objeto en la posición indicada.
     */
    public Item getItem(int index) {
        return items.get(index);
    }

    /**
     * Obtiene un objeto del inventario por su nombre.
     * Si el objeto no se encuentra, lanza una excepción ItemNotFoundException.
     *
     * @param item El objeto que se busca por su nombre.
     * @return El objeto encontrado en el inventario.
     * @throws ItemNotFoundException Si el objeto no se encuentra.
     */
    public Item getItem(Item item) throws ItemNotFoundException {

        Item found = null;
        for (Item i : items) {
            if (i.getName().equals(item.getName())) {
                found = i;
                break;
            }
        }
        if (found == null) {
            throw new ItemNotFoundException();
        }
        return found;
    }

    /**
     * Obtiene la cantidad total de objetos en el inventario.
     *
     * @return El número de objetos en el inventario.
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Verifica si el inventario está lleno.
     *
     * @return true si el inventario está lleno, false si hay espacio disponible.
     */
    public boolean isFull() {
        return items.size() == capacity;
    }

    /**
     * Verifica si el inventario está vacío.
     *
     * @return true si el inventario está vacío, false si contiene objetos.
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Limpia el inventario, eliminando todos los objetos.
     */
    public void clear() {
        items.clear();
    }

    /**
     * Aumenta la capacidad del inventario en una cantidad especificada.
     *
     * @param amount La cantidad en la que se incrementa la capacidad del inventario.
     */
    public void increaseCapacity(int amount) {
        capacity += amount;
        items.ensureCapacity(capacity);
    }

    /**
     * Obtiene una lista de las armaduras en el inventario.
     *
     * @return Una lista de objetos Armor que están en el inventario.
     */
    public ArrayList<Armor> getArmors() {
        ArrayList<Armor> armors = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Armor) {
                armors.add((Armor) item);
            }
        }
        return armors;
    }

    /**
     * Obtiene una lista de los objetos misceláneos en el inventario.
     *
     * @return Una lista de objetos Misc que están en el inventario.
     */
    public ArrayList<Misc> getMiscs() {
        ArrayList<Misc> miscs = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Misc) {
                miscs.add((Misc) item);
            }
        }
        return miscs;
    }

    /**
     * Obtiene todos los objetos del inventario.
     *
     * @return Una lista de todos los objetos almacenados en el inventario.
     */
    public ArrayList<Item> getItems() {
        return items;
    }
}