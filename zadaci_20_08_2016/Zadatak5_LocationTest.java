package zadaci_20_08_2016;

import java.util.Scanner;

public class Zadatak5_LocationTest {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the number of rows and columns in the array:");
		int row = checkInt();		//unos velicine reda i kolone
		int column = checkInt();
		double[][] list = new double[row][column];	//kreiran niz
		System.out.println("Enter the array:");
		in(list);
		
		//referenca za metodu i ispis najveceg broja i njegovu poziciju
		Location loc = Location.locateLargest(list);
		System.out.println("The location of the largest element is " + loc.maxValue + " at (" + loc.row + ", " + loc.column + ")");
	}
		//metoda za provjeru integer unosa
	public static int checkInt() {
		int num = 0;
		do {
			try {
				num = input.nextInt();
				if (num < 0) {		//ako je broj negativan, pretvori u pozitivan
					num = Math.abs(num);
				} 
				break;
			}
			catch (Exception e) {
				System.out.println("Wrong input, try again:");
				input.nextLine();
			}
		} while (true);
		return num;
	}
		//metoda za provjeru double unosa
	public static double checkDouble() {
		double num = 0;
		do {
			try {
				num = input.nextDouble();
				break;
			}
			catch (Exception e) {
				System.out.println("Wrong input, try again:");
				input.nextLine();
			}
		} while (true);
		return num;
	}
		//metoda za unos elemenata u matricu
	public static double[][] in(double[][] list) {
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				list[i][j] = checkDouble();
			}
		}
		return list;
	}
}
