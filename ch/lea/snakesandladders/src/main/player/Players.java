package ch.lea.snakesandladders.src.main.player;

import ch.lea.snakesandladders.src.main.Board;
import ch.lea.snakesandladders.src.main.fields.Field;

public class Players {
    private final Player player1;
    private final Player player2;
    private int currentPlayer = 0;

    Board board = new Board();

    public Players(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer == 0 ? player1 : player2;
    }

    public void nextPlayer() {
        currentPlayer = (currentPlayer + 1) % 2;
    }

    public void takeTurn(int roll ) {
        Player player = getCurrentPlayer();

        System.out.println(player.getName() + " rolled " + roll);

        player.movePlayerPosition(roll);
        player.setPosition(executeTransition(player.getPosition()));

        System.out.println(player.getName() + " is on " + player.getPosition());
    }

    public int executeTransition(int position) {
        for (Field field : board.transitions) {
            if (field.getStart() == position) {
                int end = field.getEnd();
                System.out.println(" hit a " + (end < position ? "snake!" : "ladder!") + " → now on " + end);
                return end;
            }
        }
        return position;
    }

}
