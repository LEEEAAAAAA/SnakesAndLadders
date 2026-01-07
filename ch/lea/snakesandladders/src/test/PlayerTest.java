package ch.lea.snakesandladders.src.test;

import ch.lea.snakesandladders.src.main.player.Player;
import ch.lea.snakesandladders.src.main.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player playerOne;
    Player playerTwo;
    Players players;

    @BeforeEach
    void setUp() {
        playerOne = new Player("Player 1");
        playerTwo = new Player("Player 2");
        players = new Players(playerOne, playerTwo);
    }

    @Test
    void playerTakesTurnAndAdvances() {
        Players players = new Players(playerOne, playerTwo);

        players.takeTurn(2);
        players.nextPlayer();
        players.takeTurn(2);

        assertEquals(3, playerOne.getPosition());
        assertEquals(3, playerTwo.getPosition());
    }


    @Test
    void landOnLadderAndAscend() {
        playerOne.setPosition(10);

        players.takeTurn(5);

        assertEquals(26, playerOne.getPosition());
    }

    @Test
    void landOnSnakeAndDescend() {
        playerOne.setPosition(10);

        players.takeTurn(6);

        assertEquals(6, playerOne.getPosition());
    }

    @Test
    void exactRollTo100() {
        playerOne.setPosition(97);

        playerOne.movePlayerPosition(3);

        assertEquals(100, playerOne.getPosition());
    }

    @Test
    void bounceBackFrom100() {
        playerOne.setPosition(98);

        playerOne.movePlayerPosition(5);

        assertEquals(97, playerOne.getPosition());
    }
}
