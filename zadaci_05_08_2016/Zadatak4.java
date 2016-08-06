package zadaci_05_08_2016;

import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak4 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println("Unesite 10 cijelih brojeva: ");
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
		list.add(input.nextInt());  // unos elemenata u listu
		}
		
		input.close();
		System.out.println("Uneseni brojevi su: \n" + list);
		System.out.println("Obrnuto to izgleda ovako: " );
		reverse(list);  // poziv metode
	}
	
	public static void reverse(ArrayList<Integer> list) {
		while (list.size() != 0) {
		int remove = list.remove(list.size() - 1);  // oduzimanje top elementa iz liste
		System.out.print(remove + " ");  // printanje top elementa
		}
	}
}
