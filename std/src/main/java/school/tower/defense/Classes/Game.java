package school.tower.defense.Classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
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

    public Game(int width, int height) {
        towers = new ArrayList<Tower>();
        enemies = new ArrayList<Enemy>();
        money = 1000;
        grid = new Grid(width/75, height/75);
        clicked = false;
        health = 69;
        pathLocations = new ArrayList<Location>();

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
            double distanceToMove = enemy.getSpeed() * Delta;
            Location currentPathLocation = enemy.getLocation();
            Location nextPathLocation = pathLocations.get(enemy.getPathNumber() + 1);
            
            while (true) {
                if (currentPathLocation.distanceBetween(nextPathLocation) > distanceToMove) {
                    break;
                }
            }
        }
    }
    
    public void run() {
        //run the game

        Enemy enemy = new LetterOfRec(super.getGame());

        enemies.add(enemy);

        new Thread(() -> {
            long lastUpdate = System.currentTimeMillis();

            while (health > 0) {
                try {
                    long length = (long) (16);
                    TimeUnit.MILLISECONDS.sleep(length);

                    updateFrame(System.currentTimeMillis() - lastUpdate); //Create a new method otherwise it gets cluttered

                    lastUpdate = System.currentTimeMillis();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
