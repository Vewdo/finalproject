import java.util.Scanner;
import java.util.Random;

public class Hangman {

private static int count = 0;
private static int lives = 0;	
private static int lifenumber=0;
static String word;
static String theword;//allows the use of theword in wordToGuess method to be used in other methods



public static String wordsToGuess(String theword) {
	String[] wordsToGuess = {"match", "love", "harmony", "sad", "outside", "jackson", "cat", "mouse", "relax"}; //words the user must guess
	Random r = new Random(); //picks a random word from the wordsToGuess
	String words = wordsToGuess[r.nextInt(wordsToGuess.length)]; //allows the word to be chosen from the list
	
	theword = words;//references word chosen
	
	return theword;//returns the word that was chosen to other methods
}	

public static String wordChosen(String word) {
	
	String hangmanword = wordsToGuess(theword);
	word = hangmanword;
	return word;
}


