// Ilias Halemi
// Workshop 4
// February 14th, 2019

package Task1;

import java.util.Scanner;
import java.io.*;

public class Hangman {
	public String FILENAME;
	
	public Hangman(String Filename) {
		this.FILENAME = Filename;
	}
	
	/* getWord randomly generates a word from a list */
	public char[] getWord() {
		String[] words = null;
		BufferedReader br = null;
		
		try {
			// read words from file and store in String Array
			br = new BufferedReader(new FileReader(FILENAME));
			String line;
			
			while((line = br.readLine()) != null) {
				words = line.split(" ");
				}
		} catch(IOException e) {
			System.err.println(e);
		} finally {
			try {
				if(br != null) 
					br.close();
			} catch (IOException e) {
				System.err.println(e);
			}
		}
		
		// generate a random index to pick a random word to guess 
		String pick = words[(int)(Math.random() * words.length)];
		char[] word = new char[pick.length()];

		for (int i = 0; i < word.length; i++) {
			word[i] = pick.charAt(i);
		}
		return word;
	}

	/** fillAsterisks initializes a list with asterisks */
	public void fillAsterisks(char[] list) {
		for (int i = 0; i < list.length; i++) {
			list[i] = '*';
		}
	}

	/** checkGuess tests if the users guess was correct */
	public boolean isCorrectGuess(char[] word, char[] blanks, char guess) {
		boolean correct = false;
		int message = 2;
		for (int i = 0; i < word.length; i++) {
			if (word[i] == guess) {
				correct = true;
				if (blanks[i] == guess)
					message = 1;
				else { 
					blanks[i] = guess; // the actual letter is then displayed.
					message = 0;
				}
			}
		}
		if (message > 0)
			print(message, guess);
		return correct;
	}

	/** isWordFinish checks if there are asterisks remaining meaning there are still letters to be guessed or if there none then the word has been guessed */
	public boolean isWordFinish(char[] blanks) {
		for (char e: blanks) {
			if (e == '*')
				return false;
		}
		return true;
	}

	/** print overloaded */
	public void print(char[] word, int missed) {
		System.out.print("\nThe word is ");
		System.out.print(word);
		System.out.println(". You missed " + missed + " times");
	}

	/** print overloaded */
	public void print(int m, char guess) {
		System.out.print("\t" + guess);
		switch (m) {
			case 1 : System.out.println(" is already in the word"); 
					 break;
			case 2 : System.out.println(" is not in the word");
		}
	}

	/** getGuess prompts the user to guess one letter at a time */
	public char getGuess(char[] asterisks){
		Scanner input = new Scanner(System.in);
	
		System.out.print("(Guess) Enter a letter in word ");
		System.out.print(asterisks);
		System.out.print(" > ");
		
		char c = input.next().charAt(0);
		return c;
	}
	
}
