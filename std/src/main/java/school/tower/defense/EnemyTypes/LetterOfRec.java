package school.tower.defense.EnemyTypes;

import javafx.scene.layout.StackPane;
import school.tower.defense.Templates.Enemy;
import school.tower.defense.Templates.Tower;

public class LetterOfRec extends Enemy {
    private int reward;
    
    public LetterOfRec(StackPane s) {
        super("Letter Of Rec", 5, 10, 1, s, "defense/Map/test.jpg");
        this.reward = 1;
    }
    
    public void attack(Tower tower) {
        //do nothing
    }
    
    public void subtract(int amount) {
        reward -= amount;
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
