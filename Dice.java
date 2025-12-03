import java.util.Random;

public class Dice {
    final Random random;

    public Dice(Random random) {
        this.random = random;
    }

    int rollDice() {
        return random.nextInt(6) + 1;
    }
}
