package rpg.entities.enemies.goblins;

import rpg.enums.EnemyType;
import rpg.Utils.cache.ImageCache;

import javax.swing.*;

/**
 * Representa al Goblin General, un enemigo mas fuerte dentro de la jerarquia de goblins.
 * Esta clase extiende RookieGoblin y redefine comportamientos especificos.
 */
public class GoblinGeneral extends RookieGoblin {

    /**
     * Construye un nuevo Goblin General con atributos predeterminados.
     */
    public GoblinGeneral() {
        super();
        setName("Goblin General");
        type = EnemyType.BOSS;
        ImageCache.addImage("goblin_general", "enemies/Zodiac Virgo.png");
    }

    /**
     * Devuelve el sprite asociado al Goblin General.
     *
     * @return ImageIcon que representa al Goblin General.
     */
    @Override
    public ImageIcon getSprite() {
        return new ImageIcon(ImageCache.getImage("goblin_general"));
    }
}