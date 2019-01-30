// Workshop 3 - Task 3 
// Ilias Halemi
// 062 111 133
@SuppressWarnings("unused")

public class Square extends GeometricObject implements Colorable {
	private double side;
	
	public Square() {
	}
	
	public Square(double side) {
		this.side = side;
	}
	
	public Square(double side, String color, boolean filled) {
		// call GeometricObject superclass constructor
		super(color, filled);
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}
	
	// implement inherited abstract methods from GeometricObject
	public double getArea() {
		return Math.pow(side, 2);
	}
	
	public double getPerimeter() {
		return side * 4;
	}
	
	// implement howToColor to display the message "Color all four side"
	public String howToColor() {
		return "Color all four sides";
	}
	
	public String toString() {
		return super.toString()+ "\nSide: " +side+ "\nArea: " +getArea();
	}

}



