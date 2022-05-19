package school.tower.defense.Templates;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javafx.scene.layout.StackPane;
import school.tower.defense.Classes.*;

public abstract class Tower {
    Game game;
    Upgrade currentUpgrade;
    Location location;
    StackPane s;
    String pathName;
    int cost;
    ArrayList<Projectile> projectiles;
    Thread t;
    boolean exists;

    /**
     * Upgrades the tower
     */
    public abstract void upgrade(); //Will upgrade the tower and deduct the cost

    /**
     * Sets the values for the tower class and runs a loop to damage enemies
     * @param game The game
     * @param s The scene
     * @param location The location of the tower
     * @param pathName The path name of the tower
     * @param cost The cost of the tower
     */
    public Tower(Game game, StackPane s, Location location, int cost, Upgrade upgrade, String pathName) {
        this.currentUpgrade = upgrade;
        this.game = game;
        this.cost = cost;
        this.location = location;
        this.pathName = pathName;
        this.s = s;
        this.projectiles = new ArrayList<Projectile>();
        exists = true;

        t = new Thread(() -> {
            while (exists) {
                try {
                    long length = (long) (1000 / ((double) currentUpgrade.getAttackspeed()));
                    TimeUnit.MILLISECONDS.sleep(length);
    
                    scanEnemies();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
    
    /**
     * Scans for enemies and attacks them
     */
    public void scanEnemies() {
        Enemy furthestEnemy = null;
        double furthestTraveled = 0;

        for (Enemy enemy : game.getEnemies()) {
            double distance = Math.sqrt(Math.pow(enemy.getLocation().getX() - location.getX(), 2) + Math.pow(enemy.getLocation().getY() - location.getY(), 2));
            
            if (distance < currentUpgrade.getRange() && enemy.getDistanceTraveled() > furthestTraveled) {
                furthestEnemy = enemy;
                furthestTraveled = enemy.getDistanceTraveled();
            }
        }

        if (furthestEnemy != null) {
            //System.out.println("Furthest enemy is " + furthestEnemy.getDistanceTraveled());

            attack(furthestEnemy);
        }
    }

    /** 
     * Sells the tower
    */
    public void sell() {
        game.addMoney(cost * 0.7);
    }

    /**
     * Attacks an enemy
     * @param enemy The enemy to attack
     */
    private void attack(Enemy enemy) {
        projectiles.add(new Projectile(pathName, s, enemy, location, currentUpgrade.getDamage()));
        //move to individual teacher classes when projectiles completed to add double damage to specfic instanceof enemies. -colin
    }

    /**
     * Returns the cost of the tower
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * Returns the current upgrade
     * @return current upgrade
     */
    public Upgrade getUpgrade() {
        return currentUpgrade;
    }

    /**
     * Returns the location of the tower
     * @return location
     */
    public Location getLocation() {
        return location;
    }

    public void stopThread(){
        exists = false;
    }

}
