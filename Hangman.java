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
	
		
	while (lives < lifenumber) {
	
		
		letterDisplay(thewordgiven); //activates the method letterdisplay
	
		System.out.println("\nThere are " + count + " lives left");
	
		System.out.println("Please Enter a lowercase letter: ");
	
		char input = sc.nextLine().charAt(0); // this means it will only register the first character you put in
		System.out.println("\n ---------------------");

			for (i = 0; i < randomword.length; i++) { //loops each individual character
		
		if (randomword[i]==input) { //looks if one character of the word is found in the input given
			thewordgiven[i] = input;
			count= count + 1;
			lives = lives - 1;
			break;
		
		} 
		
	}
	count--;
	lives++;
	
		if (ifWordIsCorrect(thewordgiven)) { //if the word and the word the user guessed matches then this occurs
		
			gameOver(); // calls gameOver method
			break;
	}
	
}
	
	if (count == 0) {
		
		gameOver(); 
		
	}
	
}

public static void gameOver() { //this method tells the user if he lost or won with a choice to restart or not
	Scanner two = new Scanner(System.in);
	
		if (count == 0) {
			System.out.println("You have ran out of lives");
			
		} else if (count > 0) {
			System.out.println("Congratulations you won with "+count+" lives left");
		}
		System.out.println("\nIf you want to play again Enter '1' if not Enter '0'");
		
int choice = two.nextInt();
		
		switch (choice) {
		
		case 0:
			break;
		case 1:
			count=0;
			lives=0;
			difficulty();
			break;
		}
}
	
public static boolean ifWordIsCorrect(char[] array) { //this method determines whether the _ gets replaced by its initial state (as in turns back into its letter
	for (int i = 0; i < array.length; i++ ) { 
		if (array[i]=='_') return false;
	}
	return true;
}	