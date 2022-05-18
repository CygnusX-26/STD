package school.tower.defense.EnemyTypes;

import java.util.ArrayList;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import school.tower.defense.Classes.Location;
import school.tower.defense.Templates.Enemy;

public class LetterOfRec extends Enemy {
    
    public LetterOfRec(StackPane s, Stage stage, ArrayList<Location> pathLocations, ArrayList<Enemy> enemies) {
        super("Letter Of Rec", 5, 0.1, 7, s, new String[] {"Enemies/Essay/essay1.png", "Enemies/Essay/essay1.png", "Enemies/Essay/essay2.png", "Enemies/Essay/essay3.png", "Enemies/Essay/essay4.png", "Enemies/Essay/essay5.png"}, stage, pathLocations); 
    }
}
