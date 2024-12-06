package rpg.gui.buttons;

import rpg.gui.windows.MainWindow;
import rpg.gui.buttons.events.AttackEvent;

public class AttackButton extends UserButton {

    public AttackButton(MainWindow game) {

        super("Atacar");
        addActionListener(new AttackEvent(game));
    }
}