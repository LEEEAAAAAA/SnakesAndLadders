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
    DieMock diceMock = new DieMock(0);

    @Test
    void playerOneWins(){
        playerOne.setPosition(88);
        playerTwo.setPosition(0);
        diceMock.setFixedValue(6);

        game.play(diceMock);

        assertTrue(game.checkVictory());
    }

    @Test
    void playerTwoWins(){
        playerOne.setPosition(0);
        playerTwo.setPosition(70);
        diceMock.setFixedValue(3);

        game.play(diceMock);

        assertTrue(game.checkVictory());
    }


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
