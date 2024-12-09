package rpg.items;

import rpg.enums.ItemType;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;
import java.io.Serializable;

/**
 * La clase Item representa un objeto genérico que puede ser parte del inventario del jugador.
 * Los objetos de esta clase incluyen armas, armaduras, misceláneos y otros elementos que el jugador
 * puede usar o vender dentro del juego. La clase es abstracta, por lo que debe ser extendida por
 * clases concretas que definan tipos específicos de objetos.
 */
public abstract class Item implements Serializable {

    /**
     * El nombre del objeto.
     */
    protected String name;

    /**
     * El nombre del icono asociado al objeto.
     */
    protected String iconName;

    /**
     * La descripción del objeto.
     */
    protected String description;

    /**
     * El precio del objeto.
     */
    protected int price;

    /**
     * El tipo del objeto, determinado por un valor de tipo ItemType (por ejemplo, arma, armadura, etc.).
     */
    protected ItemType type;

    /**
     * Constructor de la clase Item. Inicializa los atributos de la clase mediante la
     * función initItem(). Este constructor es llamado automáticamente al crear una instancia
     * de una clase que herede de Item.
     */
    public Item() {
        initItem();
    }

    /**
     * Función abstracta que inicializa los atributos de la clase. Debe ser implementada
     * y sobreescrita por las clases hijas para definir cómo se inicializan los atributos específicos
     * del objeto.
     */
    protected abstract void initItem();

    /**
     * Obtiene el nombre del objeto.
     *
     * @return El nombre del objeto.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la descripción del objeto.
     *
     * @return La descripción del objeto.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Obtiene el precio del objeto.
     *
     * @return El precio del objeto.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Obtiene el tipo del objeto.
     *
     * @return El tipo del objeto (por ejemplo, arma, armadura, etc.).
     */
    public ItemType getType() {
        return type;
    }

    /**
     * Obtiene el icono asociado al objeto, escalado a un tamaño de 32x32 píxeles.
     *
     * @return El icono del objeto como una instancia de ImageIcon.
     */
    public ImageIcon getIcon() {
        return new ImageIcon(ImageCache
                .getImage(iconName)
                .getScaledInstance(32, 32, 0));
    }
}