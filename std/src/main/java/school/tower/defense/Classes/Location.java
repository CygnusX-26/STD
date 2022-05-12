package school.tower.defense.Classes;

/**
 * This class descripbes a location on the screen (based on pixels)
 * There are three methods: GetX, GetY and distanceBetween.
 */
public class Location {
    private double x;
    private double y;

    /**
     * Constructs instance of Location and initalizes all variables
     * @param x 
     * @param y
     */
    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    
    /** 
     * Returns the value of x of the location
     * @return double of the x value
     */
    public double getX() {
        return x;
    }
    
    
    /** 
     * Returns the value of y of the location
     * @return double of the y value
     */
    public double getY() {
        return y;
    }

    
    /** 
     * Returns the distance between two locations
     * @param location the other location to compare against
     * @return double of the distance inbetween the two locations
     */
    public double distanceBetween(Location location) {
        return Math.sqrt(Math.pow(location.getX() - x, 2) + Math.pow(location.getY() - y, 2));
    }
}
