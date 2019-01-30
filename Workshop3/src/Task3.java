// Workshop 3 - Task 3 
// Ilias Halemi
// 062 111 133

public class Task3 {
	public static void main(String[] args) {
		// Create an array of five GeometricObjects
		GeometricObject[] squares = {new Square(4.5), new Square(14), 
				new Square(8.2), new Square(12), new Square(10)};
		
		// Display the area and invoke the howToColor method if its colorable
		for (int i = 0; i < squares.length; i++) {
			System.out.println("\nSquare #" +(i + 1));
			System.out.println("Area: " +squares[i].getArea());
			System.out.println("How to color: " +squares[i].howToColor());
		}
	}

}
