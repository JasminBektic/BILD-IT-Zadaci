package zadaci_27_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a method that returns the union of two array lists of integers using the following header: public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2)
	 * For example, the union of two array lists {2, 3, 1, 5} and {3, 4, 6} is {2, 3, 1, 5, 3, 4, 6}. Write a test program that prompts the user to enter two lists, each 
	 * with five integers, and displays their union. The numbers are separated by exactly one space in the output.
	 */

import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak_5 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		System.out.println("Enter 5 integers in first array:");
		//unos prvih 5 integera
		list1.add(check());
		list1.add(check());
		list1.add(check());
		list1.add(check());
		list1.add(check());
		System.out.println("Enter 5 integers in second array:");
		//unos sledecih 5 integera
		list2.add(check());
		list2.add(check());
		list2.add(check());
		list2.add(check());
		list2.add(check());
		System.out.println("The combined list is:");
		for (int ex : union(list1, list2)) {
			System.out.print(ex + " ");		//ispis kombiniranih nizova
		}
	}
	//metoda koja spaja dva niza u jedan
	public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		list1.addAll(list2);	//dodavanje liste2 u listu1
		return list1;
	}
	
	//metoda za provjeru unosa
	public static int check() {
		int num = 0;
		while (true) {
			try {
				num = input.nextInt();	//unos
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
