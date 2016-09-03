package zadaci_03_09_2016;

import zadaci_02_09_2016.GeometricObject;

public class Rectangle extends GeometricObject implements Comparable {

	private double width, heigth;
	//default konstruktor
	public Rectangle() {
	}
	//konstruktor za zadanim vrijednostima
	public Rectangle(double width, double heigth) {
		this.width = width;
		this.heigth = heigth;
	}
	//getteri i setteri
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeigth() {
		return heigth;
	}
	
	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}
	
	public double getArea() {
		return width * heigth;
	}
	
	public double getPerimeter() {
		return 2 * (width + heigth);
	}

	@Override
	//override metoda za komparaciju povrsina
	public int compareTo(Object o) {
		if (getArea() < ((Rectangle)o).getArea()) 
			return 1;
		else if (getArea() > ((Rectangle)o).getArea())
			return -1;
		else
			return 0;
	}
	//metoda za provjeru jednakosti
	public boolean equal(Object o) {
		return (this.getArea() == ((Rectangle)o).getArea()) ? true : false;
	}
	
	@Override
	public void howToColor() {
		System.out.println("Color all four sides.");
	}
}