package zadaci_22_08_2016;

	/*
	 * Suppose two line segments intersect. The two endpoints for the first line segment are (x1, y1) and (x2, y2) and for the second line segment 
	 * are (x3, y3) and (x4, y4). Write a program that prompts the user to enter these four endpoints and displays the intersecting point. 
	 * The intersecting point can be found by solving a linear equation.
	 */

import java.util.Scanner;

public class Z5_IntersectingPoint {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		//unos koordinata
		System.out.println("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
		double x1 = check();
		double y1 = check();
		double x2 = check();
		double y2 = check();
		double x3 = check();
		double y3 = check();
		double x4 = check();
		double y4 = check();
		
		//izdvojene varijable za kreiranje sistema
		double a = y1 - y2;
		double b = - (x1 - x2);
		double c = y3 - y4;
		double d = - (x3 - x4);
		double e = (y1 - y2) * x1 - (x1 - x2) * y1;
		double f = (y3 - y4) * x3 - (x3 - x4) * y3;
		
		Z4_LinearEquation eq = new Z4_LinearEquation(a, b, c, d, e, f);
		if (eq.isSolvable())
			//ispis tacke gdje se dvije linije sjeku ili ispis ako su paralelne
			System.out.printf("The intersecting point is at: (%2.3f,%2.3f)", eq.getX(), eq.getY());
		else
			System.out.println("The two lines are parallel");
	}
	
	//metoda za provjeru unosa
	static double check() {
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
