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
    GameLogic game = new GameLogic(playerOne, playerTwo );

    @Test
    void testVictoryCondition() {
        playerOne.setPosition(99);

        players.takeTurn(1);

        boolean hasWon = game.checkVictory();
        assertTrue(hasWon);
    }

    @Test
    void noVictoryWhenPositionsBelow100() {
        playerOne.setPosition(50);
        playerTwo.setPosition(99);

        assertFalse(game.checkVictory());
    }
}
