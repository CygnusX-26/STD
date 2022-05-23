package school.tower.defense.Classes;
/**
 * This class contains data to upgrade towers to be more powerful. 
 * This class is currently not bring used, but can be easily implemented in a future update
 */
public class Upgrade {
    int damage;
    int range;
    double attackspeed;

    /**
     * Constructing a upgrade and initalizing all variables
     * @param damage the damage increased of the upgrade
     * @param range the range increase of the upgrade
     * @param attackspeed the reload speed increase of the update
     */
    public Upgrade(int damage, int range, double attackspeed) {
        this.damage = damage;
        this.range = range;
        this.attackspeed = attackspeed;
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
    public double getAttackspeed() {
        return attackspeed;
    }
}
