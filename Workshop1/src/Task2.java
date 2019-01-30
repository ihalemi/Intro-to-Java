// Workshop 1 - Task 2
// Ilias Halemi
// 062111133

import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
		// Create a new instance of Scanner to read user input
		Scanner reader = new Scanner(System.in);
		
		// Prompt user for year input 
		System.out.print("Enter year (i.e. 2019): "); 
		
		int year = reader.nextInt();
		int j = year / 100; // j is the century 
		int k = year % 100; // k is the year of the century 
		
		// Prompt user for month input
		System.out.print("Enter month (1-12): ");
		
		int m = reader.nextInt(); // m is the month 
		
		// Month validation 
		if (m == 1) {
			// the month of January becomes 13 of the previous year
			m = 13;
			year -= 1;
			
			j = year / 100; 
			k = year % 100; 
		} else if (m == 2) {
			// the month of February becomes 14 of the previous year 
			m = 14; 
			year -= 1;
			
			j = year / 100; 
			k = year % 100;
		} else {
			
		}
		
		// Prompt the user for the day of the month 
		System.out.print("Enter the day of the month (1-31): ");
		
		int q = reader.nextInt(); // q is the day of the month 
		
		// close Scanner
		reader.close();
		
		// Calculate day of the week using Zeller's algorithm
		int h = (q + (26 * (m + 1) / (10)) + k + (k/4) + (j/4) + (5*j)) % 7; 
		
		// Assign names of each day based on the value of 'h'
		String dayOfTheWeek = ""; 
		
		switch(h) {
			case 0:	dayOfTheWeek = "Saturday";
					break;
			case 1: dayOfTheWeek = "Sunday";
					break;
			case 2: dayOfTheWeek = "Monday"; 
					break;
			case 3: dayOfTheWeek = "Tuesday"; 
					break;
			case 4: dayOfTheWeek = "Wednesday";
					break;
			case 5: dayOfTheWeek = "Thursday"; 
					break;
			case 6: dayOfTheWeek = "Friday"; 
					break; 
			default: break;
		}
		
		// Display day of the week based on calculation
		System.out.println("Day of the week is " +dayOfTheWeek); 
		
	}

}
