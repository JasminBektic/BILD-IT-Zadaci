package zadaci_17_08_2016;

	/*
	 * Napisati metodu sa sljedeæim headerom: public static String format(int number, int width) koja vraæa string broja sa prefiksom od jedne ili više 
	 * nula. Velièina stringa je width argument. Na primjer, ukoliko pozovemo metodu format(34, 4) metoda vraæa 0034, ukoliko pozovemo format(34, 5) 
	 * metoda vraæa 00034. Ukoliko je uneseni broj veæi nego width argument, metoda vraæa samo string broja. Npr. ukoliko pozovemo format(34, 1) metoda vraæa 34.
	 */

public class Zadatak4 {

	public static void main(String[] args) {
		System.out.println(format(34, 4));	// poziv metode i ispis
	}
		// metoda koja vraca broj nula kao prefix broja
	public static String format(int number, int width) {
		String str = "";
		String num = number + "";		// int to string
		for (int i = 0; i < (width - num.length()); i++) {	
			str = str + "0";			// dodavanje nula ispred
		}
		return str + number;
	}
}