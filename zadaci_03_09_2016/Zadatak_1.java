package zadaci_03_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Rewrite the Circle class in Listing 13.2 to extend GeometricObject and implement the Comparable 
	 * interface. Override the equals method in the Object class. Two Circle objects are equal if their 
	 * radii are the same. Draw the UML diagram that involves Circle, GeometricObject, and Comparable.
	 */

import zadaci_02_09_2016.GeometricObject;

public class Zadatak_1 {

	public static void main(String[] args) {
		Circle c1 = new Circle(6);
		Circle c2 = new Circle(4);
		
		//provjera jednakosti
		System.out.println("Equal: " + c1.equals(c2));
		
		//provjeravamo velicinu objekata uporedjujuci povrsinu
		System.out.print("Larger is: ");
		if (c1.compareTo(c2) == 1) {
			System.out.print("Object2");
		} else if (c1.compareTo(c2) == -1) 
			System.out.print("Object1");
			else 
			  System.out.print("They are equal!");
		
		//trazimo max objekat
		System.out.println("\nMax is: " + GeometricObject.max(c1.getArea(), c2.getArea()));
	}
}
