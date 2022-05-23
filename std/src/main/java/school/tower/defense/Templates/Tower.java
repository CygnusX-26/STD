package school.tower.defense.Templates;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javafx.scene.layout.StackPane;
import school.tower.defense.Classes.*;

/**
 * Template for all tower types
 */
public class Tower {
    Game game;
    Upgrade currentUpgrade;
    Location location;
    StackPane s;
    String pathName;
    ArrayList<Projectile> projectiles;
    Thread t;
    boolean exists;


    /**
     * Sets the values for the tower class and runs a loop to damage enemies
     * @param game The game
     * @param s The scene
     * @param location The location of the tower
     * @param pathName The path name of the tower
     * @param cost The cost of the tower
     */
    public Tower(Game game, StackPane s, Location location, Upgrade upgrade, String pathName) {
        this.currentUpgrade = upgrade;
        this.game = game;
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
     * Upgrades the tower for additional damage
     */
    public void upgrade(){
        currentUpgrade = new Upgrade(currentUpgrade.getDamage() + 1, currentUpgrade.getRange() + 50, currentUpgrade.getAttackspeed() + 0.2);
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
            attack(furthestEnemy);
        }
    }

    /**
     * Attacks an enemy
     * @param enemy The enemy to attack
     */
    private void attack(Enemy enemy) {
        projectiles.add(new Projectile(pathName, s, enemy, location, currentUpgrade.getDamage()));
    }

    /**
     * Returns the current upgrade
     * @return current upgrade
     */
    public Upgrade getUpgrade() {
        return currentUpgrade;
    }

    /**
     * Stops the thread of attacking enemies
     */
    public void stopThread(){
        exists = false;
    }

}
