package school.tower.defense.EnemyTypes;

import java.util.ArrayList;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import school.tower.defense.Classes.Location;
import school.tower.defense.Templates.Enemy;

/**
 * Spawns in a collegeboard enemy
 */
public class Schoology extends Enemy {
    
    /**
     * constucts a enemy using the enemy templete constructor
     * @param s the stackpane of all images on screen
     * @param stage the stage where the game is played
     * @param pathLocations an arraylist of all waypoints the enemy should follow
     * @param enemies the arraylist of current enemies on screen
     */
    public Schoology(StackPane s, Stage stage, ArrayList<Location> pathLocations, ArrayList<Enemy> enemies, int roundNum) {
        super(6, 0.1 + (0.03) * roundNum, 11, s, new String[] {"Enemies/Schoology/schoology1.png", "Enemies/Schoology/schoology1.png", "Enemies/Schoology/schoology2.png", "Enemies/Schoology/schoology3.png", "Enemies/Schoology/schoology4.png", "Enemies/Schoology/schoology5.png", "Enemies/Schoology/schoology6.png"}, pathLocations); 
    }
}
