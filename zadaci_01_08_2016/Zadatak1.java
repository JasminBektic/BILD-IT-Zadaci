package zadaci_01_08_2016;

import java.util.ArrayList;
import java.util.Random;

public class Zadatak1 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();  // kreiranje liste
		for (int i = 0; i < 10; i++) {
			list.add(new Random().nextInt(51));  // dodjeljeni random brojevi
		}
				// ispis rezultata
		System.out.println("Niz: \n" + list + "\nNajveci broj je " + max(list));
	}
				// metoda za pronalazenje max broja 
	public static Integer max(ArrayList<Integer> list) {
		int max = 0;
		if (list == null || list.isEmpty()) { 
			return null;
		}
		else
			for (Integer ex : list) {
				if (ex > max) {
					max = ex;
				}
			}
		return max;
	}
}
