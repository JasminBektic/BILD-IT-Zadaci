package zadaci_16_08_2016;

import java.text.SimpleDateFormat;
import java.util.Calendar;

	/*
	 *  Napisati metodu koja vraæa datum i trenutaèno vrijeme.
	 */

public class Zadatak4 {

	public static void main(String[] args) {
		timeDate();				// poziv metode
	}
	
	public static void timeDate() {
		String str = new SimpleDateFormat("dd.MM.yyyy  HH:mm:ss").format(Calendar.getInstance().getTime());		// datum i vrijeme smjesteni u format
		System.out.println(str);
	}
}
