package zadaci_01_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write the following method that shuffles an ArrayList of numbers:
	 * public static void shuffle(ArrayList<Number> list)
	 */

import java.util.ArrayList;

public class Zadatak_4 {

	public static void main(String[] args) {
		ArrayList<Number> list = new ArrayList<>();
		list.add(1);		//unos 5 brojeva
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.print("Original list: ");
		print(list);
		shuffle(list);
	}
	//metoda koja generise nasumicno rasporodjene brojeve
	public static void shuffle(ArrayList<Number> list) {
		System.out.print("\nShuffled list: ");
		for (int i = list.size(); i > 0; i--) {
			int index = (int) (Math.random() * i);		//nasumicni indexi
			System.out.print(list.get(index) + " ");	//print broja sa datim random indexom
			list.remove(index);			//brisanje broja s tim indexom
		}
	}
	
	//metoda za printanje liste
	public static void print(ArrayList<Number> list) {
		for (Number ex : list) {
			System.out.print(ex + " ");
		}
	}
}
