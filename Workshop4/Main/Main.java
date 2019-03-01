// Ilias Halemi
// Workshop 4
// February 14th, 2019

package Main;

import java.util.List;
import java.util.Scanner;
import java.io.*;
import Task1.Hangman;
import static Task2.Task2.isLetter;
import static Task3.Phone.generateCombos;
import static Task3.Phone.returnCombos;

public class Main {
	/** Main method **/
	public static void main(String[] args) throws IOException {
		/** Task 1 **/
		Scanner input = new Scanner(System.in);
		String file = "hangman.txt";
		Hangman hangman = new Hangman(file);
		String play; // 'y' or 'n'
		
		do {
			// Generate a random word 
			char[] word = hangman.getWord();
			
			// Display each letter in the word as an asterisk.
			char[] asterisks = new char[word.length];
			hangman.fillAsterisks(asterisks);

			int missed = 0; // number of wrong guesses
			do {
				// Prompt the user to guess one letter
				char guess = hangman.getGuess(asterisks);		
				
				// Check if is letter is correct
				if (!hangman.isCorrectGuess(word, asterisks, guess))
					missed++;
					
			} while (!hangman.isWordFinish(asterisks));
			
			// Print results
			hangman.print(word, missed);
			
			// Ask the user whether to continue to play with another word
			System.out.print("\nDo you want to guess another word? Enter y or n>");
			play = input.next();

		} while (play.charAt(0) == 'y');
		
		
		/** Task 2 **/
		System.out.print("\nEnter a file name: ");
		File myFile = new File(new Scanner(System.in).next());
		String word = ""; 
		int[] letterCount = new int[26]; // 26 letters in alphabet (A belongs to index 0, B to index 1 and so forth)
		
		if(myFile.exists()) {
			
			try (Scanner sc = new Scanner(myFile)) {
				while(sc.hasNext()) {
					word = sc.nextLine();
					
					for (char ch : word.toCharArray()) {
						ch = Character.toUpperCase(ch);
						
						if (isLetter(ch)) {
							letterCount[ch - 'A']++;
						}
					}
				}
			} catch (FileNotFoundException e) {
				System.err.println(e);
			} 
		} 
		
		for (int i = 0; i < letterCount.length; i++) {
			System.out.println("Number of " +(char)(i + 'A')+ "'s: " +letterCount[i]);
		}
		
		/** Task 3 **/
		Scanner sc = new Scanner(System.in);
		String number = "";
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		System.out.print("\nEnter a seven-digit telephone number (only digits greater than 1): ");
		if(sc.hasNextLine()) {
			number = sc.nextLine();
		}
		
		List<String> combos = returnCombos(number);
		
		try {
			fw = new FileWriter("wordCombos.txt");
			bw = new BufferedWriter(fw);
			
			for (String s : combos) {
				bw.write(s + "\n");
			}
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
				if(fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				System.err.println(e);
			}	
		}
		
	} // end of main
} // end of class
