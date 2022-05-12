package school.tower.defense.Templates;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import school.tower.defense.Classes.Location;

public abstract class Enemy {
    
        private String name;
        private int health, speed, reward;
        private int pathNumber;
        private double traveledPercent;
        private Location location;
        private StackPane s;
        private ImageView sprite;
    
        public Enemy(String name, int health, int speed, int reward, StackPane s, String pathName) {
            this.name = name;
            this.health = health;
            this.speed = speed;
            this.reward = reward;
            this.pathNumber = 0;
            this.traveledPercent = 0; //Starts from the beginning
            this.location = new Location(-100, -100);
            this.s = s;
            sprite = new ImageView(new Image(getClass().getResource(pathName).toExternalForm()));
            sprite.setFitWidth(75);
            sprite.setFitHeight(75);
            sprite.setX(location.getX());
            sprite.setY(location.getY());
            s.getChildren().add(sprite);
        }
    
        public String getName() {
            return name;
        }
    
        public int getHealth() {
            return health;
        }
    
        public int getSpeed() {
            return speed;
        }
    
        public int getReward() {
            return reward;
        }
    
        public int getPathNumber() {
            return pathNumber;
        }

        public double getTraveledPercent() {
            return traveledPercent;
        }

        public Location getLocation() {
            return location;
        }

        public void damage(int amount) {
            health -= amount;
        }

        public ImageView getSprite() {
            return sprite;
        }
    
        public abstract void move();
        public abstract void attack(Tower tower);
        public abstract String spriteStatus();
}
