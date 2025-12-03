package ch.lea.snakesandladders.src.main;

public class Player {
    private final String name;
    private int position = 1;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int steps) {
        position += steps;
        if (position > 100) {
            position = 100;
        }
    }

    public void setPosition(int newPos) {
        position = newPos;
    }
}
