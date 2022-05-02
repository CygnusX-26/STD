package school.tower.defense.Templates;


public abstract class Tower {
    public abstract void place(); //Will place the tower and deduct the cost
    public abstract void sell(); //Will sell the tower and add the cost
    public abstract void upgrade(); //Will upgrade the tower and deduct the cost
    public abstract void getCost(); //Will return the cost of the tower
    public abstract void getUpgrade(); //Will return the damage of the tower
}
