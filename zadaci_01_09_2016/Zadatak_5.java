package zadaci_01_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write the following method that sorts an ArrayList of numbers.
	 * public static void sort(ArrayList<Number> list)
	 */

import java.util.ArrayList;

public class Zadatak_5 {

	public static void main(String[] args) {
		ArrayList<Number> list = new ArrayList<>();
		list.add(5);		//unos 5 brojeva
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(2);
		System.out.print("Original array: ");
		print(list);		//poziv metoda i print
		sort(list);
	}
	//metoda za sortiranje niza brojeva
	public static void sort(ArrayList<Number> list) {
		Comparable<Number> max;
		int maxIndex;
		for (int i = list.size() - 1; i >= 1; i--) {
			max = (Comparable) list.get(i);		//startni max broj i index
			maxIndex = i;
			for (int j = i - 1; j >= 0; j--) {
				if (max.compareTo(list.get(j)) < 0) {
					max = (Comparable) list.get(j);
					maxIndex = j;
				}
			}
			if (maxIndex != i) {			//ako nije isti index, dodijeli novi
				list.set(maxIndex, list.get(i));
				list.set(i, (Number) max);
			}
		}
		System.out.print("\nSorted array: ");
		print(list);			//printanje sortiranje liste
	}
	//metoda za printanje liste
	public static void print(ArrayList<Number> list) {
		for (Number ex : list) {
			System.out.print(ex + " ");
		}
	}
}