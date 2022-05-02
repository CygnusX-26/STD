package school.tower.defense.Templates;

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
                tiles[x][y] = new Tile(x, y);
            }
        }
    }

    
}
