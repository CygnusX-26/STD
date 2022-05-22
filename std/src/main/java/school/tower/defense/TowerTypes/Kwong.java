package school.tower.defense.TowerTypes;

import javafx.scene.layout.StackPane;
import school.tower.defense.Classes.*;
import school.tower.defense.Templates.*;

/**
 * Constructs a Kwong Teacher
 */
public class Kwong extends Tower {
    Game game;
    StackPane s;
    String pathName;
    
    /**
     * Constructor for the tower
     */
    public Kwong(Game game, StackPane s, String pathName, Location location) {
        super(game, s, location, 100, new Upgrade("0", 0, 2, 9999, 0.3), pathName);
        this.s = s;
        this.pathName = pathName;
    }
}