package school.tower.defense.EnemyTypes;

import java.util.ArrayList;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import school.tower.defense.Classes.Location;
import school.tower.defense.Templates.Enemy;

/**
 * Spawns in a collegeboard enemy
 */
public class LetterOfRec extends Enemy {
    
    /**
     * constucts a enemy using the enemy templete constructor
     * @param s the stackpane of all images on screen
     * @param stage the stage where the game is played
     * @param pathLocations an arraylist of all waypoints the enemy should follow
     * @param enemies the arraylist of current enemies on screen
     */
    public LetterOfRec(StackPane s, Stage stage, ArrayList<Location> pathLocations, ArrayList<Enemy> enemies) {
        super("Letter Of Rec", 5, 0.15, 7, s, new String[] {"Enemies/Essay/essay1.png", "Enemies/Essay/essay1.png", "Enemies/Essay/essay2.png", "Enemies/Essay/essay3.png", "Enemies/Essay/essay4.png", "Enemies/Essay/essay5.png"}, pathLocations); 
    }
}
