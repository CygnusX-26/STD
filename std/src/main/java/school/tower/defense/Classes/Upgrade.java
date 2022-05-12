package school.tower.defense.Classes;
/**
 * This class contains data to upgrade towers to be more powerful. 
 * This class is currently not bring used, but can be easily implemented in a future update
 */
public class Upgrade {
    String name;
    int cost;
    int damage;
    int range;
    int attackspeed;

    /**
     * Constructing a upgrade and initalizing all variables
     * @param name name of the upgrade
     * @param cost the cost in Money of the upgrade
     * @param damage the damage increased of the upgrade
     * @param range the range increase of the upgrade
     * @param attackspeed the reload speed increase of the update
     */
    public Upgrade(String name, int cost, int damage, int range, int attackspeed) {
        this.name = name;
        this.cost = cost;
        this.damage = damage;
        this.range = range;
        this.attackspeed = attackspeed;
    }

    
    /** 
     * Returns the name of the upgrade
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /**
     * Returns the cost of the upgrade
     * @return int
     */
    public int getCost() {
        return cost;
    }

    
    /** 
     * Returns the damage of the upgrade
     * @return int
     */
    public int getDamage() {
        return damage;
    }

    
    /** 
     * Returns the range of the upgrade
     * @return int
     */
    public int getRange() {
        return range;
    }

    
    /** 
     * Returns the attack speed of the upgrade
     * @return int
     */
    public int getAttackspeed() {
        return attackspeed;
    }
}
