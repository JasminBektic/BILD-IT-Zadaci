package zadaci_02_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Design an interface named Colorable with a void method named howToColor(). Every class of a colorable object must implement 
	 * the Colorable interface. Design a class named Square that extends GeometricObject and implements Colorable. Implement howToColor 
	 * to display the message Color all four sides. Draw a UML diagram that involves Colorable, Square, and GeometricObject. Write a test 
	 * program that creates an array of five GeometricObjects. For each object in the array, display its area and invoke its howToColor 
	 * method if it is colorable.
	 */

public class Zadatak_4 {

	public static void main(String[] args) {
		GeometricObject[] geo = new GeometricObject[5];
		//kreiranje svih objekata
	    geo[0] = new Rectangle(2, 3);
	    geo[1] = new Circle(20);
	    geo[2] = new Square(5);
	    geo[3] = new Rectangle(10, 5);
	    geo[4] = new Circle(15);
	    
	    for (int i = 0; i < geo.length; i++) {
	    	System.out.println("shape #" + (i + 1) + " area = " + geo[i].getArea());
	        if (geo[i] instanceof Colorable) {		//ako je objekat instanca interface-a, printati
	        	System.out.println("How to color:");
	            ((Colorable)geo[i]).howToColor();
	            System.out.println();
	        }
	    }
	}
}
