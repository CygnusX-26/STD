package school.tower.defense.EnemyTypes;

import java.util.ArrayList;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import school.tower.defense.Classes.Location;
import school.tower.defense.Templates.Enemy;

public class Collegeboard extends Enemy {
    
    public Collegeboard(StackPane s, Stage stage, ArrayList<Location> pathLocations, ArrayList<Enemy> enemies) {
        super("Collegeboard", 3, 0.2, 3, s, new String[] {"Enemies/Collegeboard/collegeboard1.png", "Enemies/Collegeboard/collegeboard1.png", "Enemies/Collegeboard/collegeboard2.png", "Enemies/Collegeboard/collegeboard3.png"}, stage, pathLocations); 
    }
}
