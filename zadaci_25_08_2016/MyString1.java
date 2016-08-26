package zadaci_25_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * The String class is provided in the Java library. Provide your own implementation for the following 
	 * methods (name the new class MyString1): 
	 * 
	 * public MyString1(char[] chars);
	 * public char charAt(int index);
	 * public int length();
	 * public MyString1 substring(int begin, int end);
	 * public MyString1 toLowerCase();
	 * public boolean equals(MyString1 s);
	 * public static MyString1 valueOf(int i);
	 */

public class MyString1 {
	char[] ch;
	//no-arg konstruktor
	MyString1() {
	}
	//konstruktor sa stringom
	MyString1(String s) {
		this(s.toCharArray());
	}
	//konstruktor sa char nizom
	public MyString1(char[] chars) {
		ch = chars;
	}
	//metoda koja vraca karakter sa odredjenim indexom
	public char charAt(int index) {
		return ch[index];
	}
	//metoda koja vraca duzinu
	public int length() {
		return ch.length;
	}
	//metoda koja vraca substring stringa
	public MyString1 substring(int begin, int end) {
		char[] chars = new char[end - begin];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = ch[begin + i];
		}
		return new MyString1(chars);
	}
	//metoda koja pretvara string u mala slova
	public MyString1 toLowerCase() {
		for (int i = 0; i < ch.length; i++) {
			ch[i] = Character.toLowerCase(ch[i]);
		}
		return new MyString1(ch);
	}
	//metoda koja poredi dva stringa
	public boolean equals(MyString1 s) {
		for (int i = 0; i < s.length(); i++) {
			if (ch[i] != s.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	//metoda koja vraca vrijednost integer argumenta
	public static MyString1 valueOf(int i) {
		char[] c = {(char) i};
		return new MyString1(c);
	}
	//override metoda za print vrijednosti
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (char ex : ch) {
			s.append(ex);
		}
		return s.toString();
	}
}