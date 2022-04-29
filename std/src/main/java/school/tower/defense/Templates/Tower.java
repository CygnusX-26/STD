package school.tower.defense.Templates;


public abstract class Tower {

    private String name;
    private int cost, damage, range, fireRate, x, y;

    public Tower(String name, int cost, int damage, int range, int fireRate, int x, int y) {
        this.name = name;
        this.cost = cost;
        this.damage = damage;
        this.range = range;
        this.fireRate = fireRate;
        this.x = x;
        this.y = y;
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

    public int getFireRate() {
        return fireRate;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void attack(Enemy enemy);

    public abstract Boolean place(int x, int y);
}
