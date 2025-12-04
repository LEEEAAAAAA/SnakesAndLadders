package ch.lea.snakesandladders.src.main;

public class Game {
    private final Board board;
    private final Dice dice;
    private final Players players;

    public Game(Player player1, Player player2, Dice dice) {
        this.board = new Board();
        this.players = new Players(player1, player2);
        this.dice = dice;

    }

    public void play() {
        while (true) {
            Player currentPlayer = players.getCurrentPlayer();
            takeTurn(currentPlayer);

            if (checkVictory(currentPlayer)) break;

            players.nextPlayer();
            System.out.println("---------------------------------");
        }
    }

    public void takeTurn(Player player) {
        int roll = dice.roll();
        System.out.println(player.getName() + " rolled " + roll);

        player.move(roll);

        int oldPosition = player.getPosition();
        int newPosition = board.applyMove(oldPosition);
        player.setPosition(newPosition);

        reportBoardEffect(player, oldPosition, newPosition);
        System.out.println(player.getName() + " is on " + newPosition);
    }

    public boolean checkVictory(Player player) {
        if (player.getPosition() >= 100) {
            System.out.println("🏆 " + player.getName() + " WINS!");
            return true;
        }
        return false;
    }

    private void reportBoardEffect(Player player, int before, int after) {
        if (before == after) return;

        String event = after < before ? "snake!" : "ladder!";
        System.out.println(player.getName() + " hit a " + event + " → now on " + after);
    }

}
