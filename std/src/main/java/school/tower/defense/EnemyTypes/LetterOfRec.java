package school.tower.defense.EnemyTypes;

import java.util.ArrayList;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import school.tower.defense.Classes.Location;
import school.tower.defense.Templates.Enemy;
import school.tower.defense.Templates.Tower;

public class LetterOfRec extends Enemy {
    //private int reward;
    
    public LetterOfRec(StackPane s, Stage stage, ArrayList<Location> pathLocations, ArrayList<Enemy> enemies) {
        super("Letter Of Rec", 5, 0.1, 7, s, new String[] {"Enemies/Essay/essay1.png", "Enemies/Essay/essay1.png", "Enemies/Essay/essay2.png", "Enemies/Essay/essay3.png", "Enemies/Essay/essay4.png", "Enemies/Essay/essay5.png"}, stage, pathLocations, enemies); // there are two essay1's because of health can be 0 before it's deleted. -colin 
        //this.reward = 1;
    }
    
    public void attack(Tower tower) {
        //do nothing
    }
    /*
    public void subtract(int amount) {
        reward -= amount;
    }

    //defunct function
    public String spriteStatus()
    {
        String[] spriteNames = {"Map/Enemies/Essay/essay5.png", "Map/Enemies/Essay/essay4.png", "Map/Enemies/Essay/essay3.png", "Map/Enemies/Essay/essay2.png", "Map/Enemies/Essay/essay1.png"};
        return (spriteNames[getHealth()]);
    }

    public int getReward()
    {
        return reward;
    }
    */

    @Override
    public void move()
    {
        //do Nothing
    }
    
}
