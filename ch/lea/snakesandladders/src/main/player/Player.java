package ch.lea.snakesandladders.src.main.player;

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

    public void movePlayerPosition(int steps) {
        int newPosition = position + steps;

        if (newPosition > 100) {
            int overflow = newPosition - 100;
            position = 100 - overflow;
        } else {
            position = newPosition;
        }
    }

    public void setPosition(int newPos) {
        position = newPos;
    }
}
