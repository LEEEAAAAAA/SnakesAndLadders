package ch.lea.snakesandladders.src.main;

import ch.lea.snakesandladders.src.main.player.Player;

public class Main {
     public static void main(String[] args) {
        GameLogic game = new GameLogic(
                new Player("Player One"),
                new Player("Player Two")
        );
         System.out.println("Game Started");
         System.out.println("Player One and Two start at 1");
        game.play();
    }
}
