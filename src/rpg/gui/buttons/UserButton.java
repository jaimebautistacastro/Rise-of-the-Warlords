package rpg.gui.buttons;

import rpg.gui.ui.UserHoverUI;

/**
 * Clase abstracta que representa un botón personalizado con una interfaz de usuario (UI) específica.
 * Este botón utiliza una UI personalizada para la interacción con el usuario y no tiene iconos predeterminados.
 */
public abstract class UserButton extends BaseButton {

    /**
     * Constructor de la clase UserButton.
     * Inicializa el botón con el texto proporcionado y configura su UI personalizada,
     * así como la ausencia de iconos predeterminados.
     *
     * @param text El texto que aparecerá en el botón.
     */
    public UserButton(String text) {
        super(text);
        // Agregamos los iconos a la caché de imágenes.
        setIcon(null);  // No se asigna icono predeterminado.
        setRolloverIcon(null);  // No se asigna icono para el rollover.
        setUI(new UserHoverUI());  // Se establece una UI personalizada.
    }

    /**
     * Metodo para inicializar los iconos del botón.
     * En esta clase no se inicializan iconos, ya que la clase es abstracta y se espera que las clases derivadas
     * los gestionen si es necesario.
     */
    @Override
    protected void initIcons() {
        // No se inicializan iconos en esta clase abstracta.
    }
}