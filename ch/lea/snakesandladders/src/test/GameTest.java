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
    // TEST 1 — Spielerwechsel
    @Test
    void playerTakesTurnAndAdvances(){
        Board board = new Board();

        Dice dice = new DiceMock(2);
        Player player1 = new Player("Player");
        Player player2 = new Player("Player");

        game.takeTurn(player1, dice);
        assertEquals(3, player1.getPosition());


        game.takeTurn(player2, dice);
        assertEquals(3, player1.getPosition());
    }


    // TEST 2 — Siegbedingung

    @Test
    void testVictoryCondition() {
        Dice dice = new DiceMock(1);
        p1.setPosition(99);

        game.takeTurn(p1, dice);

        boolean hasWon = game.checkVictory(p1);
        assertTrue(hasWon);
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

    // TEST 3 — if land on Ladder then Ascend
    @Test
    void landOnLadderAndAscend(){
        Dice dice = new DiceMock(5);
        Player player = new Player("player");
        player.setPosition(10);

        game.takeTurn(player, dice);

        assertEquals(26, player.getPosition());
    }

    // TEST 3 — if Snake on ladder then Descend
    @Test
    void landOnSnakeAndDescend(){
        Dice dice = new DiceMock(6);
        Player player = new Player("player");
        player.setPosition(10);

        game.takeTurn(player, dice);

        assertEquals(6, player.getPosition());
    }
}
