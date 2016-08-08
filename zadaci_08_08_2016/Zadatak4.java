package zadaci_08_08_2016;

public class Zadatak4 {

	public static void main(String[] args) {
		System.out.println("Savrseni brojevi su: ");
		for (int i = 1; i < 10000; i++) {
			int sum = 0;
			for (int j = 1; j < i; j++) {  // provjera djeljivosti sa i
				if (i % j == 0) {  // ako je i djeljiv sa j, dodaj sumi
					sum += j;
				}
			}
			if (sum == i) {  
				System.out.print(i + " ");  // ispis rezultata
			}
		}
	}
}