package zadaci_03_08_2016;

public class Zadatak1 {

	public static void main(String[] args) {
		numbers(1, 10, 3);  // poziv metode
	}
	
	public static void numbers(int firstNum, int lastNum, int numPerLine) {
		int newNumPerLine = numPerLine;  // vrijednost broja linija dodjeljujemo novoj varijabli
		for (int i = firstNum; i <= lastNum; i++ ) {
			System.out.print(i + " ");
			numPerLine--;
			if (numPerLine == 0) {  // kada vrijednost broja linija dodje na 0, program prebacuje u novi red
				System.out.println();
				numPerLine += newNumPerLine;  // ponovno vracanje vrijednosti
				}
			}
	}
}
