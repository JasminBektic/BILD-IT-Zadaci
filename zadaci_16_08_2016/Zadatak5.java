package zadaci_16_08_2016;

import java.util.Scanner;

	/*
	 * Napisati program koji pita korisnika da unese cijeli broj te ispisuje piramidu svih brojeva do tog broja. 
	 * (Na primjer, ukoliko korisnik unese 7 vrh piramide je broj 1, red ispod vrha piramide je 2 1 2, red ispod je 3 2 1 2 3, red 
	 * ispod 4 3 2 1 2 3 4 itd.)
	 */

public class Zadatak5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder list = new StringBuilder();
		System.out.println("Unesite cijeli broj: ");
		int num = 0;
		do {
			try {
				num = input.nextInt();		// unos broja
				if (num < 1)
					num = Math.abs(num);
				break;
			}
			catch (Exception e) {			// hvatanje greske
				System.out.println("Pogresan unos, pokusajte ponovo:");
				input.nextLine();
			}
		} while (true);
		input.close();
		
		for (int i = 1; i < num; i++) {				// dodati razmake prvom redu
		list.append("  ");
		}
		for (int i = 1; i <= num; i++) {			// rekurzivna metoda za svako "i" i onda novi red
			list.append(row(i) + "\n");
				for (int j = i; j <= num - 2; j++) {	// dodati razmak+ svakom redu
					list.append("  ");
				}
		}
		System.out.println(list);
	}
		// rekurzivna metoda
	 public static String row(int n) {
	        if (n == 1) 
	            return "1";
	        else 
	            return n + " " + row(n - 1) + " " + n; 
	        }
}
