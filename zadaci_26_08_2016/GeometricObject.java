package zadaci_26_08_2016;

public abstract class GeometricObject {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	//konstruktor
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	//getteri i setteri
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	//metoda za ispis vrijednosti
	@Override
	public String toString() {
		return "Created on " + dateCreated + "\nColor: " + color + " and filled " + filled;
	}
	//abstraktne metode za obim i povrsinu
	public abstract double getArea();
	
	public abstract double getPerimeter();
}
