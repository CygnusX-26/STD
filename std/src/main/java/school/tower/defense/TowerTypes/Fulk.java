package school.tower.defense.TowerTypes;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import school.tower.defense.Classes.*;
import school.tower.defense.EnemyTypes.LetterOfRec;
import school.tower.defense.Templates.*;

public class Fulk extends Tower {
    //Upgrade[] upgradeList = new Upgrade[6];
    Game game;
    Upgrade currentUpgrade;
<<<<<<< HEAD

=======
    Tile tile;
    StackPane s;
    String pathName;
>>>>>>> bfb72d6be4aa05ee93406a0f04f7a552388dc48d
    /**
     * Constructor for the tower
     */
        
    public Fulk(Game game, StackPane s, String pathName, Location location) {
        super(game, s, location, 100, new Upgrade("0", 0, 1, 1000, 1), pathName);
        this.s = s;
        this.pathName = pathName;
    }

    public void upgrade() {
        System.out.println("Fulk upgrading to lvl "+ (currentUpgrade.getDamage() + 1));
        //alternativly we could do it so upgrades are made in game.java and pushed out to all towers -colin
        currentUpgrade = new Upgrade("not base", 100, currentUpgrade.getDamage() + 1, currentUpgrade.getRange() + 50, currentUpgrade.getAttackspeed() + 1);
    }


    public void attack(Enemy enemy) {
        Platform.runLater(() -> {
            ImageView sprite = new ImageView(new Image(getClass().getResource(pathName).toExternalForm()));
            sprite.setFitWidth(15);
            sprite.setFitHeight(15);
            sprite.setTranslateX(super.getLocation().getX());
            sprite.setTranslateY(super.getLocation().getY());
            s.getChildren().add(sprite); //TODO colin work

            enemy.damage(currentUpgrade.getDamage());
            if (enemy instanceof LetterOfRec)
            {
                enemy.damage(currentUpgrade.getDamage());
            }
        });
    }
}
