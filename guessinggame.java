package guessinggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class guessinggame {
    private ArrayList<String> words;   // Stores game words
    private Queue<Character> guessedLetters; // Queue to track guesses
    private String currentWord;
    private int attempts;
    private char[] displayWord;

    public guessinggame() {
        words = new ArrayList<>();
        guessedLetters = new LinkedList<>();
        loadWords();
    }

    // Load some default words into the ArrayList
    private void loadWords() {
        words.add("java");
        words.add("computer");
        words.add("program");
        words.add("stack");
        words.add("queue");
        words.add("tree");
    }

    // Start a new game with a randomly selected word
    public void startGame() {
        currentWord = getRandomWord();
        displayWord = new char[currentWord.length()];
        Arrays.fill(displayWord, '_');
        attempts = currentWord.length() + 3; // Set attempts as word length + 3

        System.out.println("Guess the word: " + String.valueOf(displayWord));
    }

    // Randomly selects a word from the ArrayList
    private String getRandomWord() {
        Collections.shuffle(words);
        return words.get(0);
    }

    // Insert a new word to the list
    public void insertWord(String word) {
        words.add(word);
        System.out.println("Word added: " + word);
    }

    // Delete a word from the list
    public void deleteWord(String word) {
        words.remove(word);
        System.out.println("Word deleted: " + word);
    }

    // Update a word in the list
    public void updateWord(String oldWord, String newWord) {
        int index = words.indexOf(oldWord);
        if (index != -1) {
            words.set(index, newWord);
            System.out.println("Word updated from " + oldWord + " to " + newWord);
        }
    }

    // Sort the list of words alphabetically
    public void sortWords() {
        Collections.sort(words);
        System.out.println("Words sorted: " + words);
    }

    // Search for a word in the list
    public boolean searchWord(String word) {
        return words.contains(word);
    }

    // Process a player's guess
    public void guessLetter(char letter) {
        if (guessedLetters.contains(letter)) {
            System.out.println("Letter already guessed: " + letter);
            return;
        }

        guessedLetters.add(letter);

        if (currentWord.indexOf(letter) >= 0) {
            updateDisplayWord(letter);
            System.out.println("Correct guess: " + String.valueOf(displayWord));
        } else {
            attempts--;
            System.out.println("Incorrect guess. Attempts remaining: " + attempts);
        }
    }

    // Updates display word with the guessed letter
    private void updateDisplayWord(char letter) {
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) == letter) {
                displayWord[i] = letter;
            }
        }
    }

    // Checks if the player has won or lost
    public boolean checkGameOver() {
        if (String.valueOf(displayWord).equals(currentWord)) {
            System.out.println("Congratulations! You guessed the word: " + currentWord);
            return true;
        } else if (attempts <= 0) {
            System.out.println("Game over! The word was: " + currentWord);
            return true;
        }
        return false;
    }
}
