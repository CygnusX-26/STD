package school.tower.defense.TowerTypes;

import school.tower.defense.Templates.Enemy;
import school.tower.defense.Templates.Tower;
import school.tower.defense.Templates.Upgrade;

public class Fulk extends Tower {
    Upgrade currentUpgrade;
        
    public Fulk() {
        currentUpgrade = new Upgrade("Base", 0, 1, 1, 1);
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
    
}
