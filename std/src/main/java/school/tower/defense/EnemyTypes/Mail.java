package school.tower.defense.EnemyTypes;

import java.util.ArrayList;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import school.tower.defense.Classes.Location;
import school.tower.defense.Templates.Enemy;

/**
 * Spawns in a collegeboard enemy
 */
public class Mail extends Enemy {
    
    /**
     * constucts a enemy using the enemy templete constructor
     * @param s the stackpane of all images on screen
     * @param stage the stage where the game is played
     * @param pathLocations an arraylist of all waypoints the enemy should follow
     * @param enemies the arraylist of current enemies on screen
     */
    public Mail(StackPane s, Stage stage, ArrayList<Location> pathLocations, ArrayList<Enemy> enemies, int roundNum) {
        super("Mail", 3, 0.25 + (0.03) * roundNum, 5, s, new String[] {"Enemies/Gmail/gmail1.png", "Enemies/Gmail/gmail1.png", "Enemies/Gmail/gmail2.png", "Enemies/Gmail/gmail3.png"}, pathLocations); 
    }
}
