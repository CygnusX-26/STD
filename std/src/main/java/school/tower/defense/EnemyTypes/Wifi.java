package school.tower.defense.EnemyTypes;

import java.util.ArrayList;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import school.tower.defense.Classes.Location;
import school.tower.defense.Templates.Enemy;

public class Wifi extends Enemy {
    
    public Wifi(StackPane s, Stage stage, ArrayList<Location> pathLocations, ArrayList<Enemy> enemies) {
        super("Wifi", 4, 0.5, 9, s, new String[] {"Enemies/Wifi/wifi1.png", "Enemies/Wifi/wifi1.png", "Enemies/Wifi/wifi2.png", "Enemies/Wifi/wifi3.png", "Enemies/Wifi/wifi4.png"}, stage, pathLocations); 
    }
}
