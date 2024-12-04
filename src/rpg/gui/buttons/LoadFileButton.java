package rpg.gui.buttons;

import rpg.gui.windows.StartWindow;

public class LoadFileButton extends NewFileButton {

    public LoadFileButton(int slot, StartWindow startWindow) {
        super(slot, startWindow);
        setText("Cargar Partida");
        removeActionListener(getActionListeners()[0]);
    }
}
