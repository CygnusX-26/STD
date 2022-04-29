package school.tower.defense.Templates;

public abstract class Enemy {
    
        private String name;
        private int health, speed, reward, x, y;
    
        public Enemy(String name, int health, int speed, int reward, int x, int y) {
            this.name = name;
            this.health = health;
            this.speed = speed;
            this.reward = reward;
            this.x = x;
            this.y = y;
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
    
        public int getX() {
            return x;
        }
    
        public int getY() {
            return y;
        }
    
        public abstract void move();
        public abstract void attack(Tower tower);
}
