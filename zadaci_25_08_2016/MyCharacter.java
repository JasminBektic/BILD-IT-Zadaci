package zadaci_25_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * The Character class is provided in the Java library. Provide your own implementation for this class. 
	 * Name the new class MyCharacter.
	 */

public class MyCharacter {
	char ch;
	//no-arg konstruktor
	MyCharacter() {
	}
	//konstruktor za zadanim karakterom
	MyCharacter(char ch) {
		this.ch = ch;
	}
	//metoda koja uporedjuje dva karaktera
	int compare(char ch) {
		return this.ch - ch;
	}
	//metoda koja ispituje jednakost dva karaktera
	boolean equals(char ch) {
		return (this.ch == ch) ? true : false;
	}
	
	//metoda koja zamjenjuje karakter drugim karakterom
	char replace(char ch) {
		return this.ch = ch;
	}
	//metoda koja pretvara malo slovo u veliko slovo
	char toUpperCase() {
		return Character.toUpperCase(ch);
	}
	//metoda koja vraca vrijednost karaktera
	int valueOf() {
		return (int) ch;
	}
}
