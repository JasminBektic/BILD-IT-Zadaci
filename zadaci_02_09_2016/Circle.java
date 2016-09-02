package zadaci_02_09_2016;

public class Circle extends GeometricObject implements Colorable {

	private double radius;
	//default konstruktor
	public Circle() {
	}
	//konstruktor sa zadanom vrijednosti
	public Circle(double radius) {
		this.radius = radius;
	}
	//getteri i setteri
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return radius * radius * Math.PI;
	}
	
	public double getDiameter() {
		return 2 * radius;
	}
	
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}
	//metoda za printanje
	public void printCircle() {
		System.out.println("The circle is created " + getDateCreated() + " and the radius is " + radius);
	}

	@Override
	//override metoda za komparaciju povrsina
	public int compareTo(Object o) {
		if (getArea() < ((Circle)o).getArea()) 
			return 1;
		else if (getArea() > ((Circle)o).getArea())
			return -1;
		else
			return 0;
	}
	@Override
	public void howToColor() {
		System.out.println("Color all four sides.");
	}
}