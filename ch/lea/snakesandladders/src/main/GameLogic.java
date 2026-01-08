package ch.lea.snakesandladders.src.main;

import ch.lea.snakesandladders.src.main.die.Dice;
import ch.lea.snakesandladders.src.main.player.Player;
import ch.lea.snakesandladders.src.main.player.Players;

public class GameLogic {
    private final Players players;

    public GameLogic(Player player1, Player player2) {
        this.players = new Players(player1, player2);
    }

    public void play(Dice dice) {
        while(true){
        int roll = dice.roll();
        players.takeTurn(roll);

        if (checkVictory()) return;
        players.nextPlayer();

        System.out.println("---------------------------------");
        }
    }

    public boolean checkVictory() {
        Player player = players.getCurrentPlayer();

        if (player.getPosition() >= 100) {
            System.out.println("🏆 " + player.getName() + " WINS!");
            return true;
        }
        return false;
    }
}
