package zadaci_29_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a program that prompts the user to enter an integer m and find the smallest integer n such that m * n is a perfect 
	 * square. (Hint: Store all smallest factors of m into an array list. n is the product of the factors that appear an odd 
	 * number of times in the array list. For example, consider m = 90, store the factors 2, 3, 3, 5 in an array list. 2 and 5 
	 * appear an odd number of times in the array list. So, n is 10.)
	 * 
	 */

import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak_2 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter an integer m:");
		int m = check();		
		//ispis rezultata
		System.out.println("The smallest number n for m * n to be a perfect square is " + product (factors(m)));
		System.out.println("m * n is " + product (factors(m)) * m);
	}
	
	//metoda koja vraca produkt neparnih brojeva
	public static int product (ArrayList<Integer> list) {
		int product = 1;
		for (int i = 0; i < list.size(); i++) {
			int temp = list.get(i);			//pocetni broj za uporedjivanje
			int count = 0;
			for (int j = 0; j < list.size(); j++) {
				if (temp == list.get(j)) {		
					count++;
				}
			}
			if (count % 2 != 0) {	
				product *= temp;	//mnozimo sa novim brojem
				list.add(temp);		//dodajemo broj listi kako bi te brojeve napravili parnim
			}
		}
		return product;
	}
	
	//metoda koja vraca niz faktora nekog broja
	public static ArrayList<Integer> factors(int n) {
		ArrayList<Integer> factors = new ArrayList<>();		//kreiranje liste faktora
		int num = 2;
		while (n > 1) {
			if (n % num == 0) {			//ako nema ostatka, dodaj faktor
				factors.add(num);
				n /= num;			//podjeli broj
			} else {
				num++;
			}
		}
		return factors;
	}
	
	//metoda koja provjerava unos
	public static int check() {
		int num = 0;
		while (true) {
			try {
				num = input.nextInt();		//unos
				break;
			}
			catch (Exception e) {			//hvatanje greske
				System.out.println("Wrong input, try again:");
				input.nextLine();		//ciscenje inputa
			}
		}
		return num;
	}
}
