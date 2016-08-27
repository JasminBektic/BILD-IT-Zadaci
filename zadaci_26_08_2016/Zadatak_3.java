package zadaci_26_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write the following method that returns the maximum value in an ArrayList of integers. The method returns null if the list is null 
	 * or the list size is 0. public static Integer max(ArrayList<Integer> list)
	 * Write a test program that prompts the user to enter a sequence of numbers ending with 0, and invokes this method to return the largest 
	 * number in the input.
	 */

import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak_3 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println("Enter integers (zero closes it down):");
		while (true) {
			int num = check();
			if (num == 0) {		//ako je unos 0, prekini unos
				break;
			}
			list.add(num);
		}
		System.out.println("Largest number is " + max(list));		//ispis najveceg broja
		

	}
	//metoda koja vraca najveci integer u nizu
	public static Integer max(ArrayList<Integer> list) {
		int max = 0;
		if (list.size() == 0 || list == null) {		//ako je niz null ili 0, vrati null
			return null;
		}
		for (int i = 0; i < list.size(); i++) {
			if (max < list.get(i)) {		//ako je max manji od sledeceg broja, dodjeli novi broj maxu
				max = list.get(i);		
			}
		}
		return max;
	}
	//metoda koja provjerava unos
	static int check() {
		int num = 0;
		while (true) {
			try {
				num = input.nextInt();		//unos
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
