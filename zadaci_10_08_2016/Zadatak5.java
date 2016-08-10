package zadaci_10_08_2016;

import java.util.Scanner;

public class Zadatak5 {
	/*
	 * Napisati program koji pita korisnika da unese dva stringa te provjerava i ispisuje 
	 * da li je drugi string substring prvog stringa. Na primjer, ukoliko korisnik unese 
	 * ABCD kao prvi string a BC kao drugi string program mu ispisuje da je BC substring 
	 * ABCD stringa.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Unesite prvi string:");
		String str1 = input.nextLine().toUpperCase();	// unos prvog stringa i pretvorba u velika slova
		System.out.println("Unesite drugi string:");
		String str2 = input.nextLine().toUpperCase();	// unos drugog stringa i pretvorba u velika slova
		input.close();
											// ispis rezultata
		String str = (str1.indexOf(str2) < 0) ? str2+" nije substring od "+str1 : str2+" je substring od "+str1;
		System.out.println(str);
	}
}