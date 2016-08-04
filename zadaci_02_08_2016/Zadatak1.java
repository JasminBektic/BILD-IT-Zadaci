package zadaci_02_08_2016;

public class Zadatak1 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 101; i <= 2100; i++) {
			 if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {  // uslov za prestupnu godinu (preuzet sa wikipedia :) )
			 	sum++;
			 	System.out.print(i + " ");
			 if (sum % 10 == 0)   // svakih 10 prestupnih godina - novi red
				System.out.println();
			 }
		}
		
		System.out.println("\nBroj prestupnih godina je: " + sum);  // ispis broja prestupnih godina
	}
}