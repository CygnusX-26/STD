package school.tower.defense.Classes;
import java.util.ArrayList;
import school.tower.defense.App;
import school.tower.defense.Templates.*;

public class UI extends App {
    ArrayList<Tower> towers;
    ArrayList<Enemy> enemies;
    Grid grid;
    Money money;

    public UI() {
        towers = new ArrayList<Tower>();
        enemies = new ArrayList<Enemy>();
        money = new Money(1000);
        grid = new Grid(1920, 1080);
    }
}
