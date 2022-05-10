package school.tower.defense.Classes;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import school.tower.defense.App;
import school.tower.defense.Templates.*;

public class Game extends App{
    private ArrayList<Tower> towers;
    private ArrayList<Enemy> enemies;
    private Grid grid;
    private double money;
    private boolean clicked;
    private int health;

    public Game() {
        towers = new ArrayList<Tower>();
        enemies = new ArrayList<Enemy>();
        money = 1000;
        grid = new Grid(1920, 1080);
        clicked = false;
        health = 69;
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
    
    public void run(){
        //run the game
        new Thread(() -> {
            while (health > 0) {
                try {
                    long length = (long) (16);
                    TimeUnit.MILLISECONDS.sleep(length);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
