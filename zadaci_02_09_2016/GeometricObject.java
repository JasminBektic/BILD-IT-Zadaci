package zadaci_02_09_2016;

public abstract class GeometricObject implements Comparable, Colorable {

	private String color;
	private boolean filled;
	private java.util.Date dateCreated;
	//default konstruktor
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	//geteri i setteri
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
	
	@Override
	//override metoda
	public String toString() {
		return "Created on " + dateCreated + "\nColor: " + color + " and filled " + filled;
	}
	
	//static metoda za provjeru max-a
	public static Object max(Object o1, Object o2) {
		if (((Comparable)o1).compareTo(o2) > 0)
			return "object1";
		else
			return "object2";
	}
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
	}