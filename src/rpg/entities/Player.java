package rpg.entities;

import rpg.enums.Stats;
import rpg.exceptions.ItemNotFoundException;
import rpg.inventory.Inventory;
import rpg.items.Item;
import rpg.items.miscs.Misc;
import rpg.utils.Randomize;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;

/**
 * Clase que representa al jugador del juego.
 */
public class Player extends GameCharacter implements Serializable {

    /**
     * Inventario del jugador.
     */
    private final Inventory inventory;

    /**
     * Constructor que crea un nuevo jugador con un nombre especifico.
     *
     * @param name el nombre del jugador
     */
    public Player(String name) {
        super(name);
        inventory = new Inventory();
    }

    /**
     * Guarda el estado del juego en un archivo.
     *
     * @param slot el numero de ranura para guardar
     */
    public void save(int slot) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("files/save" + slot + ".dat"));
            out.writeObject(this);
            out.close();
            System.out.println("Juego guardado");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el juego");
        }
    }

    /**
     * Carga el estado del juego desde un archivo.
     *
     * @param slot el numero de ranura de guardado
     * @return el jugador cargado o null si ocurre un error
     */
    public static Player load(int slot) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("files/save" + slot + ".dat"));
            Player player = (Player) in.readObject();
            in.close();
            return player;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el juego");
        }
        return null;
    }

    /**
     * Intenta huir de un combate.
     *
     * @return true si el jugador logra huir, false en caso contrario
     */
    public boolean tryToFlee() {
        return Randomize.getRandomBoolean();
    }

    /**
     * Incrementa el nivel del jugador y mejora sus estadisticas.
     */
    public void levelUp() {
        stats.put(Stats.LEVEL, stats.get(Stats.LEVEL) + 1);
        stats.put(Stats.MAX_HP, stats.get(Stats.MAX_HP) + Randomize.getRandomInt(5, 10));
        stats.put(Stats.HP, stats.get(Stats.MAX_HP));
        stats.put(Stats.MAX_MP, stats.get(Stats.MAX_MP) + Randomize.getRandomInt(2, 5));
        stats.put(Stats.MP, stats.get(Stats.MAX_MP));
        stats.put(Stats.ATTACK, stats.get(Stats.ATTACK) + Randomize.getRandomInt(1, 3));
        stats.put(Stats.DEFENSE, stats.get(Stats.DEFENSE) + Randomize.getRandomInt(1, 3));
        stats.put(Stats.NEEDED_EXPERIENCE, stats.get(Stats.NEEDED_EXPERIENCE) + 50);
        stats.put(Stats.EXPERIENCE, 0);
    }

    /**
     * Inicializa las caracteristicas del jugador.
     */
    @Override
    protected void initCharacter() {
        stats.put(Stats.LEVEL, 1);
        stats.put(Stats.MAX_HP, 100);
        stats.put(Stats.HP, 100);
        stats.put(Stats.MAX_MP, 50);
        stats.put(Stats.MP, 50);
        stats.put(Stats.ATTACK, 10);
        stats.put(Stats.DEFENSE, 5);
        stats.put(Stats.EXPERIENCE, 0);
        stats.put(Stats.NEEDED_EXPERIENCE, 100);
        stats.put(Stats.GOLD, 0);
    }

    /**
     * Agrega un item al inventario del jugador.
     *
     * @param item el item a agregar
     */
    public void addItemToInventory(Item item) {
        if (item instanceof Misc misc) {
            if (misc.isStackable()) {
                boolean found = false;
                for (Item i : inventory.getMiscs()) {
                    if (i.getName().equals(misc.getName())) {
                        misc.increaseQuantity(1);
                        inventory.removeItem(i);
                        inventory.addItem(misc);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    inventory.addItem(item);
                }
            } else {
                inventory.addItem(item);
            }
        } else {
            inventory.addItem(item);
        }
    }

    /**
     * Elimina un item del inventario del jugador.
     *
     * @param item el item a eliminar
     */
    public void removeItemFromInventory(Item item) {
        if (item instanceof Misc misc) {
            if (misc.isStackable()) {
                for (Item i : inventory.getMiscs()) {
                    if (i.getName().equals(item.getName())) {
                        misc.decreaseQuantity(1);
                        if (misc.getQuantity() == 0) {
                            inventory.removeItem(i);
                        }
                        break;
                    }
                }
            } else {
                inventory.removeItem(item);
            }
        } else {
            inventory.removeItem(item);
        }
    }

    /**
     * Vende un item del inventario.
     *
     * @param item el item a vender
     */
    public void sellItem(Item item) {
        try {
            Item getItem = inventory.getItem(item);
            if (getItem instanceof Misc misc) {
                if (misc.isStackable()) {
                    if (misc.getQuantity() > 1) {
                        misc.decreaseQuantity(1);
                    } else {
                        inventory.removeItem(item);
                    }
                }
            } else {
                inventory.removeItem(getItem);
            }
        } catch (ItemNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Muestra el contenido del inventario.
     */
    public void showInventory() {
        StringBuilder content = new StringBuilder("Inventario: \n");
        String format = """
                Nombre: %s, Precio: %d
                Descripcion: %s
                """;
        String formatQuantity = """
                Nombre: %s, Precio: %d, Cantidad: %d
                Descripcion: %s
                """;
        for (Item item : inventory.getItems()) {
            if (item instanceof Misc misc) {
                if (misc.isStackable()) {
                    content.append(String.format(formatQuantity, item.getName(),
                            item.getPrice(), misc.getQuantity(), item.getDescription()));
                } else {
                    content.append(String.format(format, item.getName(), item.getPrice(),
                            item.getDescription()));
                }
            } else {
                content.append(String.format(format, item.getName(), item.getPrice(),
                        item.getDescription()));
            }
        }
        JOptionPane.showMessageDialog(null, content.toString());
    }

    /**
     * Devuelve el inventario del jugador.
     *
     * @return el inventario
     */
    public Inventory getInventory() {
        return inventory;
    }
}