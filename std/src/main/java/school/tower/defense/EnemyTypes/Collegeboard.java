package school.tower.defense.EnemyTypes;

import java.util.ArrayList;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import school.tower.defense.Classes.Location;
import school.tower.defense.Templates.Enemy;

/**
 * spawns in a collegeboard enemy
 */
public class Collegeboard extends Enemy {
    
    /**
     * constucts a enemy using the enemy templete constructor
     * @param s the stackpane of all images on screen
     * @param stage the stage where the game is played
     * @param pathLocations an arraylist of all waypoints the enemy should follow
     * @param enemies the arraylist of current enemies on screen
     */
    public Collegeboard(StackPane s, Stage stage, ArrayList<Location> pathLocations, ArrayList<Enemy> enemies, int roundNum) {
        super(3, 0.2 + (0.03) * roundNum, 3, s, new String[] {"Enemies/Collegeboard/collegeboard1.png", "Enemies/Collegeboard/collegeboard1.png", "Enemies/Collegeboard/collegeboard2.png", "Enemies/Collegeboard/collegeboard3.png"}, pathLocations); 
    }
}
