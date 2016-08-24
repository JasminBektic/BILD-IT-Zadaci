package zadaci_23_08_2016;

	/*
	 * @author Jasmin Bektic
	 */

public class Z2_MyInteger {
	int value;
	//konstruktor zadane vrijednosti
	Z2_MyInteger(int value) {
		this.value = value;
	}
	//value-getter
	int getValue() {
		return value;
	}
	//paran broj-true
	boolean isEven() {
		return (value % 2 == 0) ? true : false;
	}
	//neparan broj-true
	boolean isOdd() {
		return (value % 2 != 0) ? true : false;
	}
	//prost broj-true
	boolean isPrime() {
		for (int i = 2; i < value; i++) {
			if (value % i == 0) {			// ako je broj djeljiv sa i, nije prost
				return false;
			}
		}
		return true;
	}
	//metoda koja ispituje da li je zadani broj paran
	static boolean isEven(int n) {
		return (n % 2 == 0) ? true : false;
	}
	//metoda koja ispituje da li je zadani broj neparan
	static boolean isOdd(int n) {
		return (n % 2 != 0) ? true : false;
	}
	//metoda koja ispituje da li je zadani broj prost
	static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {			// ako je broj djeljiv sa i, nije prost
				return false;
			}
		}
		return true;
	}
	
	static boolean isEven(Z2_MyInteger n) {
		return isEven(n);
	}
	
	static boolean isOdd(Z2_MyInteger n) {
		return isOdd(n);
	}
	
	static boolean isPrime(Z2_MyInteger n) {
		return isPrime(n);
	}
	//metoda koja ispituje jednakost zadanog broja i broja u ovoj klasi
	boolean equals(int n) {
		return (value == n) ? true : false;
	}
	
	boolean equals(Z2_MyInteger n) {
		return equals(n);
	}
	//metoda koja niz nacinjen od brojnih karaktera pretvara u int broj
	static int parseInt(char[] ch) {
		int num = 0;
		for (char ex : ch) {
			num *= 10;
			num += ex - 48;	
		}
		return num;
	}
	//metoda koja string broj pretvara u int broj
	static int parseInt(String s) {
		return Integer.parseInt(s);
	}
}
