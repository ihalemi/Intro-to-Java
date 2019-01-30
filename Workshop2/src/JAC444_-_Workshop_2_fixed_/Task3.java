// Workshop 2 - Task 2
// Ilias Halemi
// 062 111 133

import java.util.Scanner;

public class Task3 {
	/* Main Method */
	public static void main(String[] args) {
		// create a Scanner object to read user input
		Scanner input = new Scanner(System.in);
		long number = 0;
		
		// validate user input
		
		System.out.println("Enter a credit card number as a long integer: ");
		
		if (input.hasNextLong()) {
			number = input.nextLong();
		}
		
		// print if valid or not
		if(isValid(number) == true) {
			System.out.println("\n" +number+ " is valid");
		} else {
			System.out.println("\n" +number+ " is invalid");
		}

	}
	
	/* Class Implementation */
	// 1. A method which should: Return true if the card number is valid
	public static boolean isValid(long number) {
		int total = addSingleDigit(number) + sumOfOddPlace(number); 
		
		if((total % 10 == 0) && (isPrefix(number, 1) == true) && (getDigits(number) >= 13) 
				&& (getDigits(number) <= 16)) {
			return true;
		} else {
			return false;
		}
	}
	
	// 2. A method which should: Get the result from Step 2 using the Luhn Check; add all the single-digit numbers 
	public static int addSingleDigit(long number) {
		int result = 0;
		long tempNumber = 0;
		
		while(number > 0) {
			tempNumber = number % 100;
			result += getSum((int) (tempNumber / 10) * 2);
			number /= 100;
		}
		return result;
	}
	
	// 3. A method which should: Return this number if it is a single digit, otherwise return the sum of the two digits
	public static int getSum(int number) {
		if (number <= 9) {
			return number;
		} else {
			int firstDigit = number % 10;
			int secondDigit = (int) (number / 10);
			
			return (firstDigit + secondDigit);
		}
	}
	
	// 4. A method which should: Return sum of odd-place digits in number
	public static int sumOfOddPlace(long number) {
		int sum = 0;
		
		while (number > 0) {
			sum += (int) (number % 10);
			number /= 100;
		}
		
		return sum;
	}
	
	// 5. A method which should: Return true if the digit is a prefix for a number
	public static boolean isPrefix(long number, int k) {
		if ((getPrefix(number, k) == 4)
				|| (getPrefix(number, k) == 5)
				|| (getPrefix(number, k) == 37)
				|| (getPrefix(number, k) == 6)) {
			return true;
		} else {
			return false;
		}
	}
	
	// 6. A method which should: Return the number of digits
	public static int getDigits(long number) {
		int digits = 0;
		
		while (number > 0) {
			number /= 10;
			digits++;
		}
		return digits;
	}
	
	// 7. A method which should: Return the first k number of digits from number. If the number of digits in number is less than k, return number.
	public static long getPrefix(long number, int k) {
		// if number is less than k, return number
		if (getDigits(number) < k) {
			return number;
		} else { // otherwise return the first k number of digits from number
			int size = (int) getDigits(number);
			
			for (int i = 0; i < (size - k); i++) {
				number /= 10;
			}
			return number;
		}
	}
}
