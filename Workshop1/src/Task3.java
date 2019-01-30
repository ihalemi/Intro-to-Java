// Workshop 1 - Task 3
// Ilias Halemi
// 062111133
import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
		// Create a new instance of Scanner to read user input
		Scanner reader = new Scanner(System.in);
		
		// Prompt user for the Loan Amount and store the input  
		System.out.print("Loan Amount: ");
		int loanAmount = reader.nextInt();
		
		// Prompt user for the Number of Years and store the input
		System.out.print("Number of Years: ");
		int numberOfYears = reader.nextInt();
		
		// Prompt the user for the Annual Interest Rate and store the input
		System.out.print("Annual Interest Rate: ");
		double annualInterestRate = reader.nextInt() / 100.0;
		
		// Close Scanner
		reader.close();
		
		// Calculate monthly interest rate
		double monthlyRate = annualInterestRate / 12.0;
		
		// Calculate monthly payment 
		double monthlyPayment = (loanAmount * monthlyRate) / (1-Math.pow(1 + monthlyRate, -12)); 
		
		// Display the monthly payment and the total payment
		System.out.printf("\n\nMonthly Payment: " +"%.2f", monthlyPayment);
		System.out.printf("\nTotal Payment: " +"%.2f", monthlyPayment * 12.0);
		
		// the balance is initially the loan amount
		double balance = loanAmount;
		
		// Table Header
		System.out.println("\n\nPayment#\tInterest\tPrincipal\tBalance");
		
		// For loop to display the table
		for (int i = 1; i <= 12; i++) {
			double interest = monthlyRate * balance;
			double principal = monthlyPayment - interest;
			balance -= principal; 
			
			// Display the table
			System.out.println(i+ "\t\t" +Math.round(interest * 100.0)/100.0+ "\t\t" +Math.round(principal*100.0)/100.0+ "\t\t" +Math.round(balance*100.0)/100.0);
		}

	}

}
