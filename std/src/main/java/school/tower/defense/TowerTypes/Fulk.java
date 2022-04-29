package school.tower.defense.TowerTypes;

import school.tower.defense.Templates.Enemy;
import school.tower.defense.Templates.PayCheck;
import school.tower.defense.Templates.Tower;

public class Fulk extends Tower implements PayCheck{
        
        public Fulk(String name, int cost, int damage, int range, int fireRate, int x, int y) {
            super(name, cost, damage, range, fireRate, x, y);
        }
    
        @Override
        public void attack(Enemy enemy) {
            //do nothing
        }
    
        @Override
        public Boolean place(int x, int y) {
            return true;
        }
    
        @Override
        public void subtract(int amounnt) {
            //do nothing
        }
    
}
