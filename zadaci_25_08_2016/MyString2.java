package zadaci_25_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * The String class is provided in the Java library. Provide your own implementation for the following methods (name the new class MyString2):
	 * public MyString2(String s);
	 * public int compare(String s);
	 * public MyString2 substring(int begin);
	 * public MyString2 toUpperCase();
	 * public char[] toChars();
	 * public static MyString2 valueOf(boolean b);
	 */

public class MyString2 {
	char[] ch;

	//konstruktor sa zadanim stringom
	public MyString2(String s) {
		this(s.toCharArray());
	}
	//konstruktor sa zadanim karakter nizom
	public MyString2(char[] ch) {
		this.ch = ch;
	}
	//metoda koja uporedjuje dva stringa
	public int compare(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (ch[i] > s.charAt(i)) {
				return ch[i] - s.charAt(i);
			} else if (ch[i] < s.charAt(i)) {
				return ch[i] - s.charAt(i);
			} 
		}
		if (ch.length > s.length()) {
			return ch.length - s.length();
		} else if (ch.length < s.length()) {
			return ch.length - s.length();
		} else
			return 0;
	}
	//metoda koja vraca substring stringa
	public MyString2 substring(int begin) {
		char[] chars = new char[ch.length - begin];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = ch[begin + i];
		}
		return new MyString2(chars);
	}
	//metoda koja vraca sve karaktere velikim slovima
	public MyString2 toUpperCase() {
		for (int i = 0; i < ch.length; i++) {
			ch[i] = Character.toUpperCase(ch[i]);
		}
		return new MyString2(ch);
	}
	//metoda koja vraca karaktere
	public char[] toChars() {
		return ch;
	}
	//metoda koja vraca vrijednost boolean kao string
	public static MyString2 valueOf(boolean b) {
		String s = b + "";
		return new MyString2(s);
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
