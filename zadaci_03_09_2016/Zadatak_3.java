package zadaci_03_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a class named Octagon that extends GeometricObject and implements the Comparable and Cloneable interfaces. Assume that all eight 
	 * sides of the octagon are of equal length. The area can be computed using the following formula: area = (2 + 4/22)* side * side Draw the UML 
	 * diagram that involves Octagon, GeometricObject, Comparable, and Cloneable. Write a test program that creates an Octagon object with side 
	 * value 5 and displays its area and perimeter. Create a new object using the clone method and compare the two objects using the compareTo method.
	 */

public class Zadatak_3 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Octagon octagon1 = new Octagon(5);
		Octagon octagon2 = (Octagon)octagon1.clone();	//kopiranje objekta1
		
		//vrijednosti objekta1, ujedno i vrijednost objekta2
		System.out.println("Object1 values...");
		System.out.println("Area: " + octagon1.getArea());
		System.out.println("Perimeter: " + octagon1.getPerimeter());
	
		//komparacija dva objekta
		System.out.println("\nComparing Object1 and cloneable one...");
		switch (octagon1.compareTo(octagon2)) {
			case -1: System.out.print("Object2 is max"); break;
			case  0: System.out.print("Objects are of the same value"); break;
			case  1: System.out.print("Object1 is max"); break;
		}
	}
}