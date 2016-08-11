	/*
	 * Napisati program koji pita korisnika da unese imena tri grada te ih ispiše u 
	 * abecednom redu. Na primjer, ukoliko korisnik unese Chicago, Los Angeles i Atlanta 
	 * kao gradove, program vraæa Atlanta, Chicago, Los Angeles.
	 */
package zadaci_11_08_2016;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Zadatak1 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		System.out.println("Ispisite imena tri grada:");
		list.add(input.nextLine());			// unos gradova
		list.add(input.nextLine());		
		list.add(input.nextLine());		
		input.close();
	
		Collections.sort(list, letterOrder);		// sortiranje
		System.out.print("Gradovi poredani po abecednom redu:\n" + list);	// ispis rezultata
	}
	
	private static Comparator<String> letterOrder = new Comparator<String>() {		// kreiranje novog objekta Comparator interface
	    public int compare(String str1, String str2) {			// implementirana abstract metoda
	        int ex = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);		// racuna i mala pocetna slova u sortiran niz
	        if (ex == 0) {
	            ex = str1.compareTo(str2);
	        }
	        return ex;
	    }
	};
}
