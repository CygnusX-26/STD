package school.tower.defense.TowerTypes;

import java.util.concurrent.TimeUnit;

import school.tower.defense.Classes.*;
import school.tower.defense.Templates.Enemy;
import school.tower.defense.Templates.Tower;

public class Fulk extends Tower {
    Game game;
    Upgrade currentUpgrade;
    int cost;
    Tile tile;

    /**
     * Constructor for the tower
     */
        
    public Fulk(Game game) {
        this.tile = null;
        this.game = game;
        currentUpgrade = new Upgrade("Base", 0, 1, 1, 1);
        cost = 100;

        new Thread(() -> {
            while (true) {
                if (tile == null) {
                    continue;
                }
    
                try {
                    long length = (long) (1000 / ((double) currentUpgrade.getAttackspeed()));
                    TimeUnit.MILLISECONDS.sleep(length);
    
                    attack();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void scanEnemies() {
        Grid grid = game.getGrid();

        for (Enemy enemy : game.getEnemies()) {
            double distance = Math.sqrt(Math.pow(enemy.getLocation().getX() - tile.getLocation().getX(), 2) + Math.pow(enemy.getLocation().getY() - tile.getLocation().getY(), 2));
            
            if (distance < currentUpgrade.getRange()) {
                attack(enemy);
            }
        }
    }

    private void attack(Enemy enemy) {
        enemy.
    }
    
    public void sell() {
        game.addMoney(cost * 0.7);
        tile.removeTower();
    }

    public void upgrade() {
        //do nothing
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
}
