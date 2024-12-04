package rpg.gui.buttons;

import rpg.gui.windows.StartWindow;

public class NewFileButton extends UserButton {

    int slot;
    StartWindow startWindow;

    public NewFileButton(int slot, StartWindow startWindow) {

        super("Nueva Partida");
        this.slot = slot;
    }
}
