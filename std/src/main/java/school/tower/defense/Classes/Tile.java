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

    public Location getLocation() {
        return location;
    }

    public boolean isEmpty() {
        return !isOccupied;
    }

    public Tower occupiedBy() {
        return tower;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
        this.tower.setTile(this);
        isOccupied = true;
    }

    public void removeTower() {
        this.tower.setTile(null);
        this.tower = null;
        isOccupied = false;
    }
}
