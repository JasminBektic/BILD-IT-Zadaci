package zadaci_27_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write the following method that returns the sum of all numbers in an ArrayList: public static double sum(ArrayList<Double> list) 
	 * Write a test program that prompts the user to enter 5 numbers, stores them in an array list, and displays their sum.
	 */

import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak_3 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<>();
		System.out.println("Enter 5 numbers:");
		list.add(check());			//unos brojeva
		list.add(check());
		list.add(check());
		list.add(check());
		list.add(check());
		System.out.println("Sum is: " + sum(list));		//ispis sume
	}
	//metoda koja vraca sumu brojeva
	public static double sum(ArrayList<Double> list) {
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);			//dodaj sumi svaki broj
		}
		return sum;
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
				System.out.println("Wrong input. try again:");
				input.nextLine();
			}
		}
		return num;
	}
}
