package school.tower.defense.Templates;

public class Upgrade {
    String name;
    int cost;
    int damage;
    int range;
    int attackspeed;

    public Upgrade(String name, int cost, int damage, int range, int attackspeed) {
        this.name = name;
        this.cost = cost;
        this.damage = damage;
        this.range = range;
        this.attackspeed = attackspeed;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public int getAttackspeed() {
        return attackspeed;
    }
}
