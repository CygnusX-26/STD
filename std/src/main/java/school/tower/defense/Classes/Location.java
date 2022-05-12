package school.tower.defense.Classes;

public class Location {
    private double x;
    private double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }

    public double distanceBetween(Location location) {
        return Math.sqrt(Math.pow(location.getX() - x, 2) + Math.pow(location.getY() - y, 2));
    }
}
