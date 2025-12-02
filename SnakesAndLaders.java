import java.util.Random;

class Game {
    private final Board board;
    private final Player[] players;
    private int currentPlayerIndex = 0;
    private final Random random;

    public Game(String player1Name, String player2Name) {
        board = new Board();
        players = new Player[]{new Player(player1Name), new Player(player2Name)};
        random = new Random();
    }

    public void play() {
        while (true) {
            Player currentPlayer = players[currentPlayerIndex];
            takeTurn(currentPlayer);

            if (checkVictory(currentPlayer)) {
                break;
            }

            advancePlayerTurn();
            printTurnSeparator();
        }
    }

    private void takeTurn(Player player) {
        int roll = rollDice();
        System.out.println(player.getName() + " rolled " + roll);

        player.move(roll);

        int oldPosition = player.getPosition();
        int newPosition = board.applyMove(oldPosition);
        player.setPosition(newPosition);

        reportBoardEffect(player, oldPosition, newPosition);
        System.out.println(player.getName() + " is on " + newPosition);
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
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length; // 0 -1 1-2 2-3 3-0 Cycles!!
    }

    private void printTurnSeparator() {
        System.out.println("---------------------------------");
    }


    private int rollDice() {
        return random.nextInt(6) + 1;
    }

    private boolean checkVictory(Player player) {
        if (player.getPosition() >= 100) {
            System.out.println("🏆 " + player.getName() + " WINS!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Game game = new Game("Alice", "Bob");
        game.play();
    }
}
