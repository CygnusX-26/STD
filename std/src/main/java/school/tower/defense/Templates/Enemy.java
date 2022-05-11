package school.tower.defense.Templates;

import school.tower.defense.Classes.*;

public abstract class Enemy {
    
        private String name;
        private int health, speed, reward;
        private Location location;
    
        public Enemy(String name, int health, int speed, int reward, int x, int y) {
            this.name = name;
            this.health = health;
            this.speed = speed;
            this.reward = reward;
            this.location = new Location(x, y);
        }
    
        public String getName() {
            return name;
        }
    
        public int getHealth() {
            return health;
        }
    
        public int getSpeed() {
            return speed;
        }
    
        public int getReward() {
            return reward;
        }
    
        public Location getLocation() {
            return location;
        }

        public void damage(int amount) {
            health -= amount;
        }
    
        public abstract void move();
        public abstract void attack(Tower tower);
        public abstract String spriteStatus();
}
