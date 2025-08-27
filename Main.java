package guessinggame;
import java.util.*;public class Main {
    public static void main(String[] args) {
        guessinggame game = new guessinggame();  // Instantiate the game
        game.startGame();                        // Start a new game

        Scanner scanner = new Scanner(System.in);
        while (!game.checkGameOver()) {          // Run until the game is over
            System.out.print("Enter a letter to guess: ");
            char letter = scanner.next().charAt(0);
            game.guessLetter(letter);
        }
        scanner.close();
    }
}