package school.tower.defense.Templates;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import school.tower.defense.Classes.Location;

/**
 * Template for all enemy types
 */
public class Enemy {
    private int health, reward;
    private double speed;
    private int pathNumber;
    private double traveledPercent;
    private Location location;
    private StackPane s;
    private ImageView sprite;
    private String[] pathName;
    private double distanceTraveled;

    
    /**
     * Creates an enemy
     * @param health The health of the enemy
     * @param speed The speed of the enemy
     * @param reward The reward of the enemy
     * @param s The stackpane
     * @param pathName The path name of the enemy
     * @param pathLocations The points on the path
     */
    public Enemy(int health, double speed, int reward, StackPane s, String[] pathName, ArrayList<Location> pathLocations) {
        this.health = health;
        this.speed = speed;
        this.reward = reward;
        this.pathNumber = 0;
        this.traveledPercent = 0; //Starts from the beginning
        this.distanceTraveled = 0;
        this.location = pathLocations.get(0);
        this.s = s;
        this.pathName = pathName;
        sprite = new ImageView(new Image(getClass().getResource(pathName[health]).toExternalForm()));
        sprite.setFitWidth(75);
        sprite.setFitHeight(75);
        sprite.setTranslateX(this.getLocation().getX());
        sprite.setTranslateY(this.getLocation().getY());

        s.getChildren().add(sprite);
    }

    /**
     * Gets the health of the enemy
     * @return The health of the enemy
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets the speed of the enemy
     * @return The speed of the enemy
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Gets the reward of the enemy
     * @return The reward of the enemy
     */
    public int getReward() {
        return reward;
    }

    /**
     * Sets the path number of the enemy
     * @param pathNumber The path number of the enemy
     */
    public void setPathNumber(int pathNumber) {
        this.pathNumber = pathNumber;
    }

    /**
     * Gets the path number of the enemy
     * @return The path number of the enemy
     */
    public int getPathNumber() {
        return pathNumber;
    }

    /**
     * Sets the traveled percent of the enemy
     * @param traveledPercent The traveled percent to set
     */
    public void setTraveledPercent(double traveledPercent) {
        this.traveledPercent = traveledPercent;
    }

    /**
     * Gets the traveled percent of the enemy
     * @return The traveled percent of the enemy
     */
    public double getTraveledPercent() {
        return traveledPercent;
    }

    /**
     * Adds distance traveled to the enemy
     * @param distance The distance to add
     */
    public void addDistanceTraveled(double distance) {
        this.distanceTraveled += distance;
    }

    /**
     * Gets the distance traveled of the enemy
     * @return The distance traveled of the enemy
     */
    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    /**
     * Sets the location of the enemy
     * @param location the location to set the enemy to
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Gets the location of the enemy
     * @return The location of the enemy
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Damages the enemy
     * @param amount The amount to damage the enemy
     */
    public void damage(int amount) {
        health -= amount;
        if (health < 0)
        {
            health = 0;
        }

        s.getChildren().remove(sprite);

        if (health <= 0) {
            return;
        }

        sprite = new ImageView(new Image(getClass().getResource(pathName[health]).toExternalForm()));
        sprite.setFitWidth(75);
        sprite.setFitHeight(75);
        sprite.setTranslateX(this.getLocation().getX());
        sprite.setTranslateY(this.getLocation().getY());
        s.getChildren().add(sprite);
    }

    /**
     * Returns the sprite of the enemy
     * @return The sprite of the enemy
     */
    public ImageView getSprite() {
        return sprite;
    }
}
