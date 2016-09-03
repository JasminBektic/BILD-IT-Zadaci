package zadaci_03_09_2016;

import zadaci_26_08_2016.GeometricObject;

public class Octagon extends GeometricObject implements Comparable, Cloneable {
	int side;
	//konstruktor sa zadanom vrijednosti
	public Octagon(int side) {
		this.side = side;
	}
	//metoda clone za kopiranje iz jednog objekta u drugi
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	//override metoda za komparaciju objekata
	@Override
	public int compareTo(Object o) {
		if (getArea() > ((Octagon)o).getArea())
			return 1;
		else if (getArea() < ((Octagon)o).getArea())
			return -1;
		else
			return 0;
	}

	//getter povrsine
	@Override
	public double getArea() {
		return (2 + 4 / Math.sqrt(2)) * side * side;
	}

	//getter obima
	@Override
	public double getPerimeter() {
		return 8 * side;
	}
}