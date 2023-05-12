/**
 * Game.java
 * Runs the Hangman Game in Command Line
 *
 * @author	Thet Zin
 * @version	0.0.1
 * @since	10/02/2023
 */


package HangMan;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		
		//Assign a list of words for random generation
		String AllWords [] = {"GIRAFFE", "KEYBOARD", "CROCODILE", "BILLIONAIRE",
				"COMPUTER", "LAPTOP", "POLYMORPHISM", "MODULATION", "QUESTION"};
		
		//Assigning number of guess allowed
		int guesses = 8;
		
		//Generate a random word from the list
		Random random = new Random();
		int randomIndex = random.nextInt(AllWords.length);
		String wordToGuess = AllWords[randomIndex];
		
		//Convert the random word from string to char Array
		char[] charsToGuess = wordToGuess.toCharArray();
		
		//Welcome Message
		String welcomMessage = "Welcome To HangMan!";
		System.out.println(welcomMessage);
		
		//Displaying Initial Dashes
		String displayString = "";
		for (int i = 0; i < wordToGuess.length(); i++) {
			displayString += "-";
		}
	
		//Initialize an arraylist to store the letters the user has guessed
		ArrayList<Character> guessedLetterList = new ArrayList<>();
		
		//Game Starts
		boolean win = false;
		
		//game will go until 0 guess left
		while (guesses != 0) {
			
			//Showing the word with dashes
			System.out.println("The word now looks like this : " + displayString);
			System.out.println("You have " + guesses + " guesses left.");
			
			
			//Get user input and convert to upper case
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.print("Your guess : ");
	        char userInput =  Character.toUpperCase(scan.next().charAt(0));
	        
	        
	        //user input letter will be stored only when it does not exist in the arraylist
	        if (guessedLetterList.contains(userInput)){
	        	System.out.println("You have aleady guessed " + userInput);
	        	
	        	//If user put letter already in the guessed letters, this iteration will be skipped.
	        	continue;
	        	}
	        else {
	        		guessedLetterList.add(userInput);
	        	}		
			
			
			//Look for input char in  the word which is now char array
	        boolean guessCorrect = false;
	        
	        //look for a match with user input character in the word, get index and replaced on displayString
			for (int i = 0; i < charsToGuess.length; i ++) {
				if (charsToGuess[i] == userInput) {
					guessCorrect = true;
					
					//dash from display string is replaced with correctly guessed letters
					displayString = displayString.substring(0, i) + userInput + displayString.substring(i + 1);
					}	
			}
			if (guessCorrect) {
				System.out.println("That guess is correct.");
				}
			else {
				guesses --;
				System.out.println("There is no " + userInput + "'s in the word.");
				
				if (guesses == 1) {
					System.out.println("You have only one guess left.");
					} 
			}
			
			System.out.println("You have guessed : " + guessedLetterList);
					
			//Checking if all the words are guessed correctly (if there are no more dash in the display word)
			if (displayString.indexOf("-") == -1) {
			    win = true;
			    
			  //Print massage for win
			    System.out.println("You guess the word : " + wordToGuess);
			    System.out.println("You win.");
			    break;
			    }
		} 
		//Print massage for lose
		if (win != true) {
			System.out.println("You are completely hung.");
			System.out.println("The word was : " + wordToGuess);
			System.out.println("You lose.");}
		
	}
		   		
}