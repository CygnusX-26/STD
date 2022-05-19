package school.tower.defense.Templates;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import school.tower.defense.Templates.Enemy;
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

    public abstract void upgrade(); //Will upgrade the tower and deduct the cost

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
            System.out.println("Furthest enemy is " + furthestEnemy.getDistanceTraveled());

            attack(furthestEnemy);
        }
    }

    public void sell() {
        game.addMoney(cost * 0.7);
    }

    private void attack(Enemy enemy) {
        projectiles.add(new Projectile(pathName, s, enemy, location, currentUpgrade.getDamage()));
        //move to individual teacher classes when projectiles completed to add double damage to specfic instanceof enemies. -colin
    }

    public int getCost() {
        return cost;
    }

    public Upgrade getUpgrade() {
        return currentUpgrade;
    }

    public Location getLocation() {
        return location;
    }

    public void stopThread(){
        exists = false;
    }

}
