package ch.lea.snakesandladders.src.main;

import java.util.Random;

public class GameDice implements Dice {
    final Random random;

    public GameDice() {
        this.random = new Random();
    }

    @Override
    public int roll() {
        return random.nextInt(6) + 1;
    }
}
