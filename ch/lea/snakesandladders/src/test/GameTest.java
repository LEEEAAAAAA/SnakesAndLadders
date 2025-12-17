package ch.lea.snakesandladders.src.test;

import ch.lea.snakesandladders.src.main.*;
import ch.lea.snakesandladders.src.main.player.Player;
import ch.lea.snakesandladders.src.main.player.Players;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Player playerOne = new Player("Player 1");
    Player playerTwo = new Player("Player 2");
    Players players = new Players(playerOne, playerTwo);
    DieMock diceMock = new DieMock(1);
    GameLogic game = new GameLogic(playerOne, playerTwo );

    @Test
    void testVictoryCondition() {
        diceMock.setFixedValue(2);
        playerOne.setPosition(99);

        players.takeTurn();

        boolean hasWon = game.checkVictory();
        assertTrue(hasWon);
    }

    @Test
    void testDiceRollInRange() {
        Die gameDice = new Die();
        for (int i = 0; i < 500; i++) {
            int roll = gameDice.roll();
            assertTrue(roll >= 1 && roll <= 6, "Roll was out of bounds: " + roll);
        }
    }

}
