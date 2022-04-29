package school.tower.defense.EnemyTypes;

import school.tower.defense.Templates.Enemy;
import school.tower.defense.Templates.PayCheck;
import school.tower.defense.Templates.Tower;

public class LetterOfRec extends Enemy implements PayCheck {
    
    private int reward;
    
    public LetterOfRec(String name, int health, int speed, int reward, int x, int y) {
        super(name, health, speed, reward, x, y);
        this.reward = reward;
    }
    
    public void attack(Tower tower) {
        //do nothing
    }
    
    public void subtract(int amounnt) {
        reward -= amounnt;
    }

    @Override
    public void move()
    {
        //do Nothing
    }
    
}
