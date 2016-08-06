package zadaci_04_08_2016;

public class Zadatak4 {

	public static void main(String[] args) {
		
		randomNumAndUppCase();  // poziv metode
	}
	
	public static void randomNumAndUppCase() {
		final int perLine = 10;
		for (int i = 1; i <= 100; i++) {
			char letter = (char)(65 + Math.random() * 26);  // slovo A je index 65 po ASCII tabeli
			System.out.print(letter + " ");  // ispis karaktera
			if (i % perLine == 0) {  // svakih 10, novi red
				System.out.println();
			}
		}
		for (int i = 1; i <= 100; i++) {
			int x = (int) (Math.random() * 100);  // random broj od 0 - 99
			System.out.print(x + " ");  // ispis brojeva
			if (i % perLine == 0) {  // svakih 10, novi red
				System.out.println();
			}
		}
	}
}
