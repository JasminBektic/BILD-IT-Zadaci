package zadaci_03_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Rewrite the Rectangle class in Listing 13.3 to extend GeometricObject and implement the Comparable 
	 * interface. Override the equals method in the Object class. Two Rectangle objects are equal if their 
	 * areas are the same. Draw the UML diagram that involves Rectangle, GeometricObject, and Comparable.
	 */

import zadaci_02_09_2016.GeometricObject;

public class Zadatak_2 {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(6, 4);
		Rectangle r2 = new Rectangle(6, 5);
		
		//provjera jednakosti
		System.out.println("Equal: " + r1.equals(r2));
		
		//provjeravamo velicinu objekata uporedjujuci povrsinu
		System.out.print("Larger is: ");
		if (r1.compareTo(r2) == 1) {
			System.out.print("Object2");
		} else if (r1.compareTo(r2) == -1) 
			System.out.print("Object1");
			else 
			  System.out.print("They are equal!");
		
		//trazimo max objekat
		System.out.println("\nMax is: " + GeometricObject.max(r1.getArea(), r2.getArea()));
	}
}
