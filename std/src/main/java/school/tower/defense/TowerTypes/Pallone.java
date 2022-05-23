package school.tower.defense.TowerTypes;

import javafx.scene.layout.StackPane;
import school.tower.defense.Classes.*;
import school.tower.defense.Templates.*;

/**
 * constructs a Pallone Teacher
 */
public class Pallone extends Tower {
    
    /**
     * constucts a teacher using the tower templete constructor
     * @param game current game
     * @param s the stackpane
     * @param pathName the image file path
     * @param location where to place the tower
    */
    public Pallone(Game game, StackPane s, String pathName, Location location) {
        super(game, s, location, new Upgrade(1, 1000, 5), pathName);
    }
}
