package school.tower.defense.Classes;

import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import school.tower.defense.Templates.Enemy;

/**
 * creates a projectile from the tower to hit the enemy and deals damage
 */
public class Projectile {
    ImageView sprite;
    String pathName;
    Enemy target;
    Location location;
    int damage;
    StackPane s;

    /**
     * Creates a projectile and runs a loop to update the projectiles position
     * @param pathName The path name of the projectile
     * @param s The scene to add the projectile to
     * @param target The enemy to attack
     * @param location The location of the projectile
     * @param damage The damage of the projectile
     */
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

            this.sprite = sprite;
        });

        new Thread(() -> {
            long[] lastUpdate = new long []{System.currentTimeMillis()};

            while (sprite == null) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while (true) {
                try {
                    long length = (long) (100);
                    TimeUnit.MILLISECONDS.sleep(length);

                    if (sprite == null) {
                        break;
                    }
                    updateProjectile(System.currentTimeMillis() - lastUpdate[0]);
                    
                    lastUpdate[0] = System.currentTimeMillis();
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Updates the projectiles position and damaged the target
     * @param time The time since the last projectile update
     */
    public void updateProjectile(double delta) {
        final double[] distance = new double[]{Math.sqrt(Math.pow(target.getLocation().getX() - location.getX(), 2) + Math.pow(target.getLocation().getY() - location.getY(), 2))};
        double canMoveDistance = delta/1.5;
        double distanceToMove = distance[0] >= canMoveDistance ? canMoveDistance : distance[0];
        double percentToMove = distanceToMove/distance[0];

        double locationToMoveX = location.getX() + (target.getLocation().getX() - location.getX()) * percentToMove;
        double locationToMoveY = location.getY() + (target.getLocation().getY() - location.getY()) * percentToMove;


        location = new Location(locationToMoveX, locationToMoveY);

        distance[0] = Math.sqrt(Math.pow(target.getLocation().getX() - location.getX(), 2) + Math.pow(target.getLocation().getY() - location.getY(), 2));

        Platform.runLater(() -> {
            sprite.setTranslateX(locationToMoveX - s.getWidth()/2);
            sprite.setTranslateY(locationToMoveY - s.getHeight()/2);
    
            if (distance[0] < 5) {
                    target.damage(damage);
                    s.getChildren().remove(sprite);
    
                    sprite = null;
            }
        });
        
    }
}
