package school.tower.defense.Classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import school.tower.defense.App;
import school.tower.defense.EnemyTypes.*;
import school.tower.defense.Templates.*;
import school.tower.defense.TowerTypes.*;

public class Game extends App {
    private ArrayList<Tower> towers;
    private ArrayList<Enemy> enemies;
    private ArrayList<Location> pathLocations;
    private Grid grid;
    private double money;
    private boolean clicked;
    private int health;
    private Stage stage;
    private int roundNum;
    private int fulkUpgradeNum;

    public Game(Stage s, int width, int height) {
        towers = new ArrayList<Tower>();
        enemies = new ArrayList<Enemy>();
        money = 1000;
        grid = new Grid(width/75, height/75);
        clicked = false;
        health = 19999;
        pathLocations = new ArrayList<Location>();
        stage = s;
        roundNum = -1;
        fulkUpgradeNum = 0;

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


    /**
     * Updates enemy positions
     * @param Delta the time since the last update
     */
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
    
    public void run(StackPane s, Text hpnum) {
        //run the game
        Queue<Enemy> enemyQueue = new LinkedList<>();
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
            Platform.runLater(() -> {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("L");
                alert.setContentText("You survived " + (roundNum - 2) + " rounds!");
                alert.setHeaderText("You Lose!");
                alert.showAndWait();
                stage.close();
            });
            
        }).start();
        Platform.runLater(() -> {
            /*Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (enemyQueue.size() > 0)
                    {
                        enemies.add(enemyQueue.remove());
                    }
                    if (enemies.size() == 0)
                    {
                        roundNum++;
                        //System.out.println(roundNum);
                        loadEnemiesIntoQueue(roundNum, enemyQueue, s);
                    } 

                    for (int i = 0; i < enemies.size(); i++)
                    {
                        if (enemies.get(i).getHealth() <= 0)
                        {
                            enemies.remove(enemies.get(i));
                            s.getChildren().remove(enemies.get(i).getSprite());
                            i--;
                        }
                        else if (enemies.get(i).getLocation().getX()>(stage.getWidth()*0.898697-50) && enemies.get(i).getLocation().getX()<(stage.getWidth()*0.898697+50))
                        {
                            if (enemies.get(i).getLocation().getY()>(stage.getHeight()*0.71102-50) && enemies.get(i).getLocation().getY()<(stage.getHeight()*0.71102+50))
                            {
                                enemies.remove(enemies.get(i));
                                s.getChildren().remove(enemies.get(i).getSprite());
                                health--;
                                hpnum.setText(health + "");
                                i--;
                            }
                        }
                    }
                }
            }
            ));
            timeline1.setCycleCount(999999999);
            timeline1.play();

            System.out.println("timeline1 complete");

            //speeding up the spawn rate over every 90 seconds
            Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(0.8), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (enemyQueue.size() > 0)
                        {
                            enemies.add(enemyQueue.remove());
                        }
                        if (enemies.size() == 0)
                        {
                            roundNum++;
                            //System.out.println(roundNum);
                            loadEnemiesIntoQueue(roundNum, enemyQueue, s);
                        } 
                        for (int i = 0; i < enemies.size(); i++)
                        {
                            if (enemies.get(i).getHealth() <= 0)
                            {
                                enemies.remove(enemies.get(i));
                                s.getChildren().remove(enemies.get(i).getSprite());
                                i--;
                            }
                            if (enemies.get(i).getLocation().getX()>(stage.getWidth()*0.898697-20) && enemies.get(i).getLocation().getX()<(stage.getWidth()*0.898697+20))
                            {
                                if (enemies.get(i).getLocation().getY()>(stage.getHeight()*0.71102-50) && enemies.get(i).getLocation().getY()<(stage.getHeight()*0.71102+50))
                                {
                                    enemies.remove(enemies.get(i));
                                    s.getChildren().remove(enemies.get(i).getSprite());
                                    health--;
                                    hpnum.setText(health + "");
                                    i--;
                                }
                            }
                        }
                    }
                }
                ));
                timeline2.setCycleCount(113);
                timeline2.play(); 

                System.out.println("timeline2 complete");

                Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(0.6), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (enemyQueue.size() > 0)
                        {
                            enemies.add(enemyQueue.remove());
                        }
                        if (enemies.size() == 0)
                        {
                            roundNum++;
                            //System.out.println(roundNum);
                            loadEnemiesIntoQueue(roundNum, enemyQueue, s);
                        } 
                        for (int i = 0; i < enemies.size(); i++)
                        {
                            if (enemies.get(i).getHealth() <= 0)
                            {
                                enemies.remove(enemies.get(i));
                                s.getChildren().remove(enemies.get(i).getSprite());
                                i--;
                            }
                            if (enemies.get(i).getLocation().getX()>(stage.getWidth()*0.898697-20) && enemies.get(i).getLocation().getX()<(stage.getWidth()*0.898697+20))
                            {
                                if (enemies.get(i).getLocation().getY()>(stage.getHeight()*0.71102-50) && enemies.get(i).getLocation().getY()<(stage.getHeight()*0.71102+50))
                                {
                                    enemies.remove(enemies.get(i));
                                    s.getChildren().remove(enemies.get(i).getSprite());
                                    health--;
                                    hpnum.setText(health + "");
                                    i--;
                                }
                            }
                        }
                    }
                }
                ));
                timeline3.setCycleCount(150);
                timeline3.play();

                System.out.println("timeline3 complete");*/

                Timeline timeline4 = new Timeline(new KeyFrame(Duration.seconds(0.4), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (enemyQueue.size() > 0)
                        {
                            enemies.add(enemyQueue.remove());
                        }
                        if (enemies.size() == 0)
                        {
                            roundNum++;
                            //System.out.println(roundNum);
                            loadEnemiesIntoQueue(roundNum, enemyQueue, s);
                        } 
                        for (Enemy i : enemies)
                        {
                            if (i.getLocation().getX()>(stage.getWidth()*0.898697-20) && i.getLocation().getX()<(stage.getWidth()*0.898697+20))
                            {
                                if (i.getLocation().getY()>(stage.getHeight()*0.71102-50) && i.getLocation().getY()<(stage.getHeight()*0.71102+50))
                                {
                                    enemies.remove(enemies.indexOf(i));
                                    s.getChildren().remove(i.getSprite());
                                    health--;
                                    hpnum.setText(health + "");
                                }
                            }
                        }
                    }
                }
                ));
                timeline4.setCycleCount(999999999); //should be 225 times
                timeline4.play(); });

                System.out.println("timeline4 complete");

        // backup code
        //     Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() {
        //         @Override
        //         public void handle(ActionEvent event) {
        //             Enemy enemy = new LetterOfRec(s, stage, pathLocations);
        //             enemies.add(enemy);
        //         }
        //     }));
        //     timeline2.setCycleCount(5);
        //     timeline2.play();
        // });
    }

    public Queue<Enemy> loadEnemiesIntoQueue(int roundNum, Queue<Enemy> enemyQueue, StackPane s)
    {
        Random rando = new Random();
        rando.setSeed(roundNum*271); //it's a prime number
        for (int i = 0; i < roundNum; i++) //do roundnum times
        {
            int cap = rando.nextInt(roundNum);
            double probability = rando.nextDouble();
            int enemyType = 0;
            if (probability < 0.25)
            {
                continue;
            }
            if (probability < 0.5 )
            {
                enemyType = 0;
            }
            else if (probability < 0.66 )
            {
                enemyType = 1;
            }
            else if (probability < 1 )
            {
                enemyType = 2;
            }
            for (int j = 0; j < cap; j++) // generate a type of enemy rando times
            {
                switch (enemyType)
                {
                    case 0:
                    enemyQueue.add(new LetterOfRec(s, stage, pathLocations));
                    break;
                    case 1:
                    enemyQueue.add(new LetterOfRec(s, stage, pathLocations));
                    break;
                    case 2:
                    enemyQueue.add(new LetterOfRec(s, stage, pathLocations));
                    break;
                    default:
                    break;
                }
            }
        }
        return enemyQueue;
    }

    public void upgradeTower(int i)
    {
        for (Tower t : towers)
        {
            if (i == 8)
            {
                if (t instanceof Fulk)
                {
                    t.upgrade();
                }
            }
            if (i == 9)
            {
                if (t instanceof Fulk) //replace with next teacher and copy paste
                {
                    t.upgrade();
                }
            }
        }
    }
}
