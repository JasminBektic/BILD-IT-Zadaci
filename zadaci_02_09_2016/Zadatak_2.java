package zadaci_02_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Modify the GeometricObject class to implement the Comparable interface, and define a static max method in the GeometricObject 
	 * class for finding the larger of two GeometricObject objects. Draw the UML diagram and implement the new GeometricObject class. 
	 * Write a test program that uses the max method to find the larger of two circles and the larger of two rectangles.
	 */

public class Zadatak_2 {
	
	public static void main(String[] args) {
		//kreiranje objekata
		GeometricObject geo1 = new Circle(20);
		GeometricObject geo2 = new Circle(15);
		GeometricObject geo3 = new Rectangle(6, 5);
		GeometricObject geo4 = new Rectangle(9, 4);
		//ispis max objekta
		System.out.println("Max Circle: " + GeometricObject.max(geo1.getArea(), geo2.getArea()));
		System.out.print("Max Rectangle: " + GeometricObject.max(geo3.getArea(), geo4.getArea()));
	}
}