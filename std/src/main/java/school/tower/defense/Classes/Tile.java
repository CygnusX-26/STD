package school.tower.defense.Classes;

import school.tower.defense.Templates.Tower;

public class Tile {
    private int x;
    private int y;
    private boolean isOccupied;
    private Tower tower;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.isOccupied = false;
        this.tower = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isEmpty() {
        return !isOccupied;
    }

    public Tower occupiedBy() {
        return tower;
    }
}
