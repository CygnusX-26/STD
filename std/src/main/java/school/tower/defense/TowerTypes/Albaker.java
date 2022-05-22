package school.tower.defense.TowerTypes;

import javafx.scene.layout.StackPane;
import school.tower.defense.Classes.*;
import school.tower.defense.Templates.*;

public class Albaker extends Tower {
    Game game;
    StackPane s;
    String pathName;
    
    /**
     * Constructor for the tower
     */
    public Albaker (Game game, StackPane s, String pathName, Location location) {
        super(game, s, location, 100, new Upgrade("0", 0, 1, 400, 2), pathName);
        this.s = s;
        this.pathName = pathName;
    }
}