package school.tower.defense.Classes;

import school.tower.defense.Classes.*;

/**
 *  A grid that contains tiles that will be used to place teachers
 * This class is currently not bring used, but can be easily implemented in a future update
 */
public class Grid {
    private int width;
    private int height;
    private Tile[][] tiles;

    /**
     * Constructs the grid to place tiles onto and initalizes variables
     * @param width total number of tiles in x direction
     * @param height total number of tiles in y dierection
     */
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

    
    /** 
     * Returns the tile at the speficied location
     * @param location specfied location
     * @return Tile at the location
     */
    public Tile getTile(Location location) {
        return tiles[(int)location.getX()][(int)location.getY()];
    }

    
    /** 
     * returns width of grid
     * @return int of the width
     */
    public int getWidth() {
        return width;
    }

    
    /** 
     * returns height of grid
     * @return int of the height
     */
    public int getHeight() {
        return height;
    }
}
