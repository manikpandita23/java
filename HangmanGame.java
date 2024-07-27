import java.util.Scanner;
import java.util.Random;

public class HangmanGame {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        hangman();
    }

    public static void hangman() {
        String[] company = { "Maruti", "Tata", "Suzuki", "Ducati", "Toyota" };
        System.out.println("Welcome to HANGMAN GAME");

        Random random = new Random();
        String word = company[random.nextInt(company.length)].toUpperCase();
        String wordDisplay = word.replaceAll("[A-Z]", "_ ");

        System.out.println("Let's play the game");
        startGame(word, wordDisplay);
    }

    public static void startGame(String word, String wordDisplay) {
        int totalGuesses = 5;
        int wrongGuesses = 0;
        String guessedLetters = "";
        String guess;
        char letter;

        while (wrongGuesses < totalGuesses && wordDisplay.contains("_")) {
            System.out.println(wordDisplay + "\n");
            int remainingGuesses = totalGuesses - wrongGuesses;

            if (wrongGuesses != 0) {
                System.out.println("You have " + remainingGuesses + " guesses left.");
            }

            System.out.print("Your Guess: ");
            guess = input.nextLine().toUpperCase();
            letter = guess.charAt(0);

            if (guessedLetters.contains(String.valueOf(letter))) {
                System.out.println("You ALREADY guessed " + letter + ". \n");
                continue;
            }

            guessedLetters += letter;
            System.out.println();

            if (word.indexOf(letter) != -1) {
                System.out.println(letter + " is present in the word.");
                System.out.print("\n");

                // Create a new display string with the guessed letter revealed
                StringBuilder newDisplay = new StringBuilder(wordDisplay.replaceAll(" ", ""));
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter) {
                        newDisplay.setCharAt(i, letter);
                    }
                }
                wordDisplay = newDisplay.toString().replaceAll("", " ").trim();
            } else {
                System.out.println(letter + " is not present in the word.");
                wrongGuesses++;
            }
        }

        if (wrongGuesses == totalGuesses) {
            System.out.println("YOU LOST! Maximum limit of incorrect guesses reached.");
        } else {
            System.out.println("The word is: " + wordDisplay + "\nWell Played, you did it!!");
        }
    }
}
