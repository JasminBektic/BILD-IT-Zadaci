package zadaci_26_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write the following method that shuffles the elements in an ArrayList of integers.
	 * public static void shuffle(ArrayList<Integer> list)
	 */

import java.util.ArrayList;
import java.util.Random;

public class Zadatak_5 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.print("Original list: ");
		for (int ex : list) {
			System.out.print(ex + " ");		//ispis originalne liste
		}
		System.out.println();
		System.out.print("Shuffled list: ");
		shuffle(list);			//poziv metode i ispis shuffle liste
	}
	
	//metoda koja mjenja redoslijed brojeva u listi
	public static void shuffle(ArrayList<Integer> list) {
		Random rand = new Random();
		while (list.size() != 0) {
			int index = rand.nextInt(list.size());		//broj na random indexu
			System.out.print(list.get(index) + " ");
			list.remove(index);			//kada ispisemo broj obrisati sa liste kako se ne bi ponavljao
		}
	}
}