// Workshop 3 - Task 3 
// Ilias Halemi
// 062 111 133
@SuppressWarnings("unused")

public abstract class GeometricObject implements Colorable {
	private String color = "while";
	private boolean filled; 
	private java.util.Date dateCreated;
	
	// construct default geometric object 
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	// construct a geometric object with color and filled value
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	// Return color
	public String getColor() {
		return color;
	}
	
	// Return if object is filled
	public boolean isFilled() {
		return filled;
	}
	
	// set a new filled value
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	// get the date created
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	// override toString method
	public String toString() {
		return "Created on " +dateCreated+ "\ncolor: " +color+ " and filled: " +filled;
	}
	
	// Abstract method getArea
	public abstract double getArea();
	
	// Abstract method getPerimeter
	public abstract double getPerimeter();
}
