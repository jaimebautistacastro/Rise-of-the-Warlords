package rpg.items.armors;

import rpg.enums.ItemType;

/**
 * La clase GoldenArmor representa una armadura de tipo dorada en el juego.
 * Extiende la clase Armor y define propiedades específicas para este tipo de armadura,
 * como el tipo de armadura, la defensa y la durabilidad.
 */
public class GoldenArmor extends Armor {

    private String typeArmor;
    private int defense;
    private int durability;

    /**
     * Constructor para crear una nueva instancia de GoldenArmor.
     *
     * @param name        El nombre de la armadura.
     * @param description La descripción de la armadura.
     * @param price       El precio de la armadura.
     * @param defense     El valor de defensa que otorga la armadura.
     * @param durability  La durabilidad de la armadura.
     * @param typeArmor   El tipo específico de la armadura (por ejemplo, "Dorada").
     */
    public GoldenArmor(String name, String description, int price, int defense, int durability, String typeArmor) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.typeArmor = typeArmor;
        this.defense = defense;
        this.durability = durability;
    }

    /**
     * Obtiene el tipo de la armadura.
     *
     * @return El tipo de la armadura.
     */
    public String getTypeArmor() {
        return typeArmor;
    }

    /**
     * Representa la armadura como una cadena de texto.
     *
     * @return Una cadena con el nombre de la armadura y su tipo.
     */
    @Override
    public String toString() {
        return super.toString() + " - Type: " + typeArmor;
    }

    /**
     * Inicializa el objeto GoldenArmor. En este caso, no tiene implementación
     * específica en esta clase, pero puede ser sobrescrita por clases hijas si es necesario.
     */
    @Override
    protected void initItem() {

    }
}