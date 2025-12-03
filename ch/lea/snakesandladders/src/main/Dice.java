package ch.lea.snakesandladders.src.main;

import java.util.Random;

public class Dice {
    final Random random;
    public Dice() {
        this.random = new Random();
    }

    public Dice(Random random) {
        this.random = random;
    }

    public int rollDice() {
        return random.nextInt(6) + 1;
    }

}
