// Workshop 1 - Task 1
// Ilias Halemi
// 062111133
import java.util.Scanner;

public class Task1 {

	// MAIN CLASS
	public static void main(String[] args) {
		// Create a new instance of Scanner to read user input
		Scanner reader = new Scanner(System.in);
		
		// Prompt user for input
		System.out.print("Enter a, b, c, d, e, f: ");
		
		// Store values 
		double a = reader.nextDouble();
		double b = reader.nextDouble();
		double c = reader.nextDouble();
		double d = reader.nextDouble();
		double e = reader.nextDouble();
		double f = reader.nextDouble();
		
		// Close Scanner
		reader.close();
		
		// Calculate using Cramer's rule for X
		double dividentForX = (e * d) - (b * f);
		double divisorForX = (a * d) - (b * c);
		double x = (dividentForX) / (divisorForX);
		
		// Calculate using Cramer's rule for Y
		double dividentForY = (a * f) - (e * c);
		double divisorForY = (a * d) - (b * c);
		double y = (dividentForY) / (divisorForY);
		
		// Display the result
		if (divisorForX != 0 || divisorForY != 0) {
			System.out.println("x is " +x+ " and y is " +y);
		} else {
			System.out.println("The equation has no solution.");
		}
	}

}
