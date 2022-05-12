package school.tower.defense.Templates;

import school.tower.defense.Classes.*;

public abstract class Enemy {
    
        private String name;
        private int health, speed, reward;
        private int pathNumber;
        private double traveledPercent;
        private Location location;
    
        public Enemy(String name, int health, int speed, int reward) {
            this.name = name;
            this.health = health;
            this.speed = speed;
            this.reward = reward;
            this.pathNumber = 0;
            this.traveledPercent = 0; //Starts from the beginning
            this.location = new Location(-100, -100);
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
    
        public int getPathNumber() {
            return pathNumber;
        }

        public double getTraveledPercent() {
            return traveledPercent;
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
