package zadaci_02_09_2016;

public class Square extends GeometricObject implements Colorable {
	public double side;
	//default konstruktor
	public Square() {
	}
	//konstruktor sa zadanom vrijednosti
	public Square(double side) {
        this.side = side;
    }
	//getter
	public double getSide() {
	    return side;
	}
	//setter
	public void setSide(double side) {
	    this.side = side;
	}
	//override metoda
	public void howToColor() {
		System.out.println("Color all four sides.");
	}

	@Override
	//override metoda za komparaciju
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	//override metoda za povrsinu
	public double getArea() {
		 return side * side;
	}

	@Override
	//override metoda za obim
	public double getPerimeter() {
		 return side * 4;
	}
}