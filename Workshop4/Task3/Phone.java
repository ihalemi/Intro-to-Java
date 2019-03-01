// Ilias Halemi
// Workshop 4
// February 14th, 2019

package Task3;

import java.util.List;
import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;

public class Phone {
	
	public static final String[][] letters = { 
			{"0"}, {"1"}, { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" }, 
			{ "J", "K", "L" }, { "M", "N", "O" }, { "P", "R", "S" }, 
			{ "T", "U", "V" }, { "W", "X", "Y" } };
	
	public static void generateCombos(List<String> combos, String prefix, String number) {
		// current digit we are working with 
		int digit = Integer.parseInt(number.substring(0, 1));
		
		if (digit > 1) {
			if (number.length() == 1) {
				// we have reached the last digit of the phone number
				for(int i = 0; i < letters[digit].length; i++) {
					combos.add(prefix + letters[digit][i]);
				}
			} else {
				// recursively call this method with each new possible combination and
				// the remaining digits of the phone number
				for(int i = 0; i < letters[digit].length; i++) {
					generateCombos(combos, prefix + letters[digit][i], number.substring(1));
				}
			}
		} else {
			System.out.println("Please enter digits greater than 1.");
		}
	}
	
	public static List<String> returnCombos(String phoneNumber) {
		// this will hold the final list of combinations 
		List<String> combos = new LinkedList<String>();
		
		generateCombos(combos, "", phoneNumber);
		return combos;
	}
	
}
