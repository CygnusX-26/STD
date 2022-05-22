package school.tower.defense.TowerTypes;

import javafx.scene.layout.StackPane;
import school.tower.defense.Classes.*;
import school.tower.defense.Templates.*;

public class Pallone extends Tower {
    Game game;
    StackPane s;
    String pathName;
    
    /**
     * Constructor for the tower
     */
    public Pallone(Game game, StackPane s, String pathName, Location location) {
        super(game, s, location, 100, new Upgrade("0", 0, 1, 1000, 5), pathName);
        this.s = s;
        this.pathName = pathName;
    }
}
