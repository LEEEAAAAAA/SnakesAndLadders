package ch.lea.snakesandladders.src.main;

public class Main {
     static void main() {
        Game game = new Game(
                new Player("Player One"),
                new Player("Player Two"),
                new GameDice()
        );
        game.play();
    }
}
