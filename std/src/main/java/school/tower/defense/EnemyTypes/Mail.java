package school.tower.defense.EnemyTypes;

import java.util.ArrayList;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import school.tower.defense.Classes.Location;
import school.tower.defense.Templates.Enemy;

public class Mail extends Enemy {
    
    public Mail(StackPane s, Stage stage, ArrayList<Location> pathLocations, ArrayList<Enemy> enemies) {
        super("Mail", 3, 0.3, 5, s, new String[] {"Enemies/Gmail/gmail1.png", "Enemies/Gmail/gmail1.png", "Enemies/Gmail/gmail2.png", "Enemies/Gmail/gmail3.png"}, stage, pathLocations); 
    }
}
