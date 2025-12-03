package ch.lea.snakesandladders.src.test;

import ch.lea.snakesandladders.src.main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Player p1, p2;
    Game game;

    @BeforeEach
    void setup() {
        p1 = new Player("Alice");
        p2 = new Player("Bob");
        game = new Game(p1, p2);
    }

    private Board getBoard() throws Exception {
        Field boardField = Game.class.getDeclaredField("board");
        boardField.setAccessible(true);
        return (Board) boardField.get(game);
    }

    // TEST 1 — Spielerwechsel
    @Test
    void testPlayerTurnAdvances() throws Exception {
        Field fIdx = Game.class.getDeclaredField("currentPlayerIndex");
        fIdx.setAccessible(true);

        Method advance = Game.class.getDeclaredMethod("advancePlayerTurn");
        advance.setAccessible(true);

        assertEquals(0, fIdx.getInt(game));

        advance.invoke(game);
        assertEquals(1, fIdx.getInt(game));

        advance.invoke(game);
        assertEquals(0, fIdx.getInt(game));
    }

    // TEST 2 — Siegbedingung
    @Test
    void testVictoryCondition() throws Exception {
        Method check = Game.class.getDeclaredMethod("checkVictory", Player.class);
        check.setAccessible(true);

        p1.setPosition(99);
        assertFalse((boolean) check.invoke(game, p1));

        p1.setPosition(100);
        assertTrue((boolean) check.invoke(game, p1));
    }

    // TEST 3 — if Dice roll is in range

    @Test
    void testDiceRollInRange() {
        Dice dice = new Dice();

        for (int i = 0; i < 500; i++) {
            int roll = dice.rollDice();
            assertTrue(roll >= 1 && roll <= 6, "Roll was out of bounds: " + roll);
        }
    }

}
