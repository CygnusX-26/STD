package school.tower.defense.TowerTypes;

import school.tower.defense.Classes.Upgrade;
import school.tower.defense.Templates.Enemy;
import school.tower.defense.Templates.Tower;

public class Fulk extends Tower {
    Upgrade currentUpgrade;
    int cost;
        
    public Fulk() {
        currentUpgrade = new Upgrade("Base", 0, 1, 1, 1);
        cost = 100;
    }

    public void attack(Enemy enemy) {
        //do nothing
    }

    public Boolean place(int x, int y) {
        return true;
    }

    public void subtract(int amounnt) {
        //do nothing
    }
    
    public void sell() {
        //do nothing
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

    public void place() {
        //do nothing
    }
}
