// Workshop 2 - Task 2
// Ilias Halemi
// 062 111 133

import java.util.Scanner;


public class Location {
	/* Main Method */
	public static void main(String[] args) {
		// Create a Scanner object to read user input
		Scanner input = new Scanner(System.in);
		int row = 0; int column = 0;
		
		// Prompt user for the number of rows and columns
		System.out.print("Enter the number of rows and columns in the array: ");
		
		// validate user input
		if (input.hasNextInt()) { 
			row = input.nextInt();
			column = input.nextInt();
		}
		
		// Create a two-dimensional array with given size for rows and columns
		double[][] array = new double[row][column];
		
		// Fill the array with user-inputed values
		System.out.println("Enter the array: ");
		for(int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = input.nextDouble();
			}
		}
		
		// Locate the largest element in the array
		// Display its value and location
		locateLargest(array);

	}
	
	/* Location Class */
	// Data Fields
	public double row, column, maxValue;
	public double[][] array;
	
	// Constructor to construct our Location object 
	public Location(double[][] arr) {
		this.array = new double[(int)(arr.length)][(int)(arr[0].length)];
		array = arr;
	}
	
	// Method that returns the location of the largest element in the two-dimensional array 
	// the return value is an instance of Location 
	public static Location locateLargest(double[][] a) {
		// create a new instance of Location with our constructor
		Location location = new Location(a);
		
		// assign the value of the first element to maxValue to compare 
		double maxVal = location.array[0][0];
		
		for (int i = 0; i < location.array.length; i++) {
			for (int j = 0; j < location.array[i].length; j++) {
				if (location.array[i][j] > maxVal) {
					maxVal = location.array[i][j];
					location.maxValue = location.array[i][j];
					location.row = i;
					location.column = j;
				}
			}
		}
		
		// Display the largest value in the two-dimensional array and what position 
		System.out.printf("The location of the largest element is " +(int)location.maxValue+ " at (" +(int)location.row+
				", " +(int)location.column+ ")");
		
		return location;
	}
}
