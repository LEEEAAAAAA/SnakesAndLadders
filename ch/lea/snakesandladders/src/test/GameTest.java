package ch.lea.snakesandladders.src.test;

import ch.lea.snakesandladders.src.main.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Player p1, p2;
    DiceMock diceMock = new DiceMock(1);
    Game game = new Game(p1, p2, diceMock);

    // TEST 1 — Spielerwechsel

    @Test
    void playerTakesTurnAndAdvances(){
        diceMock.setFixedValue(2);
        Player player1 = new Player("Player");
        Player player2 = new Player("Player");

        game.takeTurn(player1);
        assertEquals(3, player1.getPosition());

        game.takeTurn(player2);
        assertEquals(3, player1.getPosition());
    }

    // TEST 2 — Siegbedingung

    @Test
    void testVictoryCondition() {
        Player p1 = new Player("Player");
        diceMock.setFixedValue(2);
        p1.setPosition(99);

        game.takeTurn(p1);

        boolean hasWon = game.checkVictory(p1);
        assertTrue(hasWon);
    }

    // TEST 3 — if Dice roll is in range

    @Test
    void testDiceRollInRange() {
        GameDice gameDice = new GameDice();
        for (int i = 0; i < 500; i++) {
            int roll = gameDice.roll();
            assertTrue(roll >= 1 && roll <= 6, "Roll was out of bounds: " + roll);
        }
    }

    // TEST 3 — if land on Ladder then Ascend
    @Test
    void landOnLadderAndAscend(){
        diceMock.setFixedValue(5);
        Player player = new Player("player");
        player.setPosition(10);

        game.takeTurn(player);

        assertEquals(26, player.getPosition());
    }

    // TEST 3 — if Snake on ladder then Descend
    @Test
    void landOnSnakeAndDescend(){
        diceMock.setFixedValue(6);
        Player player = new Player("player");
        player.setPosition(10);

        game.takeTurn(player);

        assertEquals(6, player.getPosition());
    }
}
