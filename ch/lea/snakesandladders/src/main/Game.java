package ch.lea.snakesandladders.src.main;

public class Game {
    private final Board board;
    private Dice dice;
    private final Player[] players;
    private int currentPlayerIndex = 0;

    public Game(Player player1, Player player2) {
        this(player1, player2, new Dice());
    }

    public Game(Player player1, Player player2, Dice dice) {
        this.board = new Board();
        this.players = new Player[]{player1, player2};
        this.dice = dice;
    }

    public void play() {
        while (true) {
            Player currentPlayer = players[currentPlayerIndex];
            takeTurn(currentPlayer, dice);

            if (checkVictory(currentPlayer)) {
                break;
            }

            advancePlayerTurn();
            System.out.println("---------------------------------");
        }
    }
    //todo: ask Thomas how to test private Methods

     public void takeTurn(Player player, Dice dice) {
        int roll = dice.rollDice();
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
        System.out.println(
                player.getName() +
                        " hit a " + event +
                        " → now on " + after
        );
    }

    private void advancePlayerTurn() {
        currentPlayerIndex =
                (currentPlayerIndex + 1) % players.length;
    }


    public static void main(String[] args) {
        Game game = new Game(new Player("Player One"), new Player("Player Two"));
        game.play();
    }
}
