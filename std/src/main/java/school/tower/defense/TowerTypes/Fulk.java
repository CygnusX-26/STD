package school.tower.defense.TowerTypes;

import school.tower.defense.Templates.Enemy;
import school.tower.defense.Templates.Tower;

public class Fulk extends Tower {
        
    public Fulk(String name, int cost, int damage, int range, int fireRate, int x, int y) {
        super(name, cost, damage, range, fireRate, x, y);
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
