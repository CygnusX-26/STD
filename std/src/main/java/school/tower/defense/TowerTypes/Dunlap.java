package school.tower.defense.TowerTypes;

import javafx.scene.layout.StackPane;
import school.tower.defense.Classes.*;
import school.tower.defense.Templates.*;

/**
 * constructs a Dunlap Teacher
 */
public class Dunlap extends Tower {

    /**
     * constucts a teacher using the tower templete constructor
     * @param game current game
     * @param s the stackpane
     * @param pathName the image file path
     * @param location where to place the tower
    */
    public Dunlap(Game game, StackPane s, String pathName, Location location) {
        super(game, s, location, new Upgrade(1, 250, 6), pathName);
    }
}
