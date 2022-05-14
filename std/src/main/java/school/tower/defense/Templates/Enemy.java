package school.tower.defense.Templates;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import school.tower.defense.Classes.Location;

public abstract class Enemy {
        private String name;
        private int health, reward;
        private double speed;
        private int pathNumber;
        private double traveledPercent;
        private Location location;
        private StackPane s;
        private ImageView sprite;
        private String[] pathName;
        private Stage stage;
        private ArrayList<Enemy> enemies;
    
        public Enemy(String name, int health, double speed, int reward, StackPane s, String[] pathName, Stage stage, ArrayList<Location> pathLocations, ArrayList<Enemy> enemies) {
            this.name = name;
            this.health = health;
            this.speed = speed;
            this.reward = reward;
            this.pathNumber = 0;
            this.traveledPercent = 0; //Starts from the beginning
            this.location = pathLocations.get(0);
            this.s = s;
            this.pathName = pathName;
            this.stage = stage;
            this.enemies = enemies;
            sprite = new ImageView(new Image(getClass().getResource(pathName[health]).toExternalForm()));
            sprite.setFitWidth(75);
            sprite.setFitHeight(75);
            sprite.setTranslateX(this.getLocation().getX() - stage.getWidth()/2);
            s.getChildren().add(sprite);
        }
    
        public String getName() {
            return name;
        }
    
        public int getHealth() {
            return health;
        }
    
        public double getSpeed() {
            return speed;
        }
    
        public int getReward() {
            return reward;
        }

        public void setPathNumber(int pathNumber) {
            this.pathNumber = pathNumber;
        }
    
        public int getPathNumber() {
            return pathNumber;
        }

        public void setTraveledPercent(double traveledPercent) {
            this.traveledPercent = traveledPercent;
        }

        public double getTraveledPercent() {
            return traveledPercent;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public Location getLocation() {
            return location;
        }

        public void damage(int amount) {
            health -= amount;
            if (health < 0)
            {
                health = 0;
            }
            //System.out.println("damaged health now " + health);
            //enemies.remove(this);
            s.getChildren().remove(sprite);
            sprite = new ImageView(new Image(getClass().getResource(pathName[health]).toExternalForm()));
            sprite.setFitWidth(75);
            sprite.setFitHeight(75);
            sprite.setTranslateX(this.getLocation().getX() - stage.getWidth()/2);
            s.getChildren().add(sprite);
            //enemies.add(this);        
        }

        public ImageView getSprite() {
            return sprite;
        }
    
        public abstract void move();
        public abstract void attack(Tower tower);
        //public abstract String spriteStatus();
}
