package ch.lea.snakesandladders.src.main;

public class Players {
    private final Player player1;
    private final Player player2;
    private int currentPlayer= 0;

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

}