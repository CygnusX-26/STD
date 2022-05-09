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

    @Override
    public void sell()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void upgrade()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void getCost()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void getUpgrade()
    {
        // TODO Auto-generated method stub
        
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
