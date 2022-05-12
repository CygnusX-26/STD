package school.tower.defense.Classes;

import school.tower.defense.Templates.Tower;
import school.tower.defense.Classes.Location;

public class Tile {
    private Location location;
    private boolean isOccupied;
    private Tower tower;

    public Tile(Location location) {
        this.location = location;
        this.isOccupied = false;
        this.tower = null;
    }

    
    /** 
     * Returns the location of the tile
     * @return Location of the location
     */
    public Location getLocation() {
        return location;
    }

    
    /** 
     * Returns if the tile is empty (used for placeing new teacher down)
     * @return boolean of if the tile is empty
     */
    public boolean isEmpty() {
        return !isOccupied;
    }

    
    /** 
     * Returns the tower that is inside the tile
     * @return Tower that is in the tile
     */
    public Tower occupiedBy() {
        return tower;
    }

    
    /** 
     * Puts a tower inside the tile and changes the private variables as appropriate
     * @param tower the tower to be inserted into the tile
     */
    public void setTower(Tower tower) {
        this.tower = tower;
        this.tower.setTile(this);
        isOccupied = true;
    }

    /** 
     * Removes the tower inside the tile and changes the private variables as appropriate
     * @return void
     */
    public void removeTower() {
        this.tower.setTile(null);
        this.tower = null;
        isOccupied = false;
    }
}
