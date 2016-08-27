package zadaci_27_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a method that removes the duplicate elements from an array list of integers using the following header: 
	 * public static void removeDuplicate(ArrayList<Integer> list) Write a test program that prompts the user to enter 
	 * 10 integers to a list and displays the distinct integers separated by exactly one space.
	 */

import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak_4 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println("Enter 10 integers:");
		for (int i = 0; i < 10; i++) {
			list.add(check());			//unos 10 integera
		}
		removeDuplicate(list);			//poziv metode
	}
	//metoda koja uklanja duplikate iz niza
	public static void removeDuplicate(ArrayList<Integer> list) {
		ArrayList<Integer> temp = new ArrayList<>();	
		temp.add(list.get(0));				//startni broj za poredjenje
		int counter = 0;
		for (int i = 0; i < list.size(); i++) {		
			for (int j = 0; j < temp.size(); j++) {
				if (temp.get(j) != list.get(i)) {		//ako broj nije isti, dodati u novu listu
					counter++;
				}
				if (counter == temp.size()) {
					temp.add(list.get(i));
				}
			}
			counter = 0;			//reset brojaca
		}
		for (int ex : temp) {
			System.out.print(ex + " ");		//ispis brojeva bez duplikata
		}
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
