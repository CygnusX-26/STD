package school.tower.defense.Classes;

public class Money {
    int money;

    public Money() {
        this.money = 0;
    }

    public Money(int money) {
        this.money = money;
    }

    public void set(int money) {
        this.money = money;
    }

    public void add(int money) {
        this.money += money;
    }

    public void subtract(int money) {
        this.money -= money;
    }
}
