	/*
	 * Ako pozovemo metodu System.currentTimeMillis() dobijemo broj milisekundi od 
	 * 1. januara 1970 do trenutka pozivanja metode. Napisati program koji ispisuje 
	 * trenutaèni datum i vrijeme u formatu "Trenutni datum i vrijeme: 22. juli, 2015 19:59:47"
	 */
package zadaci_11_08_2016;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Zadatak3 {

	public static void main(String[] args) {
		long timeMillis = System.currentTimeMillis();		// milisekundi od 1. januara 1970 god.
		Date date = new Date(timeMillis);
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MMMM, yyyy HH:mm:ss");    // kreiranje objekta SDF za format vremena
		System.out.println("Trenutni datum i vrijeme: " + sdf.format(date));	  // ispis vremena i datuma
	}
}
