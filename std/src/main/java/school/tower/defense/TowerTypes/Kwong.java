package school.tower.defense.TowerTypes;

import javafx.scene.layout.StackPane;
import school.tower.defense.Classes.*;
import school.tower.defense.Templates.*;

/**
 * constructs a Kwong Teacher
 */
public class Kwong extends Tower {
    
    /**
     * constucts a teacher using the tower templete constructor
     * @param game current game
     * @param s the stackpane
     * @param pathName the image file path
     * @param location where to place the tower
    */
    public Kwong(Game game, StackPane s, String pathName, Location location) {
        super(game, s, location, new Upgrade(2, 9999, 0.3), pathName);
    }
}