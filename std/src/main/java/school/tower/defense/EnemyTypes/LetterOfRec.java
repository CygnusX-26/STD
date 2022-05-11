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
        String[] spriteNames = {"Map/Enemies/Essay/essay5.png", "Map/Enemies/Essay/essay4.png", "Map/Enemies/Essay/essay3.png", "Map/Enemies/Essay/essay2.png", "Map/Enemies/Essay/essay1.png"};
        return (spriteNames[getHealth()/TrueHealthToSpriteOutputRatioIKnowThisIsAnInsanelyLongVariableeName]);
    }

    public int getReward()
    {
        return reward;
    }

    @Override
    public void move()
    {
        //do Nothing
    }
    
}
