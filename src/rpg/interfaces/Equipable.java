package rpg.interfaces;

import rpg.entities.Player;

/**
 * La interfaz Equipable define el contrato para los objetos que pueden ser equipados por un jugador.
 * Proporciona métodos para equipar y desequipar objetos, los cuales pueden ser implementados por
 * clases como armas, armaduras u otros elementos equipables.
 */
public interface Equipable {

    /**
     * Equipa un objeto al jugador. Este metodo se llama cuando el jugador equipa el objeto.
     * Las clases que implementen esta interfaz deben definir la lógica para modificar las estadísticas
     * del jugador o su inventario cuando el objeto es equipado.
     *
     * @param player el jugador que está equipando el objeto
     */
    public void equip(Player player);

    /**
     * Desequipa un objeto del jugador. Este metodo se llama cuando el jugador desequipa el objeto.
     * Las clases que implementen esta interfaz deben definir la lógica para revertir los cambios realizados
     * cuando el objeto fue equipado.
     *
     * @param player el jugador que está desequipando el objeto
     */
    public void unequip(Player player);
}