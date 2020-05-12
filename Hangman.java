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

public static void main(String[] args) { //method that runs the program in order

	System.out.println("Hangman By Jordano Anoia");
	attemps();	
	
	}

public static void attemps() {
		
		Scanner sc = new Scanner (System.in);
		
		char[] randomword = wordChosen(word).toCharArray(); //turns the word from the wordChosen method into a chat and allows the char to access its array
		int amountOfLetters = randomword.length; //turns the length of the word into an amount (integer)
		char[] thewordgiven = new char[amountOfLetters]; //uses the amount of letters in the word as i 
			
		
		for (int i = 0; i<thewordgiven.length; i++) { //loops until every i (each letter) is replaced
			thewordgiven[i]='_'; //replaces each letter in the word with "_" 
		}
		