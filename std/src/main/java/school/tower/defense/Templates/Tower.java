package school.tower.defense.Templates;

import school.tower.defense.Classes.*;

public abstract class Tower {
    public abstract void place(Location location); //Will place the tower and deduct the cost
    public abstract void sell(); //Will sell the tower and add the cost
    public abstract void upgrade(); //Will upgrade the tower and deduct the cost
    public abstract int getCost(); //Will return the cost of the tower
    public abstract Upgrade getUpgrade(); //Will return the damage of the tower
    public abstract void setTile(Tile tile); //Will set the tile that the tower is on
}
