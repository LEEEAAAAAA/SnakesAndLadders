class Game {
    private final Board board;
    private Dice dice;
    private final Player[] players;
    private int currentPlayerIndex = 0;


    public Game(Player player1, Player player2) {
        board = new Board();
        players = new Player[]{player1,player2};
    }

    public void play() {
        while (true) {
            Player currentPlayer = players[currentPlayerIndex];
            takeTurn(currentPlayer);

            if (checkVictory(currentPlayer)) {
                break;
            }

            advancePlayerTurn();
            System.out.println("---------------------------------");
        }
    }

    private void takeTurn(Player player) {
        int roll = dice.rollDice();
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



    private boolean checkVictory(Player player) {
        if (player.getPosition() >= 100) {
            System.out.println("🏆 " + player.getName() + " WINS!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Game game = new Game(new Player("Player One"), new Player("Player Two"));
        game.play();
    }
}
