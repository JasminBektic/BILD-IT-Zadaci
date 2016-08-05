package zadaci_03_08_2016;

import java.util.Arrays;
import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
		double[] array = new double[10];  // kreiranje velicine niza
		Scanner input = new Scanner(System.in);
		
		System.out.println("Unesite 10 brojeva, mozete koristiti i decimalne brojeve: ");
		for (int i = 0; i < array.length; i++) {
			array[i] = input.nextDouble();  // input korisnika u niz
		}
		input.close();
		System.out.print(min(array));
	}
	
	public static double min(double[] array) {
		Arrays.sort(array);  // sortiranje niza
		return array[0];   // index 0 je najmanji broj u nizu
	}
}
