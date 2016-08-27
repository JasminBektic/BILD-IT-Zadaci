package zadaci_26_08_2016;

/*
 * @author Jasmin Bektic
 * 
 * 
 * Design a class named Triangle that extends GeometricObject. The class contains:
 * ■ Three double data fields named side1, side2, and side3 with default values 1.0 to denote three sides of the triangle.
 * ■ A no-arg constructor that creates a default triangle.
 * ■ A constructor that creates a triangle with the specified side1, side2, and side3.
 * ■ The accessor methods for all three data fields.
 * ■ A method named getArea() that returns the area of this triangle.
 * ■ A method named getPerimeter() that returns the perimeter of this triangle.
 * ■ A method named toString() that returns a string description for the triangle.
 * 
 * Draw the UML diagrams for the classes Triangle and GeometricObject and implement the classes. Write a test program that prompts the user to enter three sides of the triangle, 
 * a color, and a Boolean value to indicate whether the triangle is filled. The program should create a Triangle object with these sides and set the color and filled properties 
 * using the input. The program should display the area, perimeter, color, and true or false to indicate whether it is filled or not.
 */

import java.util.Scanner;

public class Zadatak_1Test {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//unos vrijednosti za trougao
		System.out.println("Enter values for triangle sides: ");
		double side1 = check();
		double side2 = check();
		double side3 = check();
		//unos boje
		System.out.println("Enter color:");
		String color = input.next();
		//unos boolean vrijednosti
		System.out.println("Enter boolean value:");
		boolean filled = true;
		while (filled) {
			try {
				filled = input.nextBoolean();
				break;
			}
			catch (Exception e) {
				System.out.println("Only TRUE or FALSE allowed, try again:");
				input.nextLine();
			}
		}
		//kreiranje objekta klase i ispis rezultata
		Triangle triangle2 = new Triangle(side1, side2, side3);
		triangle2.setColor(color);
		triangle2.setFilled(filled);
		System.out.println(triangle2.toString());
	}
	//metoda koja provjerava unos
	public static double check() {
		double num = 0;
		while (true) {
			try {
				num = input.nextDouble();	//unos
				break;
			}
			catch (Exception e) {			//hvatanje greske
				System.out.println("Wrong input, try again:");
				input.nextLine();
			}
		}
		return num;
	}
}
