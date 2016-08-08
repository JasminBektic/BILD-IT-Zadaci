package zadaci_08_08_2016;

import java.util.Random;
import java.util.Scanner;

public class Zadatak1 {

	public static void main(String[] args) {
		int sum = 0;
		int[] list = new int [3];  // kreiranje niza
		for (int i = 0; i < list.length; i++) {
			int rand = new Random().nextInt(10) + 1;  // random brojevi (1-10)
			sum += rand;  // suma random brojeva
			list[i] = rand;
			System.out.print(rand + " ");
		}
		System.out.println();
		boolean checkInput = true;
		do {  // restart programa u slucaju pogresnog unosa i pogresnog rezultata
			try {  
				Scanner input = new Scanner(System.in);
				System.out.println("Koji je zbir ovih brojeva?");
				int result = input.nextInt();  // unos rezultata
				if (sum == result) {
					System.out.println("Svaka cast!!");  // ispis ako je tacno
					checkInput = false;
				}
				else 
					System.out.println("Pogresan rezultat, probaj ponovo.");  // ispis ako je netacno
			}
			catch (Exception e) {
				System.out.println("Pogresan unos, probajte ponovo!");
			}
		} while (checkInput);
	}
}
