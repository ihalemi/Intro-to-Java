// Workshop 3 - Task 1
// Ilias Halemi
// 062 111 133

import java.util.Scanner;

public class Complex implements Cloneable {

	/* Main Method */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = 0, b = 0, c = 0, d = 0;
		
		System.out.print("Enter the first complex number: ");
		if (sc.hasNextDouble()) {
			a = sc.nextDouble();
			b = sc.nextDouble();
		}
		
		Complex complexNumber1 = new Complex(a, b);
		
		System.out.println("Enter the second complex number: ");
		if (sc.hasNextDouble()) {
			c = sc.nextDouble();
			d = sc.nextDouble();
		}
		
		Complex complexNumber2 = new Complex(c, d);
		
		// display the addition, subtraction, multiplication, division and absolute value of complex numbers
		System.out.println(complexNumber1 + " + " +complexNumber2+ " = " +complexNumber1.add(complexNumber2));
		System.out.println(complexNumber1 + " - " +complexNumber2+ " = " +complexNumber1.subtract(complexNumber2));
		System.out.println(complexNumber1 + " * " +complexNumber2+ " = " +complexNumber1.multiply(complexNumber2));
		System.out.println(complexNumber1 + " / " +complexNumber2+ " = " +complexNumber1.divide(complexNumber2));
		System.out.println("|" + complexNumber1 + "| = " +complexNumber1.abs());

	}
	
	/* Class Implementation */
	private double a;
	private double b;
	
	// Constructors
	public Complex() {
		this(0.0, 0.0);
	}
	
	public Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public Complex(double a) {
		this(a, 0.0);
	}
	
	// Getters
	public double getRealPart() {
		return a;
	}
	
	public double getImaginaryPart() {
		return b;
	}
	
	// Methods
	public Complex add(Complex c2) {
		return new Complex(a + c2.a, b + c2.b);
	}
	
	public Complex subtract(Complex c2) {
		return new Complex(a - c2.a, b - c2.b);
	}
	
	public Complex multiply(Complex c2) {
		return new Complex(a * c2.a - b * c2.b, b * c2.a + a * c2.b);
	}
	
	public Complex divide(Complex c2) {
		return new Complex((a * c2.a + b * c2.b) /
				(Math.pow(c2.a, 2) + Math.pow(c2.b, 2)),
				(b * c2.a - a * c2.b) /
				(Math.pow(c2.a, 2) +  Math.pow(c2.b, 2)));
	}
	
	public double abs() {
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}
	
	// Cloneable Interface
	public Complex clone() throws CloneNotSupportedException {
		return (Complex)super.clone();
	}
	
	// Override toString method
	public String toString() {
		return b == 0 ? a + "" : + a + " + " + b +"i";
	}
}
