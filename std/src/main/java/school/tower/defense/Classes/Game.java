package school.tower.defense.Classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import school.tower.defense.App;
import school.tower.defense.EnemyTypes.*;
import school.tower.defense.Templates.*;

public class Game extends App {
    private ArrayList<Tower> towers;
    private ArrayList<Enemy> enemies;
    private ArrayList<Location> pathLocations;
    private Grid grid;
    private double money;
    private boolean clicked;
    private int health;
    private Stage stage;

    public Game(Stage s, int width, int height) {
        towers = new ArrayList<Tower>();
        enemies = new ArrayList<Enemy>();
        money = 1000;
        grid = new Grid(width/75, height/75);
        clicked = false;
        health = 69;
        pathLocations = new ArrayList<Location>();
        stage = s;

        File file = new File("std/src/main/java/school/tower/defense/DataFiles/Maps/Map.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch(FileNotFoundException e) {
            System.out.println("I hate java map stuff broke AGAIN");
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //Add a new location to pathLocations. The location is in the line variable and the x coordinate is on the left side of the space and the y coordinate is on the right side of the space. Add them as doubles
            double x = Double.parseDouble(line.substring(0, line.indexOf(" ")));
            double y = Double.parseDouble(line.substring(line.indexOf(" ") + 1));

            pathLocations.add(new Location(x * width, y * height));
        }
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public Grid getGrid() {
        return grid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void addMoney(double money) {
        this.money += money;
    }

    public void subtractMoney(double money) {
        this.money -= money;
    }

    public int getHealth(){
        return health;
    }

    public int takeDamage(){
        health--;
        return health;
    }

    /**
     * Adds a tower to the game
     * @param t tower to add
     * @param x x coordinate of the tower
     * @param y y coordinate of the tower
     * @return true if enough money or not occupied, false otherwise
     */
    public boolean placeTower(Tower t, int x, int y){
        //place a tower onto grid
        return false;
    }

    public void updateFrame(long Delta) {
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);

            if (enemy.getPathNumber() >= pathLocations.size() - 1) {
                continue;
            }

            //System.out.println(enemy.getPathNumber());
            //System.out.println(enemy.getTraveledPercent() * 100);

            double distanceToMove = enemy.getSpeed() * Delta;
            Location currentPathLocation = enemy.getLocation();
            Location nextPathLocation = pathLocations.get(enemy.getPathNumber() + 1);
            
            while (true) {
                if (currentPathLocation.distanceBetween(nextPathLocation) > distanceToMove) {
                    break;
                }

                distanceToMove -= currentPathLocation.distanceBetween(nextPathLocation);
                enemy.setTraveledPercent(0);

                if (enemy.getPathNumber() + 1 < pathLocations.size()) {
                    enemy.setPathNumber(enemy.getPathNumber() + 1);
                }

                if (enemy.getPathNumber() + 1 < pathLocations.size()) {
                    currentPathLocation = nextPathLocation;
                    nextPathLocation = pathLocations.get(enemy.getPathNumber() + 1);
                } else {
                    break;
                }
            }

            double distance = currentPathLocation.distanceBetween(nextPathLocation);
            double traveledPercent = enemy.getTraveledPercent() + (distanceToMove/distance);
            double xDifference = (nextPathLocation.getX() - currentPathLocation.getX()) * traveledPercent;
            double yDifference = (nextPathLocation.getY() - currentPathLocation.getY()) * traveledPercent;

            enemy.setTraveledPercent(traveledPercent);
            enemy.setLocation(new Location(currentPathLocation.getX() + xDifference, currentPathLocation.getY() + yDifference));

            enemy.getSprite().setTranslateX(enemy.getLocation().getX() - stage.getWidth()/2);
            enemy.getSprite().setTranslateY(enemy.getLocation().getY() - stage.getHeight()/2);

            // System.out.println(enemy.getLocation().getX());
            // System.out.println(enemy.getLocation().getY());
        }
    }
    
    public void run(StackPane s) {
        //run the game

        final long[] round = {1};
        new Thread(() -> {
            long lastUpdate = System.currentTimeMillis();
            while (health > 0) {
                try {
                    long length = (long) (10);
                    TimeUnit.MILLISECONDS.sleep(length);

                    updateFrame(System.currentTimeMillis() - lastUpdate); //Create a new method otherwise it gets cluttered

                    lastUpdate = System.currentTimeMillis();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
        }).start();
        Platform.runLater(() -> {
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Enemy enemy = new LetterOfRec(s, stage, pathLocations);
                    enemies.add(enemy);
                }
            }));
            timeline.setCycleCount(1);
            timeline.play();
        });
    }
}
