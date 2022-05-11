package school.tower.defense.EnemyTypes;

import school.tower.defense.Templates.Enemy;
import school.tower.defense.Templates.Tower;

public class LetterOfRec extends Enemy {
    
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

    public String spriteStatus()
    {
        int TrueHealthToSpriteOutputRatioIKnowThisIsAnInsanelyLongVariableeName = 1;
        String[] spriteNames = {"essay5.png", "essay4.png", "essay3.png", "essay2.png", "essay1.png"};
        return (spriteNames[getHealth()/TrueHealthToSpriteOutputRatioIKnowThisIsAnInsanelyLongVariableeName]);
    }

    @Override
    public void move()
    {
        //do Nothing
    }
    
}
