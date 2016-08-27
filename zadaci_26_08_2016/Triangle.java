package zadaci_26_08_2016;

public class Triangle extends GeometricObject {
	double side1, side2, side3;
	//default konstruktor
	Triangle() {
		side1 = 1;
		side2 = 1;
		side3 = 1;
	}
	//konstruktor sa zadanim stranicama
	Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	//getteri za stranice
	double getSide1() {
		return side1;
	}
	
	double getSide2() {
		return side2;
	}
	
	double getSide3() {
		return side3;
	}
	//metoda koja vraca povrsinu trougla
	public double getArea() {
		double s = 0.5 * (side1 + side2 + side3);
		return Math.pow((s * (s - side1) * (s - side2) * (s - side3)), 0.5);
	}
	//metoda koja vraca obim trougla
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	//override metoda za ispis rezultata
	@Override
	public String toString() {
		return "Area: " + getArea() + "\nPerimeter: " + getPerimeter() + 
				"\nColor: " + getColor() + "\nFilled: " + isFilled();
	}
}
