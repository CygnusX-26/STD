package school.tower.defense.TowerTypes;

import java.util.concurrent.TimeUnit;

import school.tower.defense.Classes.*;
import school.tower.defense.Templates.Enemy;
import school.tower.defense.Templates.Tower;

public class Fulk extends Tower {
    Game game;
    //Upgrade[] upgradeList = new Upgrade[6];
    Upgrade currentUpgrade;
    int cost;
    Tile tile;

    /**
     * Constructor for the tower
     */
        
    public Fulk(Game game) {
        this.tile = null;
        this.game = game;
        
        //if updating these powerups make sure to update the tooltips on app.loadgame()
        // upgradeList[0] = new Upgrade("0", 0, 1, 1000, 1);
        // upgradeList[1] = new Upgrade("1", 0, 3, 1000, 1);
        // upgradeList[2] = new Upgrade("2", 0, 3, 1000, 2);
        // upgradeList[3] = new Upgrade("3", 0, 5, 1000, 2);
        // upgradeList[4] = new Upgrade("4", 0, 5, 1000, 3);
        // upgradeList[5] = new Upgrade("4", 0, 7, 1000, 3); 
        
        currentUpgrade = new Upgrade("0", 0, 1, 1000, 1);
        cost = 100;

        new Thread(() -> {
            while (true) {
                try {
                    long length = (long) (1000 / ((double) currentUpgrade.getAttackspeed()));
                    TimeUnit.MILLISECONDS.sleep(length);
    
                    scanEnemies();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void scanEnemies() {
        for (Enemy enemy : game.getEnemies()) {
            double distance = Math.sqrt(Math.pow(enemy.getLocation().getX() - tile.getLocation().getX(), 2) + Math.pow(enemy.getLocation().getY() - tile.getLocation().getY(), 2));

            System.out.println(distance);
            
            if (distance < currentUpgrade.getRange()) {
                attack(enemy);
            }
        }
    }

    private void attack(Enemy enemy) {
        System.out.println("Damaged");

        enemy.damage(currentUpgrade.getDamage());
    }
    
    public void sell() {
        game.addMoney(cost * 0.7);
        tile.removeTower();
    }

    public void upgrade() {
        System.out.println("Fulk upgrading to lvl "+ (currentUpgrade.getDamage() + 1));
        //alternativly we could do it so upgrades are made in game.java and pushed out to all towers -colin
        currentUpgrade = new Upgrade("not base", 100, currentUpgrade.getDamage() + 1, currentUpgrade.getRange() + 50, currentUpgrade.getAttackspeed() + 1);
       
        // // the old upgrade system is below
        // if (currentUpgrade == upgradeList[0])
        // {
        //     currentUpgrade = upgradeList[1];
        //     System.out.println("first upgrade");
        //     return;
        // }
        // if (currentUpgrade == upgradeList[1])
        // {
        //     currentUpgrade = upgradeList[2];
        //     System.out.println("second upgrade");
        //     return;
        // }
        // if (currentUpgrade == upgradeList[2])
        // {
        //     currentUpgrade = upgradeList[3];
        //     System.out.println("third upgrade");
        //     return;
        // }
        // if (currentUpgrade == upgradeList[3])
        // {
        //     currentUpgrade = upgradeList[4];
        //     System.out.println("fourth upgrade");
        //     return;
        // }
        // if (currentUpgrade == upgradeList[4])
        // {
        //     currentUpgrade = upgradeList[5];
        //     System.out.println("fifth upgrade");
        //     return;
        // }
        // System.out.println("out of upgrades");
    }

    public int getCost() {
        return cost;
    }

    public Upgrade getUpgrade() {
        return currentUpgrade;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public void place(Location location) {
        game.subtractMoney(cost);

        Grid grid = game.getGrid();
        Tile tile = grid.getTile(location);

        tile.setTower(this);
    }

    @Override
    public void attack()
    {
        // TODO Auto-generated method stub
        
    }
}
