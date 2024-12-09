package rpg.interfaces;

/**
 * La interfaz Sellable define el contrato para los objetos que pueden ser vendidos en el juego.
 * Las clases que implementen esta interfaz deben proporcionar la lógica para vender el objeto.
 */
public interface Sellable {

    /**
     * Vende un objeto. Este metodo se llama cuando el objeto debe ser vendido, y debe implementar
     * la lógica para realizar la transacción de venta, como actualizar el inventario del jugador y
     * agregar el dinero o recurso recibido por la venta.
     */
    public void sell();
}