package ch.lea.snakesandladders.src.test;

import ch.lea.snakesandladders.src.main.die.Die;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DieTest {
    @Test
    void testDiceRollInRange() {
        Die gameDice = new Die();
        for (int i = 0; i < 500; i++) {
            int roll = gameDice.roll();
            assertTrue(roll >= 1 && roll <= 6, "Roll was out of bounds: " + roll);
        }
    }
}