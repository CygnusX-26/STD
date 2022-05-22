package school.tower.defense.TowerTypes;

import javafx.scene.layout.StackPane;
import school.tower.defense.Classes.*;
import school.tower.defense.Templates.*;

/**
 * Constructs a Dunlap Teacher
 */
public class Dunlap extends Tower {
    Game game;
    StackPane s;
    String pathName;
    
    /**
     * Constructor for the tower
     */
    public Dunlap(Game game, StackPane s, String pathName, Location location) {
        super(game, s, location, 100, new Upgrade("0", 0, 1, 50, 6), pathName);
        this.s = s;
        this.pathName = pathName;
    }
}
