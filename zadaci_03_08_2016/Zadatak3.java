package zadaci_03_08_2016;

import java.util.Scanner;
import java.util.Arrays;

public class Zadatak3 {

	public static void main(String[] args) {
		int[] niz1 = new int[5]; 
		int[] niz2 = new int[5];
		
		Scanner input = new Scanner(System.in);
		System.out.println("Unesite prvi niz brojeva: ");
		for (int i = 0; i < niz1.length; i++) {
			niz1[i] = input.nextInt();  // input prvog niza
		}
		
		System.out.println("Unesite drugi niz brojeva: ");
		for (int i = 0; i < niz2.length; i++) {
			niz2[i] = input.nextInt();  // input drugog niza
		}
		
		input.close();
		System.out.print("Da li su nizovi identicni? " + equals(niz1, niz2));  // ispis rezultata
	}
	
	public static boolean equals(int[] niz1, int[] niz2) {
		return Arrays.equals(niz1, niz2);  // metoda koja provjerava da li su nizovi identicni
	}
}
