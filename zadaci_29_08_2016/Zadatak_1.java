package zadaci_29_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * A polygon is convex if it contains any line segments that connects two points of the polygon. Write a program 
	 * that prompts the user to enter the number of points in a convex polygon, then enter the points clockwise, and display 
	 * the area of the polygon.
	 */

import java.util.Scanner;

public class Zadatak_1 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the number of the points:");
		int points = (int) check();
		double[] x = new double[points];
		double[] y = new double[points];
		System.out.println("Enter the coordinates of the points:");
		for (int i = 0; i < points; i++) {
			x[i] = check();			//unos x koordinata
			y[i] = check();			//unos y koordinata
		}
		double sum1 = 0;
		double sum2 = 0;
		for (int i = 0; i < points - 1; i++) {
			sum1 += x[i] * y[i + 1];			//sumiramo brojeve po formuli
			sum2 += y[i] * x[i + 1];
		}
		sum1 += x[points - 1] * y[0];			//sumi dodajemo zadnji * prvi
		sum2 += y[points - 1] * x[0];
		
		double area = Math.abs((sum1 - sum2) / 2);
		System.out.println("The total area is: " + area);				//ispis rezultata
	}
	//metoda za provjeru unosa
	public static double check() {
		double num = 0;
		while (true) {
			try {
				num = input.nextDouble();	//unos
				break;
			}
			catch (Exception e) {		//hvatanje greske
				System.out.println("Wrong input, try again:");
				input.nextLine();
			}
		}
		return num;
	}
}
