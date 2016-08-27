package zadaci_27_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write the following method that sorts an ArrayList of numbers: public static void sort(ArrayList<Integer> list) 
	 * Write a test program that prompts the user to enter 5 numbers, stores them in an array list, and displays them 
	 * in increasing order.
	 */

import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak_2 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println("Enter 5 numbers:");
		list.add(check());			//unos integera
		list.add(check());
		list.add(check());
		list.add(check());
		list.add(check());
		sort(list);			//poziv metoda i sortiranje niza

	}
	//selektivna metoda za sortiranje integera u rastucem nizu
	public static void sort(ArrayList<Integer> list) {
		for (int i = list.size() - 1; i >= 1; i--) {
			int max = list.get(0);		//startna vrijednost max i maxIndex
			int maxIndex = 0;
			for (int j = 1; j <= i; j++) {
				if (max < list.get(j)) {	//ako je max manji od sledeceg broja u listi, dodaj tu vrijednost maxu
					max = list.get(j);
					maxIndex = j;			//novi index
				}
			}
			if (maxIndex != i) {
				list.set(maxIndex, list.get(i));
				list.set(i, max);
			}
		}
		for (int ex : list) {
			System.out.print(ex + " ");		//ispis integera u rastucem redoslijedu
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
