package zadaci_25_08_2016;

public class TestMyCustomClasses {

	public static void main(String[] args) {

		//test svih metoda iz Zad1
		MyString1 str = new MyString1("JaSkiO");
		System.out.println("Zadatak 1 test: (JaSkiO)");
		System.out.println("Prvo slovo: " + str.charAt(0));
		System.out.println("Duzina: " + str.length());
		System.out.println("Substring (1, 3): " + str.substring(1, 3));
		System.out.println("Jednakost: " + str.equals(new MyString1("JaSkiO")));
		System.out.println("Malim slovima: " + str.toLowerCase());
		System.out.println("Vrijednost broja 69: " + MyString1.valueOf(69));
		
		//test svih metoda iz Zad2
		MyString2 s = new MyString2("JaSkiO56");
		System.out.println();
		System.out.println("Zadatak 2 test: (JaSkiO56)");
		System.out.println("Poredjenje (jaskio56): " + s.compare("jaskio56"));
		System.out.println("Substring (2): " + s.substring(2));
		System.out.println("Karakteri: " + s.toString());
		System.out.println("String boolean: " + MyString2.valueOf(true));
		System.out.println("Velika slova: " + s.toUpperCase());
		
		//test svih metoda iz Zad3
		MyCharacter ch = new MyCharacter('a');
		System.out.println();
		System.out.println("Zadatak 3 test: (a)");
		System.out.println("Poredjenje (b): " + ch.compare('b'));
		System.out.println("Jednakost: " + ch.equals('b'));
		System.out.println("Veliko slovo: " + ch.toUpperCase());
		System.out.println("Vrijednost karaktera a je: " + ch.valueOf());
		System.out.println("Novi karakter: " + ch.replace('b'));
		
		//test svih metoda iz Zad5
		MyStringBuilder1 build = new MyStringBuilder1("Jasmin");
		System.out.println();
		System.out.println("Zadatak 5 test: (Jasmin)");
		System.out.println("Dodaj string:" + build.append(new MyStringBuilder1("Bektic")));
		System.out.println("Dodaj integer: " + build.append(10));
		System.out.println("Duzina: " + build.length());
		System.out.println("Karakter: " + build.charAt(0));
		System.out.println("Substring (0, 3): " + build.substring(0, 3));
		System.out.println("Mala slova: " + build.toLowerCase());
	}
}
