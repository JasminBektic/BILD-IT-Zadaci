package zadaci_03_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a method that sums the areas of all the geometric objects in an array. The method signature is: 
	 * public static double sumArea(GeometricObject[] a) Write a test program that creates an array of four objects 
	 * (two circles and two rectangles) and computes their total area using the sumArea method.
	 */

import zadaci_02_09_2016.GeometricObject;

public class Zadatak_4 {

	public static void main(String[] args) {
		GeometricObject[] geo = new GeometricObject[4];		//kreiranje niza od 4 objekta
		geo[0] = new Circle(3);		//unos objekta u niz
		geo[1] = new Circle(5);
		geo[2] = new Rectangle(6, 5);
		geo[3] = new Rectangle(7, 5);
		System.out.println("Total sum is: " + sumArea(geo));	//ispis sume
	}
	//metoda za sumiranje povrsina svih objekata
	public static double sumArea(GeometricObject[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i].getArea();		//dodaj sumi
		}
		return sum;
	}
}
