package rpg.gui.buttons;

import javax.swing.*;

public class Exit extends JButton {
    public Exit() {
        super("Exit");
        // Puedes agregar lógica para manejar el botón, como cerrar la aplicación
        addActionListener(e -> System.exit(0));  // Cierra la aplicación cuando se hace clic
    }
}
