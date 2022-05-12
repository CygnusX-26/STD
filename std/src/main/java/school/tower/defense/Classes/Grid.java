package school.tower.defense.Classes;

import school.tower.defense.Classes.*;

public class Grid {
    private int width;
    private int height;
    private Tile[][] tiles;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;

        tiles = new Tile[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = new Tile(new Location(x, y));
            }
        }
    }

    public Tile getTile(Location location) {
        return tiles[(int)location.getX()][(int)location.getY()];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
