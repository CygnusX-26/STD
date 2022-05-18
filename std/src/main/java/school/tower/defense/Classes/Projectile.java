package school.tower.defense.Classes;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import school.tower.defense.Templates.Enemy;

public class Projectile {
    ImageView sprite;
    String pathName;
    Enemy target;
    Location location;
    int damage;
    StackPane s;

    public Projectile(String pathName, StackPane s, Enemy target, Location location, int damage) {
        this.pathName = pathName;
        this.target = target;
        this.location = location;
        this.damage = damage;
        this.s = s;

        Platform.runLater(() -> {
            ImageView sprite = new ImageView(new Image(getClass().getResource(pathName).toExternalForm()));
            sprite.setFitWidth(15);
            sprite.setFitHeight(15);
            sprite.setTranslateX(location.getX() - s.getWidth()/2);
            sprite.setTranslateY(location.getY() - s.getHeight()/2);
            s.getChildren().add(sprite);
        });
    }

    public void updateProjectile(double delta) {

    }
}
