package zadaci_25_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * The StringBuilder class is provided in the Java library. Provide your own implementation for the following methods 
	 * (name the new class MyStringBuilder1):
	 * public MyStringBuilder1(String s);
	 * public MyStringBuilder1 append(MyStringBuilder1 s);
	 * public MyStringBuilder1 append(int i);
	 * public int length();
	 * public char charAt(int index);
	 * public MyStringBuilder1 toLowerCase();
	 * public MyStringBuilder1 substring(int begin, int end);
	 * public String toString();
	 */

public class MyStringBuilder1 {
	String s;
	//konstruktor za zadanim stringom
	public MyStringBuilder1(String s) {
		this.s = s;
	}
	//metoda koja dodaje string stringu
	public MyStringBuilder1 append(MyStringBuilder1 s) {
		this.s = this.s + s;
		return new MyStringBuilder1(this.s);
	}
	//metoda koja dodaje integer stringu
	public MyStringBuilder1 append(int i) {
		String str = i + "";
		this.s = this.s + str;
		return new MyStringBuilder1(this.s);
	}
	//metoda koja vraca duzinu stringa
	public int length() {
		return s.length();
	}
	//metoda koja vraca karakter na odredjenoj poziciji
	public char charAt(int index) {
		return s.charAt(index);
	}
	//metoda koja ispisuje string malim slovima
	public MyStringBuilder1 toLowerCase() {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			str += Character.toLowerCase(s.charAt(i));
		}
		return new MyStringBuilder1(str);
	}
	//metoda koja vraca substring stringa
	public MyStringBuilder1 substring(int begin, int end) {
		String s = "";
		for (int i = begin; i < end - begin; i++) {
			s += this.s.charAt(i);
		}
		return new MyStringBuilder1(s);
	}
	//override metoda za ispis stringa
	public String toString() {
		return this.s;
	}
}
