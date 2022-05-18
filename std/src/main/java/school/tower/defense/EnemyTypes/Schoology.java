package school.tower.defense.EnemyTypes;

import java.util.ArrayList;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import school.tower.defense.Classes.Location;
import school.tower.defense.Templates.Enemy;

public class Schoology extends Enemy {
    
    public Schoology(StackPane s, Stage stage, ArrayList<Location> pathLocations, ArrayList<Enemy> enemies) {
        super("Schoology", 6, 0.1, 11, s, new String[] {"Enemies/Schoology/schoology1.png", "Enemies/Schoology/schoology1.png", "Enemies/Schoology/schoology2.png", "Enemies/Schoology/schoology3.png", "Enemies/Schoology/schoology4.png", "Enemies/Schoology/schoology5.png", "Enemies/Schoology/schoology6.png"}, stage, pathLocations); 
    }
}
