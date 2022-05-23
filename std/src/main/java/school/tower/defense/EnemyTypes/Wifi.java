package school.tower.defense.EnemyTypes;

import java.util.ArrayList;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import school.tower.defense.Classes.Location;
import school.tower.defense.Templates.Enemy;

/**
 * Spawns in a collegeboard enemy
 */
public class Wifi extends Enemy {
    
    /**
     * constucts a enemy using the enemy templete constructor
     * @param s the stackpane of all images on screen
     * @param stage the stage where the game is played
     * @param pathLocations an arraylist of all waypoints the enemy should follow
     * @param enemies the arraylist of current enemies on screen
     */
    public Wifi(StackPane s, Stage stage, ArrayList<Location> pathLocations, ArrayList<Enemy> enemies, int roundNum) {
        super(4, 0.4 + (0.03) * roundNum, 9, s, new String[] {"Enemies/Wifi/wifi1.png", "Enemies/Wifi/wifi1.png", "Enemies/Wifi/wifi2.png", "Enemies/Wifi/wifi3.png", "Enemies/Wifi/wifi4.png"}, pathLocations); 
    }
}
